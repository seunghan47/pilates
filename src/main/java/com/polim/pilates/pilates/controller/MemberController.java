package com.polim.pilates.pilates.controller;

import com.polim.pilates.pilates.entity.Member;
import com.polim.pilates.pilates.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/register")
    public Member createMember(@RequestBody Member member) {

        return memberService.registerMember(member);
    }

    @GetMapping("/get")
    public List<Member> viewAll() {
        return memberService.viewAll();
    }
}
