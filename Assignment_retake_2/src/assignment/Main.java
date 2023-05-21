package assignment;

import employees.Employee;
import employees.EmployeeReader;
import genomes.Genome;


public class Main {
	
	public static void main(String[] args) {

		
		//Vraagje @Simon: Hij vraagt om te veranderen naar public in class Employee en Genome, andere manier?
		
	Employee emp1 = new Employee("Frank", "De Tank", "Bioinformaticion", 9);
	System.out.println(emp1);
	
	Genome gen1 = new Genome("Gen1", "AAAGAGAGAAAATTTGAAAA");
	System.out.println(gen1);
	
	
}

}