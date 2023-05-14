package Reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		EmployeeReader reader = new EmployeeReader();

		try {
			ArrayList<Employee> employees = reader.readFileToListOfEmployees();

			System.out.println(employees);

		} catch (FileNotFoundException e) {
			e.printStackTrace();


		}

	}
}
