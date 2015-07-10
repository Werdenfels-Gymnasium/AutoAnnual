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
	
	public static void main(final String[] args) {
		
		System.out.println("###### STARTING SCRIBUS API ######");
		
		final ScribusXML sxml = new ScribusXML(FixedConfig.TEMPLATEPATH);
		final Bootstrap boot = new Bootstrap(sxml);
		
		sxml.load();
		boot.startup();
		
		sxml.saveTo(FixedConfig.OUTPUTPATH);
		
		System.out.println("###### XML SUCCESSFUL SAVED #######");
	}
	
	public Bootstrap(final ScribusXML xml) {
		this.xml = xml;
	}

	public void startup() {
		
		final OrderComparator order = new OrderComparator();
		
		for (final String cur : order.getClasses()) {
			final SchoolClass sclass = new SchoolClass(cur);
			
			final File kteam = new File(FixedConfig.ROOTDIR + "/lehrer/Klassenteam_" + sclass.getClassName() + ".csv");
					
			try {
				Scanner kscanner = new Scanner(new FileInputStream(kteam), "windows-1252");
						
				while (kscanner.hasNextLine()) {
					ClassTeamValidator.handleClassTeamLine(kscanner.nextLine(), sclass);
				}
				
				kscanner.close();
			} catch (final Exception e) {
				e.printStackTrace();
			}
				
			sclass.setClassPhoto(new File(FixedConfig.ROOTDIR + "/klassen/" + sclass.getClassName() + ".JPG"));
			
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
