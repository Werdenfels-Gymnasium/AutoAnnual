package de.paulgap.classphoto;

public class Student {
	
	private final String firstname, lastname, birthday;
	private final SchoolClass schoolclass;

	public Student(String firstname, String lastname, String birthday, SchoolClass schoolclass) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.schoolclass = schoolclass;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public SchoolClass getSchoolClass() {
		return schoolclass;
	}
	
}
