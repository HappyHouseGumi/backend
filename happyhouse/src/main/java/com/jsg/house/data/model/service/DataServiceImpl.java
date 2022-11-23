package com.jsg.house.data.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.data.model.mapper.RegionDealMapper;
import com.jsg.house.exception.NoDataException;

@Service
public class DataServiceImpl implements DataService {
	
	private RegionDealMapper mapper;
	
	@Autowired
	public DataServiceImpl(RegionDealMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public List<Object> getNews() {
		final String Url = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=101&sid2=260";
		Connection conn = Jsoup.connect(Url);
		List<Object> list = new ArrayList<>();
		try {
			Document document = conn.get();
			Elements elements = document.getElementsByClass("type06_headline");
			for (Element element : elements.select("li")) {
				HashMap<String, String> map = new HashMap<String, String>();
				String title = "";
				String href = "";
				if (element.getElementsByClass("photo").size() != 0) {
					title = element.select("dt").next().first().select("a").text();
					href = element.select("dt").next().first().select("a").attr("abs:href");
				} else {
					title = element.select("dt").first().select("a").text();
					href = element.select("dt").first().select("a").attr("abs:href");
				}
				map.put("title", title);
				map.put("href", href);
				list.add(map);
			}
			for (Element element : elements.select("li")) {
				HashMap<String, String> map = new HashMap<String, String>();
				String title = element.select("dt").next().first().select("a").text();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Object> getAvgDeal(String sidoName) {
		sidoName = sidoName.replaceAll("\"", "");
		List<Object> avgList = null;

		try {
			avgList = mapper.getAvgDeal(sidoName);
			if (avgList == null || avgList.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}

		return avgList;
	}

}
