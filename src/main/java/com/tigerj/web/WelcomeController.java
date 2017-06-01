/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tigerj.web;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class WelcomeController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";
	
	@GetMapping
	public String welcome(Map<String, Object> model) {
		//model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}

	@GetMapping("/hello")
	public String hello(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
	
	@GetMapping("/yingxiang")
	public String yingXiangUpload(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "uploadFile";
	}
	
	@GetMapping("/restGet")
	public ResponseEntity<String> restGet(){
		return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@GetMapping("/restGet2")
	public RestResponse<String> restGet2(){
		return new RestResponse<String>("hello tigerj.");
	}

	@RequestMapping("/fail")
	public String fail() {
		throw new Gk5Exception("Oh dear!");
	}

	@RequestMapping("/fail2")
	public String fail2() {
		throw new IllegalStateException();
	}

	@ExceptionHandler(Gk5Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody RestResponse<String> handleRuntimeException(Gk5Exception exception) {
		return new RestResponse<String>("Some data I want to send back to the client.");
	}

}