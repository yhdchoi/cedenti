package com.yhdc.cedenti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhdc.cedenti.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
