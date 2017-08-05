package com.jdbc.emp.bs;

import java.util.List;

import com.jdbc.emp.vo.EmployVO;

public interface EmployBs {

	public void createTable();

	public int insertEmpInfo(EmployVO employVO);

	public int updateEmpInfo(int empId, int salary);

	public int deleteEmpInfoById(int empId);

	public EmployVO getEmpINfoByIdempId(int empId);

	public List<EmployVO> getAllEmployInfo();

	public boolean deleteAllEmploy();

}
