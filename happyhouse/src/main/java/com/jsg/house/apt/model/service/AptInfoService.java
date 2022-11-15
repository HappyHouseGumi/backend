package com.jsg.house.apt.model.service;

import java.util.List;

public interface AptInfoService {
	List<Object> getAptList(String code) throws Exception;
}
