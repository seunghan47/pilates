package com.polim.pilates.pilates.service;

import com.polim.pilates.pilates.repository.MemberRepository;
import org.springframework.stereotype.Service;
import com.polim.pilates.pilates.entity.Member;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member registerMember(Member member) {

        Optional<Member> existingMember = memberRepository.findByEmail(member.getEmail());
        if (existingMember.isPresent()) {
            throw new IllegalStateException("This email is already registered in the studio.");
        }

        return memberRepository.save(member);
    }

    public void deleteMember(String email) {

        Optional<Member> existingMember = memberRepository.findByEmail(email);
        if (existingMember.isEmpty()) {
            throw new IllegalStateException("member with " + email + " does not exist");
        }

        memberRepository.delete(existingMember.get());
    }

    public List<Member> viewAll() {
        return memberRepository.findAll();
    }
}
