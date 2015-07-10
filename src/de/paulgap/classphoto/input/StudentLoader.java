package de.paulgap.classphoto.input;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import de.paulgap.autoannual.Bootstrap;
import de.paulgap.classphoto.SchoolClass;
import de.paulgap.classphoto.Student;
import de.paulgap.classphoto.Util;

public class StudentLoader {

	private final List<Student> students = new ArrayList<Student>();
	
	public StudentLoader(Bootstrap booter) {
		
		final File f = new File("Klassen/schueler/schuelerliste.csv");
		
		
		try {
			final Scanner s = new Scanner(f);
			int i = 0;

			while (s.hasNextLine()) {
				String[] args = s.nextLine().split(";");
			
				// REMOVE 'S' for Custom 9a
				SchoolClass sclass = booter.getSchoolClass(Util.formatClassName(args[2]).replaceAll("s", ""));
				
				if (sclass != null) {
					i++;
					students.add(new Student(args[1].split(" ")[0], args[0], args[3], sclass));
				}
			}
			
			System.out.println("###### SUCCESFULLY READ " + i + " STUDENTS ######");
			
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Student std : students) {
			std.getSchoolClass().addStudent(std);
		}
	}
	
}
