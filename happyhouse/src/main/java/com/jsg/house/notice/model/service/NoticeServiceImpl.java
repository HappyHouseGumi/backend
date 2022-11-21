package com.jsg.house.notice.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.exception.NoDataException;
import com.jsg.house.exception.NotChangeDataException;
import com.jsg.house.notice.model.dto.Notice;
import com.jsg.house.notice.model.mapper.NoticeMapper;
import com.jsg.house.util.SizeConstant;

@Service
public class NoticeServiceImpl implements NoticeService {

	private NoticeMapper mapper;

	@Autowired
	public NoticeServiceImpl(NoticeMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public List<Object> listNotice(HashMap<String, Object> map) {

		HashMap<String, Object> param = new HashMap<String, Object>();
		// param.put("key", map.get("key") == null ? "" : (String)map.get("key"));
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = (Integer)map.get("pgno") == null ? 1 : (Integer)map.get("pgno");
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);

		List<Object> noticeList = null;

		try {
			noticeList = mapper.listNotice(param);
			if (noticeList == null || noticeList.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}

		return noticeList;
	}

	@Override
	public void writeNotice(Notice notice) {
		int checkSum = 0;
		try {
			checkSum = mapper.writeNotice(notice);
			if (checkSum != 1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public List<Object> viewNotice(String noticeId) {
		List<Object> vnotice = null;

		try {
			vnotice = mapper.viewNotice(noticeId);
			if (vnotice == null || vnotice.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}

		return vnotice;
	}

	@Override
	public void modifyNotice(HashMap<String, Object> map) {
		int checkSum = 0;
		try {
			checkSum = mapper.modifyNotice(map);
			if (checkSum != 1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public void deleteNotice(String noticeId) {
		int checkSum = 0;
		try {
			checkSum = mapper.deleteNotice(noticeId);
			if (checkSum != 1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public int getTotalNotice(HashMap<String, Object> map) {
		int checkSum = 0;
		try {
			checkSum = mapper.getTotalNotice(map);
			if (checkSum == -1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
		return checkSum;
	}
}
