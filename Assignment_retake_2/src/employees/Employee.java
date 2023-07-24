package employees;

public class Employee {

	private String jobTitle;
	private String firstName;
	private String lastName;
	private Integer yearsOfExperience;

	public Employee(String jobTitle, String firstName, String lastName, Integer yearsOfExperience) {

		this.jobTitle = jobTitle;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearsOfExperience = yearsOfExperience;

	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public boolean hasChangingRights() {
		String jobTitle = this.getJobTitle();
		return jobTitle == " TeamLead ";
	}

	@Override
	public String toString() {
		return String.format("%s", this.getFirstName() + " " + this.getLastName() + " has "
				+ this.getYearsOfExperience() + " years of experience as " + this.getJobTitle());
	}

}
