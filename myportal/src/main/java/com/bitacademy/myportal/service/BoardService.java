package com.bitacademy.myportal.service;

import java.util.List;

import com.bitacademy.myportal.vo.BoardVo;

public interface BoardService {
	public List<BoardVo> getList();		// 게시물 목록
	public boolean write(BoardVo vo);		// 게시믈 추가
	public BoardVo getContent(Long no);		// 게시물 조회
	public boolean update(BoardVo vo);		// 게시물 수정
}
