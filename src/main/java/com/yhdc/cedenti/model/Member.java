package com.yhdc.cedenti.model;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(columnDefinition = "text", nullable = false)
	private String address;
	
	// member or sitter
	@Column(length = 10, nullable = false)
	private String role;
	// admin or manager or user
	@Column(length = 20, nullable = false)
	private String authority;
	// default = true 
	@Column(length = 20, nullable = false)
	private boolean active;

	@CreationTimestamp
	private LocalDateTime created;
	@UpdateTimestamp
	private LocalDateTime updated;
}
