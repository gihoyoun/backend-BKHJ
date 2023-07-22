package com.bezkoder.springjwt.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String content;
	private String writer;
	private String regdate;
	private Long totalPages;
	private Long totalCounts;
	private int viewCount;

	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FileDB> files;

	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments;

	public Board() {
	}

	// Constructor with id parameter
	public Board(Long id) {
		this.id = id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public Long getTotalCounts() {
		return totalCounts;
	}

	public void setTotalCounts(Long totalCounts) {
		this.totalCounts = totalCounts;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
}