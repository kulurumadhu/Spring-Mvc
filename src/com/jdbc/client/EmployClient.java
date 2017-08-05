package com.jdbc.client;

import java.util.List;
import java.util.Scanner;

import com.jdbc.emp.bs.EmployBs;
import com.jdbc.emp.bs.bean.EmployBsBean;
import com.jdbc.emp.vo.EmployVO;

public class EmployClient {

	private static EmployBs employBs = null;

	public static void main(String[] args) {
		System.out.println("EmployTable information");
		System.out.println("Enter into emp table Info Method press 1");
		System.out.println("Enter into EmpInsert Info method press 2");
		System.out.println("Enter into EmpUpdate method press 3");
		System.out.println("Enter into DeleteEmploy by empid press 4 ");
		System.out.println("Enter into ReadEmpINfoById method press 5");
		System.out.println("Enter into ReadAllEmpInfo Method press 6");
		System.out.println("Enter Delete all empInfo method 7");
		System.out.println("");

		Scanner scanner = new Scanner(System.in);
		int clientInput = scanner.nextInt();
		if (clientInput > 0) {
			employBs = new EmployBsBean();
		}
		switch (clientInput) {
		case 1:
			System.out.println("enter 1 for create emp table");
			int num = scanner.nextInt();
			// System.out.println("enter 1 for create emp table");
			employBs.createTable();

			break;
		case 2:
			// System.out.println("enter 4 for insert empInfo");
			EmployVO employVO = new EmployVO();
			System.out.println("enter employ id");
			employVO.setEmpId(scanner.nextInt());
			System.out.println("enter employName");
			employVO.setEmpName(scanner.next());
			System.out.println("enter employSalary");
			employVO.setSalary(scanner.nextInt());
			System.out.println(employBs.insertEmpInfo(employVO) + " record insert into table successfully");
			break;

		case 3:
			// System.out.println("enter 6 for updateEmp");
			System.out.println("enter employId");
			int empId = scanner.nextInt();
			System.out.println("enter employ salary");
			int salary = scanner.nextInt();
			System.out.println(employBs.updateEmpInfo(empId, salary) + "  record updated successfully");
			break;
		case 4:
			System.out.println("enter employId");
			int empId1 = scanner.nextInt();
			System.out.println(employBs.deleteEmpInfoById(empId1) + " Record deleted successfully");

			break;
		case 5:
			System.out.println("enter employId");
			int empId2 = scanner.nextInt();
			employVO = employBs.getEmpINfoByIdempId(empId2);
			System.out.println(empId2 + "Read emp Info By id");
			if (employVO != null) {
				System.out.println(employVO.getEmpId());
				System.out.println(employVO.getEmpName());
				System.out.println(employVO.getSalary());

				break;
			}
		case 6:
			System.out.println("Readall emp Info method ");

			List<EmployVO> employVOs = employBs.getAllEmployInfo();
			if (employVOs.isEmpty()) {
				System.out.println("employ table is empty");
			} else {
				for (EmployVO emVo : employVOs) {
					System.out.println("EmpId----->" + emVo.getEmpId());
					System.out.println("EmpName----->" + emVo.getEmpName());
					System.out.println("Empsalary----->" + emVo.getSalary());
					System.out.println("Successfully read all employs");
				}
			}
			break;
		case 7:
			System.out.println("enter Delete All Employ's method");
			
		boolean	flag = employBs.deleteAllEmploy();
			if (flag) {
				System.out.println(" all employs are not deleted");
			} else {
				System.out.println("All employs deleted");
			}
			break;
		}
	}

}
