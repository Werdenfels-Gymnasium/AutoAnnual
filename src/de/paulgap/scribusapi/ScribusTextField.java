package de.paulgap.scribusapi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.Element;

public class ScribusTextField extends ScribusAttributeObject implements ScribusObject {
	
	/**
	 *  @author Paul Gschwendtner <paulgschwendtner@me.com>
	 *  @version 0.1
	 *  @category Scribus Java API Implementation
	 */
	
	private final ScribusXML xml;
	private final HashMap<String, String> textattributes = new HashMap<String, String>();
	
	public ScribusTextField(ScribusXML xml) {
		this.xml = xml;
	}
	
	public void setTextAttribute(String key, String value) {
		textattributes.put(key, value);
	}

	
	public void setTextAttributes(Map<String, String> attributes) {
		textattributes.clear();
		textattributes.putAll(attributes);
	}


	public List<Element> toDOMNode() {
		
		Element pageobject = xml.getRootDocument().createElement("PAGEOBJECT");
		
		for (Entry<String, String> entry : rootattributes.entrySet()) {
			pageobject.setAttribute(entry.getKey(), entry.getValue());
		}
		
		Element textobject = xml.getRootDocument().createElement("ITEXT");
		
		for (Entry<String, String> entry : textattributes.entrySet()) {
			textobject.setAttribute(entry.getKey(), entry.getValue());
		}		
		
		pageobject.appendChild(textobject);
		
		return Arrays.asList(pageobject);
	}
	

}
