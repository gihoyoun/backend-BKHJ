package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>{
	

}
