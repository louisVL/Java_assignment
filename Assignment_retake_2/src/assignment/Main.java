package assignment;

import java.util.ArrayList;

import employees.EmployeeReader;
import genomes.GenomeReader;



public class Main {
	
	public static void main(String[] args) {
//Vraagje @Simon: Hij vraagt om te veranderen naar public in class Employee en Genome, andere manier?
		
	Employee emp1 = new Employee("Frank", "De Tank", "Bioinformaticion", 9);
	System.out.println(emp1);
	
	Genome gen1 = new Genome("Gen1", "AAAGAGAGAAAATTTGAAAA");
	System.out.println(gen1);
	
	
	//EmployeeReader employeeList = new EmployeeReader("team");
	//System.out.println(employeeList);
	
	ArrayList<employees.Employee> employeeList = new EmployeeReader("team").readFileToList();
	
//	ArrayList<genomes.Genome> genomeList = new GenomeReader("hiv").readFileToList();
//	System.out.println(genomeList);
}

}