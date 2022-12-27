package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;


//JpaRepository는 User 테이블을 관리하는 Repository이고 User테이블의 PK는 Integer이다.
//JpaRepository는 findAll을 가지고 있고, findAll은 User테이블에 있는걸 다 받아내라라는 뜻
//DAO = Data Access Object
//스프링부트로 치면 빈으로 자동으로 등록이 된다.@Repository가 생략이 가능하다. 
public interface UserRepository extends JpaRepository<User, Integer>{

	// SELECT * FROM user WHERE username =1?;
	Optional<User> findByUsername(String username);
	
	//JPA naming 쿼리
	// SELECT * FROM user WHERE username = username AND password =password;
	//User findByUsernameAndPassword(String username, String password);
	
	/*
	@Query(value="SELECT * FROM user WHERE username = ?1 AND password =?2", nativeQuery = true)
	User login(String username, String password);
	*/
}
