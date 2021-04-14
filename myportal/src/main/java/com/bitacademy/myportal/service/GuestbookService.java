package com.bitacademy.myportal.service;

import java.util.List;

import com.bitacademy.myportal.vo.GuestbookVo;

public interface GuestbookService {
	public List<GuestbookVo> getList();
	public boolean writeMessage(GuestbookVo vo);		// 게시물 작성 메서드
	public boolean deleteMessage(GuestbookVo vo);		// 게시물 삭제 메서드
}
