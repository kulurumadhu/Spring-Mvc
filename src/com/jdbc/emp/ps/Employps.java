package com.jdbc.emp.ps;

import java.util.List;

import com.jdbc.emp.vo.EmployVO;

public interface Employps {

	public void createTable();

	public int insertEmpInfo(EmployVO employVO);

	public int updateEmpInfo(int empId, int salary);

	public int deleteEmpInfoById(int empId);

	public EmployVO readEmpInfoById(int empId);

	public List<EmployVO> readAllEmpInfo();

	public boolean deleteAllEmploy();

}
