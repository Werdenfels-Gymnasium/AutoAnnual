package de.paulgap.autoannual.objects;

import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Element;

import de.paulgap.autoannual.Util;
import de.paulgap.autoannual.interfaces.Student;
import de.paulgap.autoannual.interfaces.Subject;
import de.paulgap.autoannual.interfaces.Teacher;
import de.paulgap.scribusapi.ScribusAttributeObject;
import de.paulgap.scribusapi.ScribusObject;
import de.paulgap.scribusapi.ScribusUtil;
import de.paulgap.scribusapi.ScribusXML;

public class ScribusClassPhotoPage extends ScribusAttributeObject implements ScribusObject {
	
	private final ScribusXML xml;
	private final int page;
	private final SchoolClass schoolclass;
	
	public ScribusClassPhotoPage(final ScribusXML xml, final SchoolClass schoolclass, final int page) {
		this.xml = xml;
		this.schoolclass = schoolclass;
		this.page = page;
		
		// TEXT OBJECT
		this.setAttributes("studentnames", ScribusUtil.stringToAttributes("OwnPage=\"6\" PTYPE=\"4\" XPOS=\"425.98462992126\" YPOS=\"689.29194488189\" WIDTH=\"235.276\" HEIGHT=\"462.048\" RADRECT=\"0\" FRTYPE=\"0\" CLIPEDIT=\"0\" PWIDTH=\"1\" PCOLOR=\"None\" PCOLOR2=\"None\" TXTFILL=\"Black\" TXTSTROKE=\"Black\" TXTSTRSH=\"100\" TXTFILLSH=\"100\" TXTSCALE=\"100\" TXTSCALEV=\"100\" TXTBASE=\"0\" TXTSHX=\"5\" TXTSHY=\"-5\" TXTOUT=\"1\" TXTULP=\"-0.1\" TXTULW=\"-0.1\" TXTSTP=\"-0.1\" TXTSTW=\"-0.1\" TXTKERN=\"0\" COLUMNS=\"1\" COLGAP=\"14.4\" NAMEDLST=\"\" SHADE=\"100\" SHADE2=\"100\" GRTYP=\"0\" ROT=\"0\" PLINEART=\"1\" PLINEEND=\"0\" PLINEJOIN=\"0\" LINESP=\"13.2\" LINESPMode=\"0\" LOCALSCX=\"1\" LOCALSCY=\"1\" LOCALX=\"0\" LOCALY=\"0\" PICART=\"1\" PLTSHOW=\"0\" BASEOF=\"0\" textPathType=\"0\" textPathFlipped=\"0\" FLIPPEDH=\"0\" FLIPPEDV=\"0\" IFONT=\"Arial Regular\" ISIZE=\"11\" SCALETYPE=\"1\" RATIO=\"1\" PRINTABLE=\"1\" ANNOTATION=\"0\" ANNAME=\"\" TEXTFLOWMODE=\"0\" TEXTFLOW=\"0\" TEXTFLOW2=\"0\" TEXTFLOW3=\"0\" AUTOTEXT=\"0\" EXTRA=\"0\" TEXTRA=\"0\" BEXTRA=\"0\" REXTRA=\"0\" FLOP=\"0\" PFILE=\"\" PFILE2=\"\" PFILE3=\"\" PRFILE=\"\" EPROF=\"\" IRENDER=\"1\" EMBEDDED=\"1\" LOCK=\"0\" LOCKR=\"0\" REVERS=\"0\" TransValue=\"0\" TransValueS=\"0\" TransBlend=\"0\" TransBlendS=\"0\" isTableItem=\"0\" TopLine=\"0\" LeftLine=\"0\" RightLine=\"0\" BottomLine=\"0\" isGroupControl=\"0\" NUMDASH=\"0\" DASHS=\"\" DASHOFF=\"0\" NUMPO=\"16\" POCOOR=\"0 0 0 0 235.276 0 235.276 0 235.276 0 235.276 0 235.276 462.048 235.276 462.048 235.276 462.048 235.276 462.048 0 462.048 0 462.048 0 462.048 0 462.048 0 0 0 0 \" NUMCO=\"16\" COCOOR=\"0 0 0 0 235.276 0 235.276 0 235.276 0 235.276 0 235.276 462.048 235.276 462.048 235.276 462.048 235.276 462.048 0 462.048 0 462.048 0 462.048 0 462.048 0 0 0 0 \" NUMGROUP=\"0\" GROUPS=\"\" startArrowIndex=\"0\" endArrowIndex=\"0\" OnMasterPage=\"\" ImageClip=\"\" ImageRes=\"1\" Pagenumber=\"0\" isInline=\"0\" fillRule=\"1\" doOverprint=\"0\" gXpos=\"785.811\" gYpos=\"1279.82\" gWidth=\"786.811\" gHeight=\"1.73621001870194e-316\" ALIGN=\"0\" LAYER=\"0\" BOOKMARK=\"0\" NEXTITEM=\"-1\" BACKITEM=\"-1\""));
		this.setAttribute("studentnames", "OwnPage", String.valueOf(this.page));
		this.setAttribute("studentnames", "YPOS", String.valueOf(((this.page - 1) * 623.936685039) + Float.parseFloat(this.getAttribute("studentnames", "YPOS"))));
		this.setAttribute("studentnames", "ANNAME", "Textbox_Schueler_" + schoolclass.getClassName());

		// IMAGE OBJECT
		this.setAttributes("classimage", ScribusUtil.stringToAttributes("OwnPage=\"2\" PTYPE=\"2\" XPOS=\"712.28362992126\" YPOS=\"643.93794488189\" WIDTH=\"612.24\" HEIGHT=\"583.92\" RADRECT=\"0\" FRTYPE=\"0\" CLIPEDIT=\"0\" PWIDTH=\"1\" PCOLOR=\"None\" PCOLOR2=\"None\" TXTFILL=\"Black\" TXTSTROKE=\"Black\" TXTSTRSH=\"100\" TXTFILLSH=\"100\" TXTSCALE=\"100\" TXTSCALEV=\"100\" TXTBASE=\"0\" TXTSHX=\"5\" TXTSHY=\"-5\" TXTOUT=\"1\" TXTULP=\"-0.1\" TXTULW=\"-0.1\" TXTSTP=\"-0.1\" TXTSTW=\"-0.1\" TXTKERN=\"0\" COLUMNS=\"1\" COLGAP=\"14.4\" NAMEDLST=\"\" SHADE=\"100\" SHADE2=\"100\" GRTYP=\"0\" ROT=\"0\" PLINEART=\"1\" PLINEEND=\"0\" PLINEJOIN=\"0\" LINESP=\"13.2\" LINESPMode=\"0\" LOCALSCX=\"0.36\" LOCALSCY=\"0.36\" LOCALX=\"0\" LOCALY=\"0\" PICART=\"1\" PLTSHOW=\"0\" BASEOF=\"0\" textPathType=\"0\" textPathFlipped=\"0\" FLIPPEDH=\"0\" FLIPPEDV=\"0\" IFONT=\"Arial Regular\" ISIZE=\"11\" SCALETYPE=\"1\" RATIO=\"1\" PRINTABLE=\"1\" ANNOTATION=\"0\" ANNAME=\"\" TEXTFLOWMODE=\"0\" TEXTFLOW=\"0\" TEXTFLOW2=\"0\" TEXTFLOW3=\"0\" AUTOTEXT=\"0\" EXTRA=\"0\" TEXTRA=\"0\" BEXTRA=\"0\" REXTRA=\"0\" FLOP=\"0\" PFILE=\"05_KLassen/05a.JPG\" PFILE2=\"\" PFILE3=\"\" PRFILE=\"\" EPROF=\"\" IRENDER=\"0\" EMBEDDED=\"0\" LOCK=\"0\" LOCKR=\"0\" REVERS=\"0\" TransValue=\"0\" TransValueS=\"0\" TransBlend=\"0\" TransBlendS=\"0\" isTableItem=\"0\" TopLine=\"0\" LeftLine=\"0\" RightLine=\"0\" BottomLine=\"0\" isGroupControl=\"0\" NUMDASH=\"0\" DASHS=\"\" DASHOFF=\"0\" NUMPO=\"16\" POCOOR=\"0 0 0 0 612.24 0 612.24 0 612.24 0 612.24 0 612.24 583.92 612.24 583.92 612.24 583.92 612.24 583.92 0 583.92 0 583.92 0 583.92 0 583.92 0 0 0 0 \" NUMCO=\"16\" COCOOR=\"0 0 0 0 612.24 0 612.24 0 612.24 0 612.24 0 612.24 583.92 612.24 583.92 612.24 583.92 612.24 583.92 0 583.92 0 583.92 0 583.92 0 583.92 0 0 0 0 \" NUMGROUP=\"0\" GROUPS=\"\" startArrowIndex=\"0\" endArrowIndex=\"0\" OnMasterPage=\"\" ImageClip=\"\" ImageRes=\"1\" Pagenumber=\"0\" isInline=\"0\" fillRule=\"1\" doOverprint=\"0\" gXpos=\"0\" gYpos=\"0\" gWidth=\"0\" gHeight=\"0\" ALIGN=\"0\" LAYER=\"0\" BOOKMARK=\"0\" NEXTITEM=\"-1\" BACKITEM=\"-1\""));
		this.setAttribute("classimage", "OwnPage", String.valueOf(this.page));
		this.setAttribute("classimage", "PFILE", String.valueOf(schoolclass.getClassPhoto().getPath().replaceAll("\\\\", "/")));
		this.setAttribute("classimage", "YPOS", String.valueOf(((this.page - 1) * 623.936685039) + Float.parseFloat(this.getAttribute("classimage", "YPOS"))));
		this.setAttribute("classimage", "ANNAME", "Image_Klasse_" + schoolclass.getClassName());

		// CLASS NAME
		this.setAttributes("classname", ScribusUtil.stringToAttributes("OwnPage=\"6\" PTYPE=\"4\" XPOS=\"179.37062992126\" YPOS=\"689.29194488189\" WIDTH=\"117.638\" HEIGHT=\"119.055\" RADRECT=\"0\" FRTYPE=\"0\" CLIPEDIT=\"0\" PWIDTH=\"1\" PCOLOR=\"None\" PCOLOR2=\"None\" TXTFILL=\"Black\" TXTSTROKE=\"Black\" TXTSTRSH=\"100\" TXTFILLSH=\"100\" TXTSCALE=\"100\" TXTSCALEV=\"100\" TXTBASE=\"0\" TXTSHX=\"5\" TXTSHY=\"-5\" TXTOUT=\"1\" TXTULP=\"-0.1\" TXTULW=\"-0.1\" TXTSTP=\"-0.1\" TXTSTW=\"-0.1\" TXTKERN=\"0\" COLUMNS=\"1\" COLGAP=\"14.4\" NAMEDLST=\"\" SHADE=\"100\" SHADE2=\"100\" GRTYP=\"0\" ROT=\"0\" PLINEART=\"1\" PLINEEND=\"0\" PLINEJOIN=\"0\" LINESP=\"13.2\" LINESPMode=\"0\" LOCALSCX=\"1\" LOCALSCY=\"1\" LOCALX=\"0\" LOCALY=\"0\" PICART=\"1\" PLTSHOW=\"0\" BASEOF=\"0\" textPathType=\"0\" textPathFlipped=\"0\" FLIPPEDH=\"0\" FLIPPEDV=\"0\" IFONT=\"Arial Regular\" ISIZE=\"11\" SCALETYPE=\"1\" RATIO=\"1\" PRINTABLE=\"1\" ANNOTATION=\"0\" ANNAME=\"\" TEXTFLOWMODE=\"0\" TEXTFLOW=\"0\" TEXTFLOW2=\"0\" TEXTFLOW3=\"0\" AUTOTEXT=\"0\" EXTRA=\"0\" TEXTRA=\"0\" BEXTRA=\"0\" REXTRA=\"0\" FLOP=\"0\" PFILE=\"\" PFILE2=\"\" PFILE3=\"\" PRFILE=\"\" EPROF=\"\" IRENDER=\"1\" EMBEDDED=\"1\" LOCK=\"0\" LOCKR=\"0\" REVERS=\"0\" TransValue=\"0\" TransValueS=\"0\" TransBlend=\"0\" TransBlendS=\"0\" isTableItem=\"0\" TopLine=\"0\" LeftLine=\"0\" RightLine=\"0\" BottomLine=\"0\" isGroupControl=\"0\" NUMDASH=\"0\" DASHS=\"\" DASHOFF=\"0\" NUMPO=\"16\" POCOOR=\"0 0 0 0 117.638 0 117.638 0 117.638 0 117.638 0 117.638 119.055 117.638 119.055 117.638 119.055 117.638 119.055 0 119.055 0 119.055 0 119.055 0 119.055 0 0 0 0 \" NUMCO=\"16\" COCOOR=\"0 0 0 0 117.638 0 117.638 0 117.638 0 117.638 0 117.638 119.055 117.638 119.055 117.638 119.055 117.638 119.055 0 119.055 0 119.055 0 119.055 0 119.055 0 0 0 0 \" NUMGROUP=\"0\" GROUPS=\"\" startArrowIndex=\"0\" endArrowIndex=\"0\" OnMasterPage=\"\" ImageClip=\"\" ImageRes=\"1\" Pagenumber=\"0\" isInline=\"0\" fillRule=\"1\" doOverprint=\"0\" gXpos=\"6.77544e-256\" gYpos=\"3.06611e-304\" gWidth=\"3.06611e-304\" gHeight=\"3.06611e-304\" ALIGN=\"0\" LAYER=\"0\" BOOKMARK=\"0\" NEXTITEM=\"-1\" BACKITEM=\"-1\""));
		this.setAttribute("classname", "OwnPage", String.valueOf(this.page));
		this.setAttribute("classname", "YPOS", String.valueOf(((this.page - 1) * 623.936685039) + Float.parseFloat(this.getAttribute("classname", "YPOS"))));
		this.setAttribute("classname", "ANNAME", "Textbox_Klassenbezeichner_" + schoolclass.getClassName());

		// TEACHER NAMES
		this.setAttributes("teachernames", ScribusUtil.stringToAttributes("OwnPage=\"1\" PTYPE=\"4\" XPOS=\"179.37062992126\" YPOS=\"808.346923828125\" WIDTH=\"235.276\" HEIGHT=\"384.903076171875\" RADRECT=\"0\" FRTYPE=\"0\" CLIPEDIT=\"0\" PWIDTH=\"1\" PCOLOR=\"None\" PCOLOR2=\"None\" TXTFILL=\"Black\" TXTSTROKE=\"Black\" TXTSTRSH=\"100\" TXTFILLSH=\"100\" TXTSCALE=\"100\" TXTSCALEV=\"100\" TXTBASE=\"0\" TXTSHX=\"5\" TXTSHY=\"-5\" TXTOUT=\"1\" TXTULP=\"-0.1\" TXTULW=\"-0.1\" TXTSTP=\"-0.1\" TXTSTW=\"-0.1\" TXTKERN=\"0\" COLUMNS=\"1\" COLGAP=\"14.4\" NAMEDLST=\"\" SHADE=\"100\" SHADE2=\"100\" GRTYP=\"0\" ROT=\"0\" PLINEART=\"1\" PLINEEND=\"0\" PLINEJOIN=\"0\" LINESP=\"13.2\" LINESPMode=\"0\" LOCALSCX=\"1\" LOCALSCY=\"1\" LOCALX=\"0\" LOCALY=\"0\" PICART=\"1\" PLTSHOW=\"0\" BASEOF=\"0\" textPathType=\"0\" textPathFlipped=\"0\" FLIPPEDH=\"0\" FLIPPEDV=\"0\" IFONT=\"Arial Regular\" ISIZE=\"11\" SCALETYPE=\"1\" RATIO=\"1\" PRINTABLE=\"1\" ANNOTATION=\"0\" TEXTFLOWMODE=\"0\" TEXTFLOW=\"0\" TEXTFLOW2=\"0\" TEXTFLOW3=\"0\" AUTOTEXT=\"0\" EXTRA=\"0\" TEXTRA=\"0\" BEXTRA=\"0\" REXTRA=\"0\" FLOP=\"0\" PFILE=\"\" PFILE2=\"\" PFILE3=\"\" PRFILE=\"\" EPROF=\"\" IRENDER=\"1\" EMBEDDED=\"1\" LOCK=\"0\" LOCKR=\"0\" REVERS=\"0\" TransValue=\"0\" TransValueS=\"0\" TransBlend=\"0\" TransBlendS=\"0\" isTableItem=\"0\" TopLine=\"0\" LeftLine=\"0\" RightLine=\"0\" BottomLine=\"0\" isGroupControl=\"0\" NUMDASH=\"0\" DASHS=\"\" DASHOFF=\"0\" NUMPO=\"16\" POCOOR=\"0 0 0 0 235.276 0 235.276 0 235.276 0 235.276 0 235.276 384.903 235.276 384.903 235.276 384.903 235.276 384.903 0 384.903 0 384.903 0 384.903 0 384.903 0 0 0 0 \" NUMCO=\"16\" COCOOR=\"0 0 0 0 235.276 0 235.276 0 235.276 0 235.276 0 235.276 384.903 235.276 384.903 235.276 384.903 235.276 384.903 0 384.903 0 384.903 0 384.903 0 384.903 0 0 0 0 \" NUMGROUP=\"0\" GROUPS=\"\" startArrowIndex=\"0\" endArrowIndex=\"0\" OnMasterPage=\"\" ImageClip=\"\" ImageRes=\"1\" Pagenumber=\"0\" isInline=\"0\" fillRule=\"1\" doOverprint=\"0\" gXpos=\"8.06874e-256\" gYpos=\"8.07004e-256\" gWidth=\"8.07134e-256\" gHeight=\"8.07264e-256\" ALIGN=\"0\" LAYER=\"0\" BOOKMARK=\"0\" NEXTITEM=\"-1\" BACKITEM=\"-1\""));
		this.setAttribute("teachernames", "OwnPage", String.valueOf(this.page));
		this.setAttribute("teachernames", "YPOS", String.valueOf(((this.page - 1) * 623.936685039) + Float.parseFloat(this.getAttribute("teachernames", "YPOS"))));		
		this.setAttribute("teachernames", "ANNAME", "Textbox_Lehrer_" + schoolclass.getClassName());
	}

