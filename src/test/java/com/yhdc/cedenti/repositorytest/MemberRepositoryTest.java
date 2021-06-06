package com.yhdc.cedenti.repositorytest;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yhdc.cedenti.entity.Member;
import com.yhdc.cedenti.repository.MemberRepository;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void insertMembers() {

		IntStream.rangeClosed(1,50).forEach(i -> {

			Member member = Member.builder().username("USER" + i).password("1111").email("user" + i + "@aaa.com")
					.phone("1231234").address("AbcSt. Toronto Canada").role("Developer").authority("user").active(true)
					.build();

			memberRepository.save(member);
		});
	}
	
	
}
