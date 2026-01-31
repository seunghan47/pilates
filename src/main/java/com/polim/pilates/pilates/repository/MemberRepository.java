package com.polim.pilates.pilates.repository;

import com.polim.pilates.pilates.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
