package de.paulgap.autoannual;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.TreeMap;

import de.paulgap.classphoto.SchoolClass;
import de.paulgap.classphoto.ScribusClassPhotoPage;
import de.paulgap.classphoto.Util;
import de.paulgap.classphoto.input.ClassTeamValidator;
import de.paulgap.classphoto.input.OrderComparator;
import de.paulgap.classphoto.input.StudentLoader;
import de.paulgap.scribusapi.ScribusXML;

public final class Bootstrap {

	private final ScribusXML xml;
	private final TreeMap<String, SchoolClass> classes = new TreeMap<String, SchoolClass>();
	
	public Bootstrap(final ScribusXML xml) {
		this.xml = xml;
	}

	public void startup() {
		
		final OrderComparator order = new OrderComparator();
		
		for (final String cur : order.getClasses()) {
			final SchoolClass sclass = new SchoolClass(cur);
			
			final File kteam = new File("Klassen/lehrer/Klassenteam_" + sclass.getClassName() + ".csv");
					
			try {
				Scanner kscanner = new Scanner(new FileInputStream(kteam), "windows-1252");
						
				while (kscanner.hasNextLine()) {
					ClassTeamValidator.handleClassTeamLine(kscanner.nextLine(), sclass);
				}
				
				kscanner.close();
			} catch (final Exception e) {
				e.printStackTrace();
			}
				
			sclass.setClassPhoto(new File("Klassen/klassen/" + sclass.getClassName() + ".JPG"));
			
			classes.put(cur, sclass);
		}
		
		new StudentLoader(this);
		
		int page = 1;
		for (final SchoolClass sclass : classes.values()) {
			Util.createPages(xml, page);
			xml.appendObject(new ScribusClassPhotoPage(xml, sclass, page));
			page++;
		}
		
		xml.setPages(classes.size());
	}
	
	public SchoolClass getSchoolClass(final String classname) {
		return classes.get(classname);
	}
}
