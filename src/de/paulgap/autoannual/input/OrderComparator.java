package de.paulgap.autoannual.input;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.paulgap.autoannual.FixedConfig;

public class OrderComparator {
	
	private final List<String> classes = new ArrayList<String>();
	private final File classfile = new File(FixedConfig.ROOTDIR + "/klassen");

	public OrderComparator() {
		
		for (final String file : classfile.list()) {
			classes.add(file.replaceAll(".JPG", ""));
		}
		
		final Comparator<String> sorter = new Comparator<String>() {

			public int compare(final String str1, final String str2) {
				final int comint1 = Integer.parseInt(str1.replaceAll("[a-zA-Z ]+", "")), comint2 = Integer.parseInt(str2.replaceAll("[a-zA-Z ]+", ""));
				final char comend1 = str1.replaceAll("[0-9]+", "").charAt(0), comend2 = str2.replaceAll("[0-9]+", "").charAt(0);
				
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
