package employees;

import assignment.FileType;
import assignment.Reader;
import employees.EmployeeRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EmployeeReader implements Reader {
	private String fileName;
	private String jobTitle;
	private String firstName;
	private String lastName;
	private int yearsOfExperience;
	public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	// package

	public EmployeeReader(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public ArrayList<Employee> readFileToList() {

		Path currentRelativePath = Paths.get("");
		String absolutePath = currentRelativePath.toAbsolutePath().toString();
		String fileLocation = absolutePath + File.separator + "src" + File.separator + fileName;

		File inputFile = new File(fileLocation + "." + FileType.txt.name().toLowerCase());
		Scanner scanner = null; // Declare the scanner outside the try block

		try {
			scanner = new Scanner(inputFile);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] content;
				content = line.split(" ");
				jobTitle = content[0];
				firstName = content[1];
				lastName = content[2];
				yearsOfExperience = Integer.parseInt(content[3]);
				// repositoryName = content[1] + content[2];

				Employee emp = new Employee(jobTitle.toLowerCase(), firstName, lastName, yearsOfExperience);
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

		finally {
			// Close the Scanner here in the finally block.
			// This ensures the Scanner is always closed, even if an exception occurs.
			if (scanner != null) {
				scanner.close();
			}
		}

		System.out.println("\"output from employeeReader\" " + employeeList.toString());

		return employeeList;
	}

	public String getFilePath() {
		return fileName;
	}

	public void setFilePath(String fileName) {
		this.fileName = fileName;
	}

}
