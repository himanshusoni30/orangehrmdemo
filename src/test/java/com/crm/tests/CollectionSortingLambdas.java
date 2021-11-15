package com.crm.tests;

import java.util.ArrayList;
import java.util.Comparator;

public class CollectionSortingLambdas {
	public static void main(String[] args) {
		ArrayList<Employee> l = new ArrayList<>();
		l.add(new Employee("Nemo",12345));
		l.add(new Employee("Lemo",22345));
		l.add(new Employee("Memo",32345));
		l.add(new Employee("Remo",42345));
		l.add(new Employee("Semo",52345));
		l.add(new Employee("Temo",62345));
		l.add(new Employee("Pemo",72345));
		l.add(new Employee("Bemo",82345));
		System.out.println(l);
//		Comparator c = (e1,e1)->{(e1.empNo<e2.empNo)?-1:(e1.empNo>e2.empNo)?1:0};
	}
}

class Employee{
	int empNo;
	String empName;
	public Employee(String empName,int empNo) {
		this.empNo=empNo;
		this.empName=empName;
	}
	
	public String toString() {
		return empName+" : "+empNo;
	}
}
