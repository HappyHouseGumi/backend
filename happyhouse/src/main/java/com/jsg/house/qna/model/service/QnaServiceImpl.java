package com.jsg.house.qna.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.exception.NoDataException;
import com.jsg.house.exception.NotChangeDataException;
import com.jsg.house.qna.model.dto.Qna;
import com.jsg.house.qna.model.mapper.QnaMapper;
import com.jsg.house.util.SizeConstant;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaMapper mapper;

	@Override
	public List<Object> listQna() {
		List<Object> qnaList = null;
		try {
			qnaList = mapper.listQna();
			if (qnaList == null || qnaList.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}
		return qnaList;
	}

	@Override
	public List<Object> listQnaPaging(HashMap<String, Object> map) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("key", map.get("key") == null ? "" : (String) map.get("key"));
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = (Integer) map.get("pgno") == null ? 1 : (Integer) map.get("pgno");
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);

		List<Object> qanaList = null;
		try {
			qanaList = mapper.listQnaPaging(param);
			if (qanaList == null || qanaList.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}
		return qanaList;
	}

	@Override
	public void addQna(Qna qna) {
		int checkSum = 0;
		try {
			checkSum = mapper.addQna(qna);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public void deleteQna(int id) {
		int checkSum = 0;
		try {
			checkSum = mapper.deleteQna(id);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public void modifyQna(HashMap<String, Object> map) {
		int checkSum = 0;
		try {
			checkSum = mapper.modifyQna(map);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public Object detailQna(int id) {
		Object detailObject = null;
		try {
			detailObject = mapper.detailQna(id);
			if (detailObject == null) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}
		return detailObject;
	}

	@Override
	public List<Object> searchQna(HashMap<String, Object> map) {
		List<Object> qnaList = null;
		try {
			qnaList = mapper.searchQna(map);
			if (qnaList == null || qnaList.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}
		return qnaList;
	}

	@Override
	public int getTotalQna(HashMap<String, Object> map) {
		int checkSum = 0;
		try {
			checkSum = mapper.getTotalQna(map);
			if (checkSum == -1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			throw new NotChangeDataException();
		}
		return checkSum;
	}

}
