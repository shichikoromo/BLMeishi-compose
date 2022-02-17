package com.ayasakinui.twitterservice.view;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Optional;

import com.ayasakinui.twitterservice.dataAccess.entity.Member;
import com.ayasakinui.twitterservice.service.memberdomService;
//Member Objectのエンティティにicon URLを追加要

@Controller
public class MainController {

    @RequestMapping(value = "dom/{domId}")//各domのページ
    public String domPage(Model model, @PathVariable("domId") Long domId) {
        memberdomService memberdomService = new memberdomService();
        List<Long> memberIds = memberdomService.findMemberIds(domId);
        List<Optional> memberList = memberdomService.findMembers(memberIds);
        model.addAttribute("memberList", memberList);
        return "hello";
    }
    
}
