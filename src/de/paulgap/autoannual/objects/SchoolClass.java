package de.paulgap.autoannual.objects;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.paulgap.autoannual.interfaces.Student;
import de.paulgap.autoannual.interfaces.Subject;
import de.paulgap.autoannual.interfaces.Teacher;

public class SchoolClass {

	private final String classname;
	private File classphotofile;
	private final List<Student> students = new ArrayList<Student>();
	private final List<Teacher> leaders = new ArrayList<Teacher>();
	private final List<Subject> subjects = new ArrayList<Subject>();
	
	public SchoolClass(final String classname) {
		this.classname = classname;
	}
	
	public void addLeader(final Teacher leader) {
		this.leaders.add(leader);
	}
	
	public void addStudent(final Student student) {
		this.students.add(student);
	}

	public void addSubject(final Subject subject) {
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

	public void setClassPhoto(final File classphotofile) {
		if (!classphotofile.exists()) throw new IllegalStateException("Classphoto of " + getClassName() + " in " + classphotofile.getAbsolutePath() + " not found."); 
		this.classphotofile = classphotofile;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}
	
}
