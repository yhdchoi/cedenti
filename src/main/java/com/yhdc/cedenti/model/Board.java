package com.yhdc.cedenti.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@ToString(exclude = "writer")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;

	@Column(length = 50, nullable = false)
	private String title;
	@Column(columnDefinition = "text", nullable = false)
	private String body;
	@Column(nullable = false)
	private boolean board_privacy;

	@ManyToOne(fetch = FetchType.LAZY)
	private Member writer;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd HH:mm")
	@CreationTimestamp()
	private LocalDateTime created;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd HH:mm")
	@UpdateTimestamp
	private LocalDateTime updated;

	public void changeTitle(String title) {
		this.title = title;
	}

	public void changeBody(String body) {
		this.body = body;
	}

}
