package com.volunteer.controller;

import com.volunteer.pojo.Notice;
import com.volunteer.pojo.Team;
import com.volunteer.pojo.TeamUser;
import com.volunteer.pojo.User;
import com.volunteer.service.NoticeService;
import com.volunteer.service.TeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * @author yelei
 * @date 18-3-25
 */
@Controller
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private TeamUserService teamUserService;
    @RequestMapping("/seeNotice")
    public String seeNotice(Model model, HttpServletRequest request){
        Team team= (Team) request.getSession().getAttribute("team");
        List<Notice> notices=noticeService.findAll(team.getId());
        model.addAttribute("notice",notices);
        return "syNotice";
    }
    @RequestMapping("/seeTeamNotice")
    public String seeTeamNotice(Model model,HttpServletRequest request){
        Team team= (Team) request.getSession().getAttribute("team");
        List<Notice> notices=noticeService.findTeamNotice(team.getId());
        model.addAttribute("notice",notices);
        return "teamNotice";
    }
    @RequestMapping("/userSeeNotice")
    public String userSeeNotice(Model model,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        List<TeamUser> teamUser=teamUserService.findByUserId(user.getId());
        List<List<Notice>> notices=new ArrayList<>();
        for (int i=0;i<teamUser.size();i++){
            List<Notice> notice=noticeService.findAll(teamUser.get(i).getTeamId());
            notices.add(notice);
        }
        model.addAttribute("notice",notices);
        return "UserSyNotice";
    }
    @RequestMapping("/userSeeTeamNotice")
    public String userSeeTeamNotice(Model model,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        List<TeamUser> teamUser=teamUserService.findByUserId(user.getId());
        List<List<Notice>> notices=new ArrayList<>();
        for (int i=0;i<teamUser.size();i++){
            List<Notice> notice=noticeService.findTeamNotice(teamUser.get(i).getTeamId());
            notices.add(notice);
        }
        model.addAttribute("notice",notices);
        return "UserTeamNotice";
    }
    @RequestMapping("/addSyNotice")
    public String addSyNotice(Notice notice,HttpServletRequest request){
        Team team = (Team) request.getSession().getAttribute("team");
        notice.setType(0);
        notice.setTeamId(team.getId());
        noticeService.addNotice(notice);
        return "seeNotice";
    }
    @RequestMapping("/addTeamNotice")
    public String addTeamNotice(Notice notice,HttpServletRequest request){
        Team team = (Team) request.getSession().getAttribute("team");
        notice.setType(1);
        notice.setTeamId(team.getId());
        noticeService.addNotice(notice);
        return "seeTeamNotice";
    }
    @RequestMapping("/deleteSyNotice")
    public String delSyNotice(@RequestParam(value = "id") Long id){
        noticeService.delSyNotice(id);
        return "seeNotice";
    }
    @RequestMapping("/delTeamNotice")
    public String delTeamNotice(@RequestParam(value = "id")Long id){
        noticeService.delTeamNotice(id);
        return "seeTeamNotice";
    }

}
