package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.SampleVO;

@RestController
public class HelloRestController {

		@RequestMapping("/")
		public String index() {
			return "hello world!@@%%s";
		}
		
		@RequestMapping("/test")
		public String test() {
			return "hello world~~~!!!!";
		}
		
		
		@RequestMapping("/SampleVO")
		public SampleVO sendSampleVO() {
			SampleVO vo = new SampleVO();
			
			vo.setMno(593);
			vo.setFirstName("길동");
			vo.setLastName("홍");
			
			return vo;
		}
}
