package com.jsg.house.notice.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.notice.model.dto.Notice;
import com.jsg.house.notice.model.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	private NoticeMapper mapper;
	
	@Autowired
	public NoticeServiceImpl(NoticeMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public List<Object> listNotice() throws Exception {
		return mapper.listNotice();
	}

	@Override
	public int writeNotice(Notice notice) throws Exception {
		return mapper.writeNotice(notice);
	}

	@Override
	public List<Object> viewNotice(String noticeId) throws Exception {
		return mapper.viewNotice(noticeId);
	}

	@Override
	public int modifyNotice(HashMap<String, Object> map) throws Exception {
		return mapper.modifyNotice(map);
	}

	@Override
	public int deleteNotice(String noticeId) throws Exception {
		return mapper.deleteNotice(noticeId);
	}

}
