package com.jsg.house.apt.model.service;

import java.util.HashMap;
import java.util.List;

public interface AptInfoService {
	List<Object> getAptList(String code) throws Exception;
	List<Object> getDongNameAptList(String dongName) throws Exception;
	List<Object> getsidogugunAptList(HashMap<String, String> map)throws Exception;
}
