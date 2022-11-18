package com.jsg.house.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jsg.house.config.HttpFlag;
import com.jsg.house.user.model.dto.User;
import com.jsg.house.user.model.service.JwtService;
import com.jsg.house.user.model.service.UserService;

@RequestMapping("/naver")
@RestController
@CrossOrigin
public class RestOauthController {
	
	private HttpFlag flag = new HttpFlag();
	
	@Autowired
	private UserService service;
	
	@Autowired
	private JwtService JwtService;
	
	@PostMapping
	public ResponseEntity<?> authNaver(@RequestBody HashMap<String,String> tokens) {
		//ResponseEntity<?> response = requestAccessToken(generateAuthCodeRequest(code,state));
		
		List<Object> data = new ArrayList<Object>();
		HashMap<String, String> map = new HashMap<>();
		flag.setFlag("success");
		JSONParser jsonParser = new JSONParser(); 
		JSONObject jsonObject = null;
		String accessToken = tokens.get("access_token");
		int userId = 0;
		try {
//			jsonObject = (JSONObject) jsonParser.parse(response.getBody().toString());
//			accessToken = jsonObject.get("access_token").toString();
			userId = service.findUserByOauth(accessToken);
			String jwToken = JwtService.createToken(userId);
			map.put("access-token", jwToken);
			data.add(map);
			flag.setData(data);
		} catch (Exception e) {
			userId = -1;
		}
		if(userId == -1) {
			String email = "";
			ResponseEntity<?> email_response = requestProfile(generateProfileRequest(accessToken));
			try {
				jsonObject = (JSONObject) jsonParser.parse(email_response.getBody().toString());
				jsonObject = (JSONObject) jsonParser.parse(jsonObject.get("response").toString());
				email = jsonObject.get("email").toString();
				userId = service.findUserByEmail(email);
				System.out.println(email);
				System.out.println(userId);
				//내려오면 유저가 있다는 뜻임 
				HashMap<String, Object> OauthMap = new HashMap<String, Object>();
				OauthMap.put("id", userId);
				OauthMap.put("oauth", accessToken);
				service.addUserOauth(OauthMap);
				
				String jwToken = JwtService.createToken(userId);
				map.put("access-token", jwToken);
				data.add(map);
				flag.setData(data);
				
			} catch (ParseException e) {
				flag.setFlag("fail");
				map.put("msg", "파싱 불가");
				data.add(map);
				flag.setData(data);
				e.printStackTrace();
			} catch (Exception e) {
//				e.printStackTrace();
				HashMap<String, Object> OauthMap = new HashMap<String, Object>();
				int cnt;
				try {
					cnt = service.countOauth();
					User user = new User();
					user.setEmail(email);
					user.setPassword("test");
					user.setNickName("네이버"+cnt);
					System.out.println(accessToken);
					user.setOauth(accessToken);
					service.registOauthUser(user);
					System.out.println(user);
					userId = service.findUserByEmail(email);
					System.out.println(userId);
					String jwToken = JwtService.createToken(userId);
					map.put("access-token", jwToken);
					data.add(map);
					flag.setData(data);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
        return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
    }

	private ResponseEntity<String> requestAccessToken(HttpEntity request) {
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.exchange("https://nid.naver.com/oauth2.0/token", HttpMethod.POST, request, String.class);
	}
	private HttpEntity<MultiValueMap<String, String>> generateProfileRequest(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+ accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        return new HttpEntity<>(headers);
    }
	 private ResponseEntity<String> requestProfile(HttpEntity request) {
	        RestTemplate restTemplate = new RestTemplate();
	        return restTemplate.exchange(
	                "https://openapi.naver.com/v1/nid/me",
	                HttpMethod.POST,
	                request,
	                String.class
	        );
	    }
	private HttpEntity<MultiValueMap<String, String>> generateAuthCodeRequest(String code, String state) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "sTS2XWnrv1VAaHN25n9w");
		params.add("client_secret", "uxNdvP47Dd");
		params.add("code", code);
		params.add("state", state);
		return new HttpEntity<>(params, headers);
	}
}
