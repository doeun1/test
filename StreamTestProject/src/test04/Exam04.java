package test04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Member {
	String name;
	int english;
	int math;	
	public Member() {
	}
	public Member(String name, int english, int math) {
		this.name = name;
		this.english = english;
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", english=" + english + ", math=" + math + "]";
	}
	
}

public class Exam04 {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("a",80,50),
				new Member("b",50,20),
				new Member("c",40,30),
				new Member("d",60,10));
		
		Stream<Member> member = list.stream();
				List<Member> sum = member.filter(new Predicate<Member>() {

			@Override
			public boolean test(Member t) {
				return (t.getEnglish()+t.getMath()) <100;
			}
			
		}).collect(Collectors.toList());
				System.out.println(sum);
	}
}
