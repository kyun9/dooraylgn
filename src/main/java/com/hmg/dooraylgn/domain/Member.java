package com.hmg.dooraylgn.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity // JPA가 관리하는 엔티티
@Data
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id는 pk 시퀀스이다. DB가 알아서 생성해주는게 IDENTITY이다.
	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}