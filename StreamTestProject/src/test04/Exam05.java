package test04;

import java.util.List;
import java.util.function.Consumer;

public class Exam05 {
	static double sum = 0;
	
	public static void main(String[] args) {
		List<Employee> employees = EmpDAO.getEmpLists();
		
		employees.stream().forEach(new Consumer<Employee>() {

			@Override
			public void accept(Employee t) {
				sum = t.getSalary()+sum;
			}
			
		});
		
		long cut = employees.stream().count();
		System.out.println(sum/cut);
	}
}
