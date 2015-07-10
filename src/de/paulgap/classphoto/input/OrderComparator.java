package de.paulgap.classphoto.input;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderComparator {
	
	private List<String> classes = new ArrayList<String>();

	public OrderComparator() {
		
				
		final File f = new File("Klassen/klassen");
		
		for (final String file : f.list()) {
			classes.add(file.replaceAll(".JPG", ""));
		}
		
		Comparator<String> sorter = new Comparator<String>() {

			public int compare(String o1, String o2) {
				
				int comint1 = Integer.parseInt(o1.replaceAll("[a-zA-Z ]+", "")), comint2 = Integer.parseInt(o2.replaceAll("[a-zA-Z ]+", ""));
				char comend1 = o1.replaceAll("[0-9]+", "").charAt(0), comend2 = o2.replaceAll("[0-9]+", "").charAt(0);
				
				if (comint1 == comint2) {
					if (Character.getNumericValue(comend1) < Character.getNumericValue(comend2)) {
						return -1;
					} else if (Character.getNumericValue(comend1) > Character.getNumericValue(comend2)) {
						return 1;
					} else {
						return 0;
					}
				} else if (comint1 > comint2) {
					return 1;
				} else if (comint1 < comint2) {
					return -1;
				}	
				return 0;
			}

		};
		
		Collections.sort(classes, sorter);
	}
	
	public List<String> getClasses() {
		return this.classes;
	}
}
