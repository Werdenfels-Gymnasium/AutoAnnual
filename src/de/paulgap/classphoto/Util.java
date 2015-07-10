package de.paulgap.classphoto;

import java.text.DecimalFormat;

import org.w3c.dom.Element;

import de.paulgap.scribusapi.ScribusUtil;
import de.paulgap.scribusapi.ScribusXML;

public class Util {

	private static final DecimalFormat classformat = new DecimalFormat("00");
	
	public static void appendTab(final Element x, final ScribusXML xml) {
		x.appendChild(xml.getRootDocument().createElement("tab"));
	}
	
	public static void appendPara(final Element x, final ScribusXML xml, final String parent) {
		final Element para = xml.getRootDocument().createElement("para");
		para.setAttribute("PARENT", parent);
		x.appendChild(para);
	}
	
	public static void appendTrail(final Element x, final ScribusXML xml, final String parent) {
		final Element para = xml.getRootDocument().createElement("trail");
		para.setAttribute("PARENT", parent);
		x.appendChild(para);
	}
	
	public static void appendText(Element x, ScribusXML xml, String text) {
		x.appendChild(ScribusUtil.createTextElement(text, xml));
	}

	public static void createPages(final ScribusXML xml, final int page) {
		final Element pageobj = xml.getRootDocument().createElement("PAGE");
		ScribusUtil.setAttributesFromMap(ScribusUtil.stringToAttributes("PAGEXPOS=\"100.00062992126\" PAGEYPOS=\"643.93794488189\" PAGEWIDTH=\"612.283\" PAGEHEIGHT=\"583.937\" BORDERLEFT=\"8.50394\" BORDERRIGHT=\"8.50394\" BORDERTOP=\"8.50394\" BORDERBOTTOM=\"8.50394\" NUM=\"1\" NAM=\"\" MNAM=\"Text Seitenz2 l\" Size=\"Custom\" Orientation=\"0\" LEFT=\"0\" PRESET=\"0\" VerticalGuides=\"79.3701 197.008 314.646 325.984 443.622 561.26 \" HorizontalGuides=\"45.3543 164.409 507.402 \" AGhorizontalAutoGap=\"0\" AGverticalAutoGap=\"0\" AGhorizontalAutoCount=\"0\" AGverticalAutoCount=\"0\" AGhorizontalAutoRefer=\"0\" AGverticalAutoRefer=\"0\" AGSelection=\"0 0 0 0\""), pageobj);
		pageobj.setAttribute("PAGEYPOS", String.valueOf(Float.parseFloat(pageobj.getAttribute("PAGEYPOS")) * page));

		final Element pageobj2 = xml.getRootDocument().createElement("PAGE");
		ScribusUtil.setAttributesFromMap(ScribusUtil.stringToAttributes("PAGEXPOS=\"712.28362992126\" PAGEYPOS=\"643.93794488189\" PAGEWIDTH=\"612.283\" PAGEHEIGHT=\"583.937\" BORDERLEFT=\"8.50394\" BORDERRIGHT=\"8.50394\" BORDERTOP=\"8.50394\" BORDERBOTTOM=\"8.50394\" NUM=\"2\" NAM=\"\" MNAM=\"Text Seitenz2 r\" Size=\"Custom\" Orientation=\"0\" LEFT=\"0\" PRESET=\"0\" VerticalGuides=\"51.0236 168.661 286.299 297.638 415.276 532.913 \" HorizontalGuides=\"45.3543 507.402 \" AGhorizontalAutoGap=\"0\" AGverticalAutoGap=\"0\" AGhorizontalAutoCount=\"0\" AGverticalAutoCount=\"0\" AGhorizontalAutoRefer=\"0\" AGverticalAutoRefer=\"0\" AGSelection=\"0 0 0 0\""), pageobj2);
		pageobj2.setAttribute("PAGEYPOS", String.valueOf(Float.parseFloat(pageobj2.getAttribute("PAGEYPOS")) * page));
			
		xml.getMainElement().appendChild(pageobj);
		xml.getMainElement().appendChild(pageobj2);
	}
	
	public static String formatClassName(final String input) {
		return classformat.format(Integer.parseInt(input.replaceAll("[a-zA-Z]+", ""))) + input.replaceAll("[0-9]+", "");
	}
}
