package com.jsg.house.data.model.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

	@Override
	public List<Object> getNews() {
		final String Url = "https://search.naver.com/search.naver?where=news&ie=utf8&sm=nws_hty&query=%EB%B6%80%EB%8F%99%EC%82%B0";
        Connection conn = Jsoup.connect(Url);
        List<Object> list = new ArrayList<>();
        try {
            Document document = conn.get();
            Elements imageUrlElements = document.getElementsByClass("news_tit");

            for (Element element : imageUrlElements) {
            	String[] str = element.attr("abs:title").split("/");
            	HashMap<String,String> map = new HashMap<String,String>();
            	map.put("title", element.attr("abs:title").split("/")[str.length-1]);
            	map.put("href", element.attr("abs:href"));
            	list.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return list;
	}

}
