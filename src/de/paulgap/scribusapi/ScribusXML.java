package de.paulgap.scribusapi;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ScribusXML {
	
	/**
	 *  @author Paul Gschwendtner <paulgschwendtner@me.com>
	 *  @version 0.1
	 *  @category Scribus Java API Implementation
	 */
	
	private final File file;
	private Document xmlDoc;
	
	// ELEMENTS
	private Element scribusroot;
	
	public ScribusXML(final File file) {
		this.file = file;
	}
	
	public boolean load() {
		try {
			this.xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.file);
		} catch (final Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		
		this.validate();
		
		this.scribusroot = (Element) xmlDoc.getDocumentElement().getElementsByTagName("DOCUMENT").item(0);
		
		return true;
	}
	
	public Document getRootDocument() {
		return this.xmlDoc;
	}
	
	public Element getMainElement() {
		return this.scribusroot;
	}
	
	private void validate() {
		if (!xmlDoc.getDocumentElement().getTagName().equals("SCRIBUSUTF8NEW")) throw new IllegalStateException("Error: Not a Scribus Layout File.");
		if (xmlDoc.getDocumentElement().getElementsByTagName("DOCUMENT").getLength() == 0) throw new IllegalStateException("Error: Not a valid Scribus Layout File -> No Document Tag");
	}
	
	public void appendObject(final ScribusObject object) {
		for (final Element element : object.toDOMNode()) {
			scribusroot.appendChild(element);
		}
	}
	
	public void saveTo(final File output) {
		try {
			final Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");			
			transformer.transform(new DOMSource(xmlDoc), new StreamResult(output));
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public void setPages(final int page) {
		scribusroot.setAttribute("ANZPAGES", String.valueOf(page));
		((Element) ((Element) scribusroot.getElementsByTagName("Sections").item(0)).getElementsByTagName("Section").item(0)).setAttribute("To", String.valueOf(Integer.parseInt(String.valueOf(page)) * 2));
	}
}
