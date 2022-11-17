package com.jsg.house.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	
	@Bean
	public Docket userApi() {
		final ApiInfo apiInfo = new ApiInfoBuilder().title("Happy House API")
				.description("<h3>UserApi에 대한 문서를 제공한다.</h3>")
				.version("0.0").build();

		return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
				.apiInfo(apiInfo) // 문서에 대한 정보를 설정한다.
				.groupName("2. User")
				.select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.apis(RequestHandlerSelectors.basePackage("com.jsg.house.user"))// 대상으로하는 api 설정
				.paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
				.build();  // Docket 객체 생성
	}
	@Bean
	public Docket boardApi() {
		final ApiInfo apiInfo = new ApiInfoBuilder().title("게시판관리 API")
				.description("<h3>BoardApi에 대한 문서를 제공한다.</h3>")
				.version("0.0").build();
		
		return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
				.apiInfo(apiInfo) // 문서에 대한 정보를 설정한다.
				.groupName("3. Board")
				.select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.apis(RequestHandlerSelectors.basePackage("com.jsg.house.board"))// 대상으로하는 api 설정
				.paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
				.build();  // Docket 객체 생성
	}
	@Bean
	public Docket noticeApi() {
		final ApiInfo apiInfo = new ApiInfoBuilder().title("공지사항관리 API")
				.description("<h3>NoticeApi에 대한 문서를 제공한다.</h3>")
				.version("0.0").build();
		
		return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
				.apiInfo(apiInfo) // 문서에 대한 정보를 설정한다.
				.groupName("4. Notice")
				.select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.apis(RequestHandlerSelectors.basePackage("com.jsg.house.notice"))// 대상으로하는 api 설정
				.paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
				.build();  // Docket 객체 생성
	}
	@Bean
	public Docket interestApi() {
		final ApiInfo apiInfo = new ApiInfoBuilder().title("관심지역 관리 API")
				.description("<h3>InterestApi에 대한 문서를 제공한다.</h3>")
				.version("0.0").build();
		
		return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
				.apiInfo(apiInfo) // 문서에 대한 정보를 설정한다.
				.groupName("5. Interest")
				.select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.apis(RequestHandlerSelectors.basePackage("com.jsg.house.interest"))// 대상으로하는 api 설정
				.paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
				.build();  // Docket 객체 생성
	}
	@Bean
	public Docket LikeApi() {
		final ApiInfo apiInfo = new ApiInfoBuilder().title("추천게시판 관리 API")
				.description("<h3>LikeApi에 대한 문서를 제공한다.</h3>")
				.version("0.0").build();
		
		return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
				.apiInfo(apiInfo) // 문서에 대한 정보를 설정한다.
				.groupName("6. Like")
				.select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.apis(RequestHandlerSelectors.basePackage("com.jsg.house.like"))// 대상으로하는 api 설정
				.paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
				.build();  // Docket 객체 생성
	}
	
	@Bean
	public Docket AptApi() {
		final ApiInfo apiInfo = new ApiInfoBuilder().title("아파트 관리 API")
				.description("<h3>AptApi에 대한 문서를 제공한다.</h3>")
				.version("0.0").build();
		
		return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
				.apiInfo(apiInfo) // 문서에 대한 정보를 설정한다.
				.groupName("7. Apt")
				.select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.apis(RequestHandlerSelectors.basePackage("com.jsg.house.apt"))// 대상으로하는 api 설정
				.paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
				.build();  // Docket 객체 생성
	}
	
	@Bean
	public Docket QnAApi() {
		final ApiInfo apiInfo = new ApiInfoBuilder().title("QnA API")
				.description("<h3>QnA Api에 대한 문서를 제공한다.</h3>")
				.version("0.0").build();
		
		return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
				.apiInfo(apiInfo) // 문서에 대한 정보를 설정한다.
				.groupName("8. QnA")
				.select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.apis(RequestHandlerSelectors.basePackage("com.jsg.house.qna"))// 대상으로하는 api 설정
				.paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
				.build();  // Docket 객체 생성
	}
	
	@Bean
	public Docket QnACommentApi() {
		final ApiInfo apiInfo = new ApiInfoBuilder().title("QnA Comment API")
				.description("<h3>QnA Api에 대한 문서를 제공한다.</h3>")
				.version("0.0").build();
		
		return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
				.apiInfo(apiInfo) // 문서에 대한 정보를 설정한다.
				.groupName("9. QnA Comment")
				.select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.apis(RequestHandlerSelectors.basePackage("com.jsg.house.qnacomment"))// 대상으로하는 api 설정
				.paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
				.build();  // Docket 객체 생성
	}
	
	@Bean
	public Docket EmailCommentApi() {
		final ApiInfo apiInfo = new ApiInfoBuilder().title("Email  API")
				.description("<h3>Email API에 대한 문서를 제공한다.</h3>")
				.version("0.0").build();
		
		return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
				.apiInfo(apiInfo) // 문서에 대한 정보를 설정한다.
				.groupName("10. Email Comment")
				.select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.apis(RequestHandlerSelectors.basePackage("com.jsg.house.email"))// 대상으로하는 api 설정
				.paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
				.build();  // Docket 객체 생성
	}
	
	@Bean
	public Docket AllApi() {
		final ApiInfo apiInfo = new ApiInfoBuilder().title("전체 API")
				.description("<h3>모든 Api에 대한 문서를 제공한다.</h3>")
				.version("0.0").build();
		
		return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
				.apiInfo(apiInfo) // 문서에 대한 정보를 설정한다.
				.groupName("1. 전체")
				.select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.apis(RequestHandlerSelectors.basePackage("com.jsg.house"))// 대상으로하는 api 설정
				.paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
				.build();  // Docket 객체 생성
	}
	
	
}
