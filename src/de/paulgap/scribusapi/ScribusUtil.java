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
	
	public static TreeMap<String, String> stringToAttributes(final String attributestring) {
		final TreeMap<String, String> tmpAttributes = new TreeMap<String, String>();
		final String[] splits = attributestring.split("[\"][ ]");
		
		for (final String p : splits) {
			final String[] attributes = p.replaceAll("\"", "").split("=");
			if (attributes.length == 2) {
				tmpAttributes.put(attributes[0], attributes[1]);
			}
		}
		
		return tmpAttributes;
	}
	
	public static void setAttributesFromMap(final TreeMap<String, String> map, final Element element) {
		for (final Entry<String, String> entry : map.entrySet()) {
			element.setAttribute(entry.getKey(), entry.getValue());
		}
	}
	
	public static Element createTextElement(final String text, final ScribusXML xml) {
		final Element tmp = xml.getRootDocument().createElement("ITEXT");
		tmp.setAttribute("CH", text);
		return tmp;
	}
	
	public static <T, X> void putIfAbsent(final Map<T, X> map, final T key, final X value) {
		if (!map.containsKey(key)) map.put(key, value);
	}
}
