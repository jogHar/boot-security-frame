package com.joghar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joghar.payload.ResponsePayload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/public")
@Api(tags = "Public API", value = "Public API")
public class PublicController {
	@ApiOperation(value = "Get Info", response = ResponsePayload.class)
	@RequestMapping(value = "/get/info", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<ResponsePayload> getInfo() {
		Map<String, String> apiInfo = new HashMap<String, String>();
		apiInfo.put("name", "Spring boot security frame");
		apiInfo.put("version", "1.0");
		apiInfo.put("contact", "joganihardik57@gmail.com");
		return ResponseEntity.ok(new ResponsePayload(HttpStatus.OK.value(), "Api Information", apiInfo));
	}
}
