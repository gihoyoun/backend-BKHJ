package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.FileDB;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Long> {
	
	 List<FileDB> findByBoardId(Long boardId);

}