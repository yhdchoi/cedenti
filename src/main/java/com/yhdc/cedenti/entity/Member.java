package com.yhdc.cedenti.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(updatable = false)
	private Long member_id;

	@Column(length = 20, nullable = false)
	private String password;
	@Column(length = 20, nullable = false)
	private String email;
	
	@Column(length = 20, nullable = false)
	private String username;
	@Column(length = 20, nullable = false)
	private String lastname;
	@Column(length = 20, nullable = false)
	private String firstname;
	
	@Column(length = 20, nullable = false)
	private String phone;
	@Column(length = 100, nullable = false)
	private String address;
	
	@Column(length = 20, nullable = false)
	private String role;
	@Column(length = 20, nullable = false)
	private String authority;
	@Column(length = 20, nullable = false)
	private boolean active;

	@CreationTimestamp
	private LocalDateTime created;
	@UpdateTimestamp
	private LocalDateTime updated;
}
