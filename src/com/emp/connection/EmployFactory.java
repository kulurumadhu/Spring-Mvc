package com.emp.connection;

import com.jdbc.emp.bs.bean.EmployBsBean;
import com.jdbc.emp.ps.Employps;
import com.jdbc.emp.ps.bean.EmployPsBean;

public class EmployFactory {

	private static Employps employps = null;

	public static Employps getEmployPsBeanInstance() {
		if (employps == null) {
			employps = new EmployPsBean();
		}
		return employps;
	}

}
