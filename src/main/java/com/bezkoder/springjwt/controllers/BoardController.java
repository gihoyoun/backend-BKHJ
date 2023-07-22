package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Board;
import com.bezkoder.springjwt.security.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시판 등록

    @PostMapping("/saveBoard")
    public ResponseEntity<Long> saveBoard(@RequestBody Board board) {
        Board savedBoard = boardService.saveBoard(board);
        return new ResponseEntity<>(savedBoard.getId(), HttpStatus.CREATED);
    }

    // 게시판 목록
    @GetMapping("/listBoard")
    public ResponseEntity<?> getAllBoard() {
        return new ResponseEntity<>(boardService.getAllBoard(), HttpStatus.OK);
    }


    // 게시판 삭제
    @GetMapping("deleteBoard/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id) {
        return new ResponseEntity<>(boardService.deleteBoard(id), HttpStatus.OK);
    }

    // 게시판 수정
    @PostMapping("editBoard/{id}")
    public ResponseEntity<?> editBoard(@RequestBody Board board, @PathVariable Long id) {
        return new ResponseEntity<>(boardService.editBoard(board, id), HttpStatus.CREATED);
    }
    
    // 게시물 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable Long id) {
        boardService.updateViewCount(id);
        return new ResponseEntity<>(boardService.getBoardById(id), HttpStatus.OK);
    }
}