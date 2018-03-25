package com.volunteer.controller;

import com.volunteer.pojo.*;
import com.volunteer.pojo.vo.ArticleVO;
import com.volunteer.pojo.vo.EntryVO;
import com.volunteer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yelei
 * @date 18-3-24
 */
@Controller

public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private EntryFormService entryFormService;
    @Autowired
    private UserService userService;
    @Autowired
    private TeamUserService teamUserService;
    @RequestMapping("/teamLogin")
    @ResponseBody
    public Map<String, Object> toteamLogin(Team team, HttpServletRequest request){
        Team team1=teamService.findTeamByLoginNameAndPassword(team.getLoginName(),team.getPassword());
        Map<String, Object> resultMap = new LinkedHashMap<>();
        if (team1!=null){
            resultMap.put("status",200);
            resultMap.put("message","登录成功");
            request.getSession().setAttribute("team",team1);
        }else {
            resultMap.put("status",500);
            resultMap.put("message","请输入正确的信息");
        }
        return resultMap;
    }
    @RequestMapping("/teamIndex")
    public String teamIndex(Model model,HttpServletRequest request){
        Team team= (Team) request.getSession().getAttribute("team");
        model.addAttribute("team",team);
        return "teamIndex";
    }
    //查看活动申请
    @RequestMapping("/seeReply")
    public String seeReply(Model model,HttpServletRequest request){
        Team team= (Team) request.getSession().getAttribute("team");
        if (team==null){
            return "toLogin";
        }else {
            List<Article> articles= articleService.findByTeamId(team.getId());
            for (int i=0;i<articles.size();i++){
                Article article=articles.get(i);
                if (!article.getAllowEntry())
                    continue;
                List<EntryForm> entryForms=entryFormService.findByAid(article.getId());
                List<EntryVO> entryVOS=new ArrayList<>();
                for (int j=0;j<entryForms.size();j++){
                    EntryVO entryVO=new EntryVO();
                    entryVO.setId(article.getId());
                    entryVO.setContent(article.getContent());
                    entryVO.setTitle(article.getTitle());
                    User user=userService.findById(entryForms.get(j).getUserId());
                    entryVO.setUserId(user.getId());
                    entryVO.setUsername(user.getUsername());
                    entryVO.setAge(user.getAge());
                    entryVOS.add(entryVO);
                }
                System.out.println(entryVOS);
                model.addAttribute("entry",entryVOS);
            }
            return "seeReplys";
        }
    }
    @RequestMapping("/checkEntryApply")
    public String checkEntryApply(@RequestParam("articleId")Long articleId,@RequestParam("userId")Long userId,@RequestParam("isAllow")Integer isAllow){
        EntryForm entryForm=entryFormService.findByArticleIdAndUserId(articleId,userId);
        if (isAllow==0){
            entryForm.setState(2);
        }else {
            entryForm.setState(1);
        }
        entryFormService.save(entryForm);
        return "redirect:/seeReply";
    }
    @RequestMapping("/checkApply")
    public String checkApply(@RequestParam("userId")Long userId, @RequestParam("isAllow") Integer isAllow, HttpSession session){
        Team team= (Team) session.getAttribute("team");
        TeamUser teamUser=teamUserService.findByTeamIdAndUserId(team.getId(),userId);
        //不同意
        if (isAllow==0){
            teamUser.setState(1);
        }else{
            teamUser.setState(2);
        }
        teamUserService.save(teamUser);
        return "redirect:/seeReply";

    }
    @RequestMapping("/seeNumber")
    public String seeNumber(Model model,HttpServletRequest request){
        Team team=(Team)request.getSession().getAttribute("team");
        if (team==null){
            return "toLogin";
        }else {
            List<TeamUser> teamUsers=teamUserService.findByTeamId(team.getId());
            List<User> users=new ArrayList<>();
            for (int i=0;i<teamUsers.size();i++){
                User user=userService.findById(teamUsers.get(i).getUserId());
                users.add(user);
            }
            model.addAttribute("user",users);
        }
        return "seeNumber";
    }
    @RequestMapping("/teamInfo")
    public String teamInfo(Model model, @RequestParam("id") Long id){
        String teamName=teamService.findById(id).getTeamName();
        List<ArticleVO> articleVOList=new ArrayList<>();
        for (Article article : articleService.findByTeamId(id)) {
            ArticleVO articleVO=new ArticleVO();
            articleVO.setTitle(article.getTitle());
            articleVO.setContent(article.getContent());
            articleVO.setInsertTime(article.getInsertTime());
            articleVO.setTeamName(teamName);
            articleVO.setId(article.getId());
            if (article.getAllowEntry()){
                articleVO.setIsInsert("1");
            }else {
                articleVO.setIsInsert("0");
            }
            articleVOList.add(articleVO);
        }

        model.addAttribute("article",articleVOList);
        return "teamActivity";

    }

}
