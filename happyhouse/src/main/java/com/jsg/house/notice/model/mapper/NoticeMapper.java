package com.jsg.house.notice.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.notice.model.dto.Notice;

public interface NoticeMapper {

	List<Object> listNotice() throws SQLException;

	int writeNotice(Notice notice) throws SQLException;

	List<Object> viewNotice(String noticeId) throws SQLException;

	int modifyNotice(HashMap<String, Object> map) throws SQLException;

	int deleteNotice(String noticeId) throws SQLException;

}
