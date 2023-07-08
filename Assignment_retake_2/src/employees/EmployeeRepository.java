package employees;

import java.util.ArrayList;

import java.util.NoSuchElementException;

import employees.Employee;
import employees.EmployeeReader;
public class EmployeeRepository {

	private ArrayList<Employee> employeeList;
	private ArrayList<Employee> bioInformaticianList;
	
	//Eventueel een lijst maken voor bioinformatician, technical support en TeamLead?

	public EmployeeRepository(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList; // Add this line to assign the parameter to the instance variable
	}

	public ArrayList<String> getBioinformaticians() {
		ArrayList<String> uniqueBioinformaticians = new ArrayList<>();
		try {
			for (Employee employee : employeeList) {
				if (employee.getJobTitle().contains("Bioinformatician".toLowerCase())) {
					System.out.println("waza" + employee.getFirstName());
					uniqueBioinformaticians.add(employee.getFirstName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The bioinformaticians are: " + uniqueBioinformaticians);
		return uniqueBioinformaticians;
	}

	public ArrayList<String> getTechnicalSupport() {
		ArrayList<String> uniqueTechnicalSupportEmployees = new ArrayList<>();
		try {
			for (Employee employee : employeeList) {
				if (employee.getJobTitle().contains("TechnicalSupport".toLowerCase())) {
					uniqueTechnicalSupportEmployees.add(employee.getFirstName() + " ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The bioinformaticians are " + uniqueTechnicalSupportEmployees);
		return uniqueTechnicalSupportEmployees;
	}
	
	public ArrayList<String> getTeamlead() {
		ArrayList<String> uniqueTeamlead = new ArrayList<>();
		try {
			for (Employee employee : employeeList) {
				if (employee.getJobTitle().contains("Teamlead".toLowerCase())) {
					uniqueTeamlead.add(employee.getFirstName() + " ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The teamlead(s) are " + uniqueTeamlead);
		return uniqueTeamlead;
	}
	
	

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public ArrayList<Employee> getBioInformaticianList() {
		return bioInformaticianList;
	}

	public void setBioInformaticianList(ArrayList<Employee> bioInformaticianList) {
		this.bioInformaticianList = bioInformaticianList;
	}
	
	
	
}
