package com.spring.ex01.dto;

import java.sql.Date;

public class BoardDTO {
	private int idx;
	private String id; 
	private String name; 
	private String title; 
	private String content; 
	private Date writeDate;
	private int readCount;
	private int bGroup; 
	private int bStep;
	private int bIndent; 
	
	public BoardDTO() {}

	public BoardDTO(int idx, String id, String name, String title, String content, int readCount ,int bGroup, int bStep, int bIndent) {
		this.idx = idx; 
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}
	
	

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getbGroup() {
		return bGroup;
	}

	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public int getbStep() {
		return bStep;
	}

	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	public int getbIndent() {
		return bIndent;
	}

	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	
	
}
