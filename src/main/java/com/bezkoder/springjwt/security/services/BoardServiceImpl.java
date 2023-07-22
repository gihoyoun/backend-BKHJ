package com.bezkoder.springjwt.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Board;
import com.bezkoder.springjwt.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepo;

	@Override
	public Board saveBoard(Board board) {
		return boardRepo.save(board);
	}

	@Override
	public List<Board> getAllBoard() {
		return boardRepo.findAll();
	}

	@Override
	public Board getBoardById(Long id) {
		return boardRepo.findById(id).get();
	}

	@Override
	public String deleteBoard(Long id) {
		Board board = boardRepo.findById(id).get();

		if (board != null) {
			boardRepo.delete(board);
			return "게시판이 성공적으로 삭제되었습니다.";
		}
		return "Something wrong on server";
	}

	@Override
	public Board editBoard(Board b, Long id) {
		Board oldBoard = boardRepo.findById(id).get();

		oldBoard.setTitle(b.getTitle());
		oldBoard.setContent(b.getContent());
		oldBoard.setRegdate(b.getRegdate());
		oldBoard.setWriter(b.getWriter());

		return boardRepo.save(oldBoard);
	}

	@Override
	public void updateViewCount(Long id) {
		Board board = boardRepo.findById(id).get();
		if (board != null) {
			board.setViewCount(board.getViewCount() + 1);
			boardRepo.save(board);
		}
	}
}