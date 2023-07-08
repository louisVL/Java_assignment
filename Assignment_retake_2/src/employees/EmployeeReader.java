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
    private String filePath;
    private String jobTitle;
    private String firstName;
    private String lastName;
    private int yearsOfExperience;
    public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private String packageName = EmployeeRepository.class.getPackage().getName(); // to get the name of the current package

    public EmployeeReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public ArrayList<Employee> readFileToList() {

        try {
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            String fileLocation2 = s + File.separator + "src" + File.separator + "team";

            File file2 = new File(fileLocation2 + "." + "txt");

            Scanner scanner = new Scanner(file2);

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
        System.out.println("\"output from employeeReader\" " + employeeList.toString());

        return employeeList;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
}
