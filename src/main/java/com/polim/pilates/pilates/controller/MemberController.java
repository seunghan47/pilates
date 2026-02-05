package com.polim.pilates.pilates.controller;

import com.polim.pilates.pilates.entity.Member;
import com.polim.pilates.pilates.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/{memberId}/enroll/{classId}")
    public Member enrollMember(@PathVariable Long memberId, @PathVariable Long classId) {

        return memberService.enrollMemberInClass(memberId, classId);
    }

    @PostMapping("/register")
    public Member createMember(@Valid @RequestBody Member member) {

        return memberService.registerMember(member);
    }

    @GetMapping("/get")
    public List<Member> viewAll() {
        return memberService.viewAll();
    }
}
