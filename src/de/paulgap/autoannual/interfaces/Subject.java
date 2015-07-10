package de.paulgap.autoannual.interfaces;

public class Subject {

	private final SubjectType type;
	private final Teacher teacher;
	
	public Subject(final SubjectType type, final Teacher teacher) {
		this.type = type;
		this.teacher = teacher;
	}
	
	public SubjectType getType() {
		return type;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public enum SubjectType {
		
		APPEND(""),
		MATHE("M"), 
		SPORT("Spo"), 
		PHYSIK("Ph"), 
		ENGLISCH("E"), 
		DEUTSCH("D"), 
		MUSIK("Mu"), 
		KUNST("Ku"), 
		NUT("NuT"),
		GEOGRAPHIE("Geo"),
		GESCHICHTE("G"),
		EVANGELISCH("Ev"),
		ETHIK("Eth"),
		CHEMIE("C"),
		KATHOLISCH("K"),
		INFORMATIK("Inf"),
		WirtschaftUndRecht("WR"),
		FRANZOESISCH("F"),
		LATEIN("L"),
		BIOLOGIE("B"),
		SOZIALKUNDE("Sk");
		
		private final String shortcut;

		SubjectType(final String shortcut) {
			this.shortcut = shortcut;
		}
		
		public String toShortcut() {
			return this.shortcut;
		}	
	}
	

	
}
