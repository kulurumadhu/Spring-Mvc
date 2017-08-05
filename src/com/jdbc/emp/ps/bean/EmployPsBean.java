package com.jdbc.emp.ps.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.emp.connection.DBConnection;
import com.emp.connection.DBPropertiesI;
import com.emp.connection.DBQueryI;
import com.jdbc.emp.ps.Employps;
import com.jdbc.emp.vo.EmployVO;
import com.mysql.jdbc.ResultSet;

public class EmployPsBean implements Employps {

	private static Connection con = null;
	private PreparedStatement ps = null;
	private Statement statement = null;
	private int count = 0;
	private ResultSet rs = null;
	private EmployVO employVO = null;

	public void createTable() {
		try {
			con = DBConnection.getConnectionInstance();
			// ps=con.prepareStatement(DBQueryI.CREATE_TABLE);
			statement = con.createStatement();
			statement.execute(DBQueryI.CREATE_TABLE);
			System.out.println("Employ table created successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int insertEmpInfo(EmployVO employVO) {

		try {
			con = DBConnection.getConnectionInstance();
			ps = con.prepareStatement(DBQueryI.INSERT_EMPINFO);
			ps.setInt(1, employVO.getEmpId());
			ps.setString(2, employVO.getEmpName());
			ps.setInt(3, employVO.getSalary());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;

	}

	@Override
	public int updateEmpInfo(int empId, int salary) {

		try {
			con = DBConnection.getConnectionInstance();
			ps = con.prepareStatement(DBQueryI.UPDATE_EMPINFO_BY_EMPID);
			ps.setInt(1, salary);
			ps.setInt(2, empId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;

	}

	@Override
	public int deleteEmpInfoById(int empId) {
		// TODO Auto-generated method stub
		try {
			con = DBConnection.getConnectionInstance();
			ps = con.prepareStatement(DBQueryI.DELETE_EMPiNFO_BY_EMPID);
			ps.setInt(1, empId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public EmployVO readEmpInfoById(int empId) {
		try {
			con = DBConnection.getConnectionInstance();
			ps = con.prepareStatement(DBQueryI.READ_EMPINFO_BYID);
			ps.setInt(1, empId);
			rs = (ResultSet) ps.executeQuery();
			if (rs.next()) {
				employVO = new EmployVO();
				employVO.setEmpId(rs.getInt(1));
				employVO.setEmpName(rs.getString(2));
				employVO.setSalary(rs.getInt(3));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employVO;

	}

	@Override
	public List<EmployVO> readAllEmpInfo() {
		List<EmployVO> employVOs = new ArrayList<EmployVO>();

		try {
			con = DBConnection.getConnectionInstance();
			ps = con.prepareStatement(DBQueryI.READ_ALL_EMP_INFO);
			rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				employVO = new EmployVO();
				employVO.setEmpId(rs.getInt(1));
				employVO.setEmpName(rs.getString(2));
				employVO.setSalary(rs.getInt(3));
				employVOs.add(employVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employVOs;
	}

	@Override
	public boolean deleteAllEmploy() {
		boolean flag = false;
		try {
			con = DBConnection.getConnectionInstance();
			ps = con.prepareStatement(DBQueryI.DELETE_ALL_EMP_INFO);
			ps.executeUpdate();
			if (count > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;

	}

}