	public List<Element> toDOMNode() {
		final Element studentnamesobject = xml.getRootDocument().createElement("PAGEOBJECT");
		final Element classphotoobject = xml.getRootDocument().createElement("PAGEOBJECT");
		final Element classnameobject = xml.getRootDocument().createElement("PAGEOBJECT");
		final Element teachernamesobject = xml.getRootDocument().createElement("PAGEOBJECT");


		/*********************************************
		 * 				STUDENT NAMES
		 *********************************************/		
		ScribusUtil.setAttributesFromMap(getAttributes("studentnames"), studentnamesobject);
		
		for (final Student student : schoolclass.getStudents()) {
			Util.appendText(studentnamesobject, xml, student.getLastname() + ", " + student.getFirstname());
			Util.appendTab(studentnamesobject, xml);
			Util.appendText(studentnamesobject, xml, student.getBirthday());
			Util.appendPara(studentnamesobject, xml, "Klassen_Schüler");
		}
		
		/*********************************************
		 * 				CLASS IMAGE
		 *********************************************/
		ScribusUtil.setAttributesFromMap(getAttributes("classimage"), classphotoobject);
		
		/*********************************************
		 * 				CLASS NAME
		 *********************************************/
		ScribusUtil.setAttributesFromMap(getAttributes("classname"), classnameobject);
		
		Util.appendText(classnameobject, xml, schoolclass.getClassName());
		Util.appendTrail(classnameobject, xml, "Klassen_Name");
		
		/*********************************************
		 * 				TEACHER NAME
		 *********************************************/
		ScribusUtil.setAttributesFromMap(getAttributes("teachernames"), teachernamesobject);

		Util.appendTab(teachernamesobject, xml);
		Util.appendTab(teachernamesobject, xml);
		Util.appendText(teachernamesobject, xml, "Klassenleitung");
		Util.appendPara(teachernamesobject, xml, "Klassen_Lehrer_fett");
		
		for (final Teacher leader : schoolclass.getClassLeaders()) {
			Util.appendTab(teachernamesobject, xml);
			Util.appendTab(teachernamesobject, xml);
			Util.appendText(teachernamesobject, xml, leader.getLastname() + ", " + leader.getFirstname());
			Util.appendPara(teachernamesobject, xml, "Klassen_Lehrer");
		}

		Util.appendPara(teachernamesobject, xml, "Klassen_Lehrer");
		Util.appendTab(teachernamesobject, xml);
		Util.appendText(teachernamesobject, xml, "Fach");

		Util.appendTab(teachernamesobject, xml);
		Util.appendText(teachernamesobject, xml, "Lehrer");
		Util.appendPara(teachernamesobject, xml, "Klassen_Lehrer_fett");
		
		for (final Subject subject : schoolclass.getSubjects()) {
			Util.appendTab(teachernamesobject, xml);
			Util.appendText(teachernamesobject, xml, subject.getType().toShortcut());
			Util.appendTab(teachernamesobject, xml);
			Util.appendText(teachernamesobject, xml, subject.getTeacher().getLastname() + ", " + subject.getTeacher().getFirstname());
			Util.appendPara(teachernamesobject, xml, "Klassen_Lehrer");
		}

		return Arrays.asList(studentnamesobject, classphotoobject, classnameobject, teachernamesobject);
	}

}
