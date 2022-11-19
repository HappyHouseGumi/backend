package com.jsg.house.notice.model.service;

import java.util.HashMap;
import java.util.List;

import com.jsg.house.notice.model.dto.Notice;

public interface NoticeService {

	List<Object> listNotice(HashMap<String, Object> map);

	void writeNotice(Notice notice);

	List<Object> viewNotice(String noticeId);

	void modifyNotice(HashMap<String, Object> map);

	void deleteNotice(String noticeId);
	
}
