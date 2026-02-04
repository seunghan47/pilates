package com.polim.pilates.pilates.service;

import com.polim.pilates.pilates.entity.PilatesClass;
import com.polim.pilates.pilates.repository.MemberRepository;
import com.polim.pilates.pilates.repository.PilatesClassRepository;
import org.springframework.stereotype.Service;
import com.polim.pilates.pilates.entity.Member;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PilatesClassRepository pilatesClassRepository;

    public MemberService(MemberRepository memberRepository, PilatesClassRepository pilatesClassRepository) {
        this.memberRepository = memberRepository;
        this.pilatesClassRepository = pilatesClassRepository;
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

    public Member enrollMemberInClass(long memberId, long classId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("Member not found"));
        PilatesClass pClass = pilatesClassRepository.findById(classId)
                .orElseThrow(() -> new IllegalStateException("Class not found"));

        if (pClass.getEnrolledMembers().size() >= pClass.getCapacity()) {
            throw new IllegalStateException("This class is fully booked!");
        }

        if (member.getEnrolledClasses().contains(pClass)) {
            throw new IllegalStateException("Member is already enrolled in this class.");
        }

        member.getEnrolledClasses().add(pClass);

        return memberRepository.save(member);

    }
}
