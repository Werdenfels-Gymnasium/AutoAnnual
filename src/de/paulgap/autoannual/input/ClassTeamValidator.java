package de.paulgap.autoannual.input;

import de.paulgap.autoannual.interfaces.Subject;
import de.paulgap.autoannual.interfaces.Teacher;
import de.paulgap.autoannual.interfaces.Subject.SubjectType;
import de.paulgap.autoannual.objects.SchoolClass;

public final class ClassTeamValidator {

	public static void handleClassTeamLine(final String line, final SchoolClass sclass) {
		final String[] args = line.split(";");
		if (args.length == 0) return;
		
		switch (args[0]) {
			case "Klassenleitung":
				for (int i = 1, x = args.length; i < x; i++) {
					final String[] nsplit = args[i].split(",");
					sclass.addLeader(new Teacher(nsplit[0], nsplit[1]));
				}
				break;	
			case "Evang. Religionslehre": 
				handleArgs(args, sclass, SubjectType.EVANGELISCH);
				break;
			case "Kath. Religionslehre": 
				handleArgs(args, sclass, SubjectType.KATHOLISCH);
				break;
			case "Ethik":
				handleArgs(args, sclass, SubjectType.ETHIK);
				break;
			case "Deutsch":
				handleArgs(args, sclass, SubjectType.DEUTSCH);
				break;
			case "Englisch":
				handleArgs(args, sclass, SubjectType.ENGLISCH);
				break;
			case "Französisch":
				handleArgs(args, sclass, SubjectType.FRANZOESISCH);
				break;
			case "Mathematik":
				handleArgs(args, sclass, SubjectType.MATHE);
				break;
			case "Informatik":
				handleArgs(args, sclass, SubjectType.INFORMATIK);
				break;
			case "Physik":
				handleArgs(args, sclass, SubjectType.PHYSIK);
				break;
			case "Chemie":
				handleArgs(args, sclass, SubjectType.CHEMIE);
				break;
			case "Biologie":
				handleArgs(args, sclass, SubjectType.BIOLOGIE);
				break;
			case "Geschichte":
				handleArgs(args, sclass, SubjectType.GESCHICHTE);
				break;
			case "Geographie":
				handleArgs(args, sclass, SubjectType.GEOGRAPHIE);
				break;
			case "Wirtschaft und Recht":
				handleArgs(args, sclass, SubjectType.WirtschaftUndRecht);
				break;
			case "Sozialkunde":
				handleArgs(args, sclass, SubjectType.SOZIALKUNDE);
				break;
			case "Kunst":
				handleArgs(args, sclass, SubjectType.KUNST);
				break;
			case "Musik":
				handleArgs(args, sclass, SubjectType.MUSIK);
				break;
			case "Sport":
				handleArgs(args, sclass, SubjectType.SPORT);
				break;
		}
	}
	
	private static void handleArgs(final String[] args, final SchoolClass sclass, final SubjectType subj) {
		for (int i = 1, x = args.length; i < x; i++) {
			final String[] nsplit = args[i].split(",");
			sclass.addSubject(new Subject(i == 1 ? subj : SubjectType.APPEND, new Teacher(nsplit[0], nsplit[1])));
		}
	}
}
