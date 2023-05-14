package Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeReader {
	
	private String jobTitle;
	private String firstName;
	private String lastName;
	private Integer yearsExperience;
	private static ArrayList<Employee> employeeList = new ArrayList<Employee>();

	
	public ArrayList<Employee> readFileToListOfEmployees() throws FileNotFoundException {

		try {
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();
			String fileLocation2 = "C:/Users/louis.vanlooy_publiq/eclipse-workspace/Assignment_retake_2/src/team.txt";

			File file2 = new File(fileLocation2);

			Scanner scanner = new Scanner(file2);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] content;
				content = line.split(" ");
				jobTitle = content[0];
				firstName = content[1];
				lastName = content[2];
				yearsExperience = Integer.parseInt(content[3]);

				Employee emp = new Employee(jobTitle.toLowerCase(), firstName, lastName, yearsExperience);
				if (!employeeList.contains(emp))
					employeeList.add(emp);

			}

		}

		catch (FileNotFoundException e) {
			// Handle the error if the file is not found
			System.out.println("Error: File not found.");
		}
		return employeeList;

	}

}
