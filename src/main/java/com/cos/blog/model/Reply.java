package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {

	@Id //Primary Key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; //시퀀스, auto.increment
	
	@Column(nullable=false, length=200)
	private String Content;

	@ManyToOne
	@JoinColumn(name="boardId") //연관관계
	private Board board;
	
	@ManyToOne //여러개의 답변을 하나의 User가 달수있다.
	@JoinColumn(name="userId") 
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;
}
