package test04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmpDAO {
//입력
	public static List<Employee> getEmpLists() {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from employees" ;
		ObservableList<Employee> list = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getDate("hire_date").toLocalDate());
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
			
				list.add(emp);
			}
			
			System.out.println("--end of data--");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
