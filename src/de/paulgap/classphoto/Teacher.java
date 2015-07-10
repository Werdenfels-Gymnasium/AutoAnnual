package de.paulgap.classphoto;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import de.paulgap.scribusapi.ScribusUtil;

public class Teacher {
	
	private final String firstname, lastname;
	private final TreeMap<String, List<Subject>> subjects = new TreeMap<String, List<Subject>>();

	public Teacher(String lastname, String firstname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public void addSubject(String classname, Subject subject) {
		ScribusUtil.putIfAbsent(this.subjects, classname, new ArrayList<Subject>());
		this.subjects.get(classname).add(subject);
	}

	public List<Subject> getSubjects(String classname) {
		return subjects.get(classname);
	}
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
}
