package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.Board;

import java.util.List;

public interface BoardService {

	Board saveBoard(Board board);

	List<Board> getAllBoard();

	Board getBoardById(Long id);

	String deleteBoard(Long id);

	Board editBoard(Board board, Long id);

	void updateViewCount(Long id);
}