package com.bezkoder.springjwt.security.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Comment;
import com.bezkoder.springjwt.repository.CommentRepository;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }
    // 댓글 생성    
    public Comment createComment(Comment comment) {
        Comment createdComment = commentRepository.save(comment);
        return createdComment;
    }
    //댓글 수
    public Comment updateComment(Long commentId, Comment updatedComment) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + commentId));
        comment.setContent(updatedComment.getContent());
        comment.setUpdatedAt(LocalDateTime.now()); 
        Comment savedComment = commentRepository.save(comment);
        return savedComment;
    }
    //댓글 삭제 
    public void deleteComment(Long commentId) {
    	commentRepository.deleteById(commentId);
    }
    //Board_id값과 연결
    public List<Comment> getCommentsByBoardId(Long boardId) {
        return commentRepository.findByBoardId(boardId);
    }

    
}

