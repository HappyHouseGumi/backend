package com.jsg.house.notice.model.service;

import java.util.HashMap;
import java.util.List;

import com.jsg.house.notice.model.dto.Notice;

public interface NoticeService {

	List<Object> listNotice() throws Exception;

	int writeNotice(Notice notice) throws Exception;

	List<Object> viewNotice(String noticeId) throws Exception;

	int modifyNotice(HashMap<String, Object> map) throws Exception;

	int deleteNotice(String noticeId) throws Exception;
	
}
