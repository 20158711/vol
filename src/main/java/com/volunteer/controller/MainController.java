package com.volunteer.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.volunteer.pojo.*;
import com.volunteer.pojo.vo.ArticleVO;
import com.volunteer.pojo.vo.TeamVO;
import com.volunteer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamUserService teamUserService;
    @Autowired
    private EntryFormService entryFormService;
    @RequestMapping("/toLogin")
    public String test(){
        return "login";
    }
    @RequestMapping("/index")
    public String index(Model model,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "index";
    }
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
    @RequestMapping("/activity")
    public String  activity(Model model,HttpServletRequest request){
        List<ArticleVO> articleVOS=new ArrayList<>();
        List<Article> articles=articleService.findAll();
        for (int i=0;i<articles.size();i++){
            System.out.println(articles.get(i).getTeamId());
            Team team=teamService.findById(articles.get(i).getTeamId());
            System.out.println(team);
            ArticleVO articleVO=new ArticleVO();
            articleVO.setId(articles.get(i).getId());
            articleVO.setTitle(articles.get(i).getTitle());
            articleVO.setContent(articles.get(i).getContent());
            articleVO.setTeamName(team.getTeamName());
            articleVO.setInsertTime(articles.get(i).getInsertTime());
            if (articles.get(i).getAllowEntry().equals(true)){
                articleVO.setIsInsert("1");
            }else {
                articleVO.setIsInsert("0");
            }
            articleVOS.add(articleVO);
        }
        User user= (User) request.getSession().getAttribute("user");
        if (user==null){
            return "/toLogin";
        }else {
            List<EntryForm> entryForms=entryFormService.findByUserId(user.getId());
            List<ArticleVO> articleVOS1=new ArrayList<>();
            for (int j=0;j<entryForms.size();j++){
                Article article=articleService.findById(entryForms.get(j).getArticleId());
                Team team=teamService.findById(article.getTeamId());
                ArticleVO articleVO=new ArticleVO();
                articleVO.setId(article.getId());
                articleVO.setInsertTime(article.getInsertTime());
                articleVO.setTitle(article.getTitle());
                articleVO.setContent(article.getContent());
                articleVO.setTeamName(team.getTeamName());
                if (entryForms.get(j).getState()==0){
                    articleVO.setIsInsert("0");
                }else {
                    articleVO.setIsInsert("1");
                }
                articleVOS1.add(articleVO);

            }
            model.addAttribute("article", articleVOS);
            model.addAttribute("articles",articleVOS1);
            model.addAttribute("user", user);
            return "activity";
        }
    }
    @RequestMapping("/userLogin")
    @ResponseBody
    public Map<String, Object> userLogin(User user, HttpServletRequest request){
        User user1=userService.findUserByLoginNameAndPassword(user.getLoginName(),user.getPassword());
        Map<String, Object> resultMap = new LinkedHashMap<>();
        if (user1!=null){
            resultMap.put("status",200);
            resultMap.put("message","登录成功");
            resultMap.put("message","登录成功");
            request.getSession().setAttribute("user",user1);
        }else {
            resultMap.put("status",500);
            resultMap.put("message","请输入正确的信息");
        }
        return resultMap;
    }
    @RequestMapping("/userInfo")
    public String userInfo(@RequestParam(value = "id")Long id,Model model){
        User user=userService.findById(id);
        model.addAttribute("user",user);
        return "userInfo";

    }
    @RequestMapping("/modifyInfo")
    @ResponseBody
    public Map<String,Object> modify(User user){
        userService.updateById(user);
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("message","修改成功");
        return resultMap;
    }
    @RequestMapping("/reply")
    @ResponseBody
    public Map<String,Object> reply(@RequestParam(value = "id")Long id,Model model,HttpServletRequest request){
        //System.out.println("tste");
        User user= (User) request.getSession().getAttribute("user");
        EntryForm entryForm=entryFormService.applyAddToTeam(id,user.getId());
        Map<String, Object> resultMap = new LinkedHashMap<>();
        if (entryForm!=null){
            resultMap.put("status",200);
            resultMap.put("message","已申请，等待审核");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","已申请过该活动");
        }
        return resultMap;
    }
//    @RequestMapping("/toTeam")
//    public String toTeam(Model model){
//        List<TeamVO> teamVOS=new ArrayList<>();
//        List<Team> teams=teamService.findAll();
//
//    }
    @RequestMapping("/toTeam")
    public String toTeam(Model model,HttpServletRequest request){
        List<TeamVO> teamVOS=new ArrayList<>();
        List<Team> teams=teamService.findAll();
        //所有团队
        for (int i=0;i<teams.size();i++){
            TeamVO teamVO=new TeamVO();
            Team team=teams.get(i);
            teamVO.setId(team.getId());
            teamVO.setTeamName(team.getTeamName());
            User user1=userService.findById(team.getLeader());
            teamVO.setUsername(user1.getUsername());
            teamVO.setIntroduce(team.getIntroduce());
            teamVOS.add(teamVO);
        }
        //加入的团队
        User user= (User) request.getSession().getAttribute("user");
        if (user==null){
            return "toLogin";
        }else {
            List<TeamUser> teamUsers=teamUserService.findByUserId(user.getId());
            List<TeamVO> teamVOList=new ArrayList<>();
            for (int j=0;j<teamUsers.size();j++){
                Team team=teamService.findById(teamUsers.get(j).getTeamId());
                TeamVO teamVO=new TeamVO();
                teamVO.setId(team.getId());
                teamVO.setTeamName(team.getTeamName());
                teamVO.setIntroduce(team.getIntroduce());
                User user1=userService.findById(teams.get(j).getLeader());
                teamVO.setUsername(user1.getUsername());
                teamVO.setIntroduce(team.getIntroduce());
                teamVO.setState(teamUsers.get(j).getState());
                teamVOList.add(teamVO);
            }
            model.addAttribute("teams1",teamVOS);
            model.addAttribute("teams",teamVOList);
            return "team";
        }
    }



    //注册
    @RequestMapping("/userRegister")
    @ResponseBody
    public Map<String, Object> userRsgister(User user,HttpServletRequest request){
        Map<String, Object> resultMap = new LinkedHashMap<>();
        User user1=userService.findUserByLoginNameAndPassword(user.getLoginName(),user.getPassword());
        if (user1==null){
            user.setAge(0);
            user.setUsername("**");
            userService.save(user);
            request.getSession().setAttribute("user",user);
            resultMap.put("status",200);
            resultMap.put("message","注册成功");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","该账户已经存在");
        }
        return resultMap;

    }


    @RequestMapping("/toTeamRegister")
    public String toTeamRegister(){
        return "TeamRegister";
    }

}
