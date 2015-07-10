package de.paulgap.scribusapi;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.w3c.dom.Element;

public class ScribusUtil {
	
	/**
	 *  @author Paul Gschwendtner <paulgschwendtner@me.com>
	 *  @version 0.1
	 *  @category Scribus Java API Implementation
	 */
	
	public static TreeMap<String, String> stringToAttributes(String attributestring) {
		TreeMap<String, String> tmpAttributes = new TreeMap<String, String>();
		String[] splits = attributestring.split("[\"][ ]");
		
		for (String p : splits) {
			final String[] attributes = p.replaceAll("\"", "").split("=");
			if (attributes.length == 2) {
				tmpAttributes.put(attributes[0], attributes[1]);
			}
		}
		
		return tmpAttributes;
	}
	
	public static void setAttributesFromMap(TreeMap<String, String> map, Element element) {
		for (Entry<String, String> entry : map.entrySet()) {
			element.setAttribute(entry.getKey(), entry.getValue());
		}
	}
	
	public static Element createTextElement(String text, ScribusXML xml) {
		Element tmp = xml.getRootDocument().createElement("ITEXT");
		tmp.setAttribute("CH", text);
		return tmp;
	}
	
	public static <T, X> void putIfAbsent(Map<T, X> map, T key, X value) {
		if (!map.containsKey(key)) map.put(key, value);
	}
}
