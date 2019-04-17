package com.example.demo.domain.mapper;

import java.util.List;
import com.example.demo.domain.Professor;

public interface ProfessorMapper {
	
	public List<Professor> selectProfessorList() throws Exception;
	
	public int insertProfessor(Professor professor) throws Exception;

}
