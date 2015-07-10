package de.paulgap.autoannual.input;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import de.paulgap.autoannual.Bootstrap;
import de.paulgap.autoannual.FixedConfig;
import de.paulgap.autoannual.Util;
import de.paulgap.autoannual.interfaces.Student;
import de.paulgap.autoannual.objects.SchoolClass;

public class StudentLoader {

	private final List<Student> students = new ArrayList<Student>();
	final File studentlist = new File(FixedConfig.ROOTDIR + "/schueler/schuelerliste.csv");
	
	public StudentLoader(Bootstrap booter) {
		
		
		try {
			final Scanner scanner = new Scanner(studentlist);
			int i = 0;

			while (scanner.hasNextLine()) {
				final String[] args = scanner.nextLine().split(";");
				final SchoolClass sclass = booter.getSchoolClass(Util.formatClassName(args[2]).replaceAll("s", ""));
				
				if (sclass != null) {
					i++;
					students.add(new Student(args[1].split(" ")[0], args[0], args[3], sclass));
				}
			}
			
			System.out.println("###### SUCCESFULLY READ " + i + " STUDENTS ######");
			
			scanner.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		
		for (final Student std : students) {
			std.getSchoolClass().addStudent(std);
		}
	}
	
}
