package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 댓글과 관련된 데이터베이스 조작을 위한 메서드 선언
    // 예를 들어, 게시물 ID를 기반으로 댓글 조회, 댓글 생성, 댓글 수정, 댓글 삭제 등의 메서드를 추가할 수 있습니다.
	 List<Comment> findByBoardId(Long boardId);
}
