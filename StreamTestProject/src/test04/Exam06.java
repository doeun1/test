package test04;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;



public class Exam06 {
	public static void main(String[] args) {
		List<Employee> employees = EmpDAO.getEmpLists();
		Map<String, List<Employee>> departments = employees.stream().collect(Collectors.groupingByConcurrent(new Function<Employee, String>() {

			@Override
			public String apply(Employee t) {
				return t.getJobId();
			}
			
		},Collectors.toList())); 
		Set<String> set = departments.keySet();
		for (String g : set) {
			System.out.println(g);
			List<Employee> set1 = departments.get(g);
			for(Employee e : set1) {
				System.out.println(e);
			}
		}

	}
}
