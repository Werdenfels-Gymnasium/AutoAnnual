package de.paulgap.scribusapi;

import java.util.List;

import org.w3c.dom.Element;

public interface ScribusObject {
	
	/**
	 *  @author Paul Gschwendtner <paulgschwendtner@me.com>
	 *  @version 0.1
	 *  @category Scribus Java API Implementation
	 */
	
	public List<Element> toDOMNode();
	
}
