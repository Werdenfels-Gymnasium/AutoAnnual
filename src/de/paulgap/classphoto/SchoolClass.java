package de.paulgap.classphoto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SchoolClass {

	private final String classname;
	private File classphotofile;
	private final List<Student> students = new ArrayList<Student>();
	private final List<Teacher> leaders = new ArrayList<Teacher>();
	private final List<Subject> subjects = new ArrayList<Subject>();
	
	public SchoolClass(String classname) {
		this.classname = classname;
	}
	
	
	public void addLeader(Teacher leader) {
		this.leaders.add(leader);
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}

	public List<Teacher> getClassLeaders() {
		return leaders;
	}

	public List<Student> getStudents() {
		return students;
	}

	public String getClassName() {
		return classname;
	}

	public File getClassPhoto() {
		return classphotofile;
	}

	public void setClassPhoto(File classphotofile) {
		if (!classphotofile.exists()) throw new IllegalStateException("Classphoto of " + getClassName() + " in " + classphotofile.getAbsolutePath() + " not found."); 
		this.classphotofile = classphotofile;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}
	
}
