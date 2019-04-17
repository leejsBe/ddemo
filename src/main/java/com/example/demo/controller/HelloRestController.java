package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Professor;
import com.example.demo.domain.SampleVO;
import com.example.demo.domain.mapper.ProfessorMapper;

@RestController
public class HelloRestController {

		@Autowired
		private ProfessorMapper professorMapper;
	
		@RequestMapping("/")
		public String index() {
			return "hello world!@@%%s";
		}
		
		@RequestMapping("/test")
		public String test() {
			return "hello world~~~!!!!";
		}
		
		
		@RequestMapping("/SampleVO")
		public List<SampleVO> sendSampleVO() {
			List<SampleVO> list = new ArrayList<SampleVO>();
			
			for(int i = 0 ; i < 10 ; i ++) {
				
				SampleVO vo = new SampleVO(); 
				
				vo.setMno(i);
				vo.setFirstName("길동"+i);
				vo.setLastName("홍");
				
				list.add(vo);
			}
			
			return list;
		}
		
		
		@RequestMapping(value="/{gpioNumber}/value",method=RequestMethod.GET)
		public ResponseEntity<String> postFunction(@PathVariable("gpioNumber") Integer gpioNumber){
			ResponseEntity<String> entity = null;
			String result = gpioNumber + " : 0";
			entity = new ResponseEntity<>(result,HttpStatus.OK);
			
			return entity;
			
		}
		
		@RequestMapping(value="/{gpioNumber}/pulseRatio/{ratio:.+}",method=RequestMethod.GET)
		public ResponseEntity<String> postPulseRatio(@PathVariable("gpioNumber") Integer gpioNumber, @PathVariable("ratio") Float ratio){
			ResponseEntity<String> entity = null;
			String result = gpioNumber + " : pulseRatio : "+ ratio;
			entity = new ResponseEntity<String>(result,HttpStatus.OK);
			
			return entity;
			
		}
		
		
		@RequestMapping(value="/professor",method=RequestMethod.GET)
		public List<Professor> getProfessorList() throws Exception{
			
			List<Professor> list = professorMapper.selectProfessorList();
			
			for(int i = 0 ; i < list.size() ; i++) {
				
			}
			
			return list;
		}
		
		
		@RequestMapping(value="/professor/{name}/{belog}/{phone}",method=RequestMethod.GET)
		public ResponseEntity<String> insertProfessor(@PathVariable("name") String name, @PathVariable("belog") String belog, @PathVariable("phone") String phone) throws Exception{
			ResponseEntity<String> entity = null;
			
			Professor professor = new Professor();
			professor.setName(name);
			professor.setBelog(belog);
			professor.setPhone(phone);
			
			int resultid = professorMapper.insertProfessor(professor);
			
			String result = "success! "+resultid;
			
			entity = new ResponseEntity<String>(result,HttpStatus.OK);
			return entity;
		}
		
		
		
}
