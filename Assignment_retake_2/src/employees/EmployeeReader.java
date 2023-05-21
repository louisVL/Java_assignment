package employees;

import assignment.FileType;
import assignment.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EmployeeReader implements Reader {
	private String filePath;
	private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private String packageName = EmployeeRepository.class.getPackage().getName(); // to get the name of the current
	// package

	public EmployeeReader(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public List<Employee> readFileToList() {
		return new ArrayList<>();
	}

	public ArrayList<Employee> readFileToListOfEmployees() throws FileNotFoundException {

		try {
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();
			String fileLocation2 = s + File.separator + "src" + File.separator + packageName + File.separator
					+ "team";

			File file2 = new File(fileLocation2 + "." + FileType.txt);

			Scanner scanner = new Scanner(file2);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] content;
				content = line.split(" ");
				jobTitle = content[0];
				firstName = content[1];
				lastName = content[2];
				yearsExperience = Integer.parseInt(content[3]);
				// repositoryName = content[1] + content[2];

				Employee emp = new Employee(jobTitle.toLowerCase(), firstName, lastName, yearsExperience);
				if (!employeeList.contains(emp))
					employeeList.add(emp);

			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (SecurityException e) {
			System.out.println("Security exception: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO exception: " + e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("No such element exception: " + e.getMessage());
		} catch (IllegalStateException e) {
			System.out.println("Illegal state exception: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		return employeeList;
	}

}
