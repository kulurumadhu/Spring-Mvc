package com.jdbc.emp.bs.bean;

import java.util.List;

import com.emp.connection.EmployFactory;
import com.jdbc.emp.bs.EmployBs;
import com.jdbc.emp.ps.Employps;
import com.jdbc.emp.ps.bean.EmployPsBean;
import com.jdbc.emp.vo.EmployVO;

public class EmployBsBean implements EmployBs {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		Employps employps = EmployFactory.getEmployPsBeanInstance();
		employps.createTable();
	}

	@Override
	public int insertEmpInfo(EmployVO employVO) {
		// TODO Auto-generated method stub
		Employps employps = EmployFactory.getEmployPsBeanInstance();

		int result = employps.insertEmpInfo(employVO);

		return result;
	}

	@Override
	public int updateEmpInfo(int empId, int salary) {

		Employps employps = EmployFactory.getEmployPsBeanInstance();
		int result = employps.updateEmpInfo(empId, salary);
		return result;
	}

	@Override
	public int deleteEmpInfoById(int empId) {

		Employps employps = EmployFactory.getEmployPsBeanInstance();
		int result = employps.deleteEmpInfoById(empId);
		return result;
	}

	@Override
	public EmployVO getEmpINfoByIdempId(int empId) {

		Employps employps = EmployFactory.getEmployPsBeanInstance();
		EmployVO result = employps.readEmpInfoById(empId);

		return result;

	}

	@Override
	public List<EmployVO> getAllEmployInfo() {
		Employps employps = EmployFactory.getEmployPsBeanInstance();
		List<EmployVO> result = employps.readAllEmpInfo();
		return result;
	}

	@Override
	public boolean deleteAllEmploy() {

		Employps employps = EmployFactory.getEmployPsBeanInstance();
		return employps.deleteAllEmploy();

	}

}
