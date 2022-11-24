package com.jsg.house.interest.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.exception.NoDataException;
import com.jsg.house.exception.NotChangeDataException;
import com.jsg.house.interest.model.dto.Interest;
import com.jsg.house.interest.model.mapper.InterestMapper;

@Service
public class InterestServiceImpl implements InterestService {
	
	@Autowired
	private InterestMapper mapper;
	
	@Override
	public List<Object> getInterests(int userid) {
		List<Object> interestList = null;

		try {
			interestList = mapper.getInterests(userid);
			if (interestList.size() == 0) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}

		return interestList;
	}

	@Override
	public void addInterests(Interest interest) {
		int checkSum = 0;
		try {
			checkSum = mapper.addInterests(interest);
			if (checkSum != 1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public void deleteInterests(Interest interest) {
		int checkSum = 0;
		try {
			checkSum = mapper.deleteInterests(interest);
			if (checkSum != 1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public List<Object> getRankingIntersts(int sidoCode) {
		List<Object> rankingList = null;

		try {
			rankingList = mapper.getRankingIntersts(sidoCode);
			if (rankingList == null || rankingList.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}

		return rankingList;
	}

}
