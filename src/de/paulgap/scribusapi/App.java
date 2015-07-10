package de.paulgap.scribusapi;

import java.io.File;

import de.paulgap.autoannual.Bootstrap;

public class App {

	/**
	 *  @author Paul Gschwendtner <paulgschwendtner@me.com>
	 *  @version 0.1
	 *  @category Scribus Java API Implementation
	 */
	
	public static void main(String[] args) {
				
		System.out.println("###### STARTING SCRIBUS API ######");
		
		final ScribusXML sxml = new ScribusXML(new File("template.sla"));
		final Bootstrap boot = new Bootstrap(sxml);
		
		sxml.load();
		boot.startup();
		
		sxml.saveTo(new File("Klassen.sla"));
		
		System.out.println("###### XML SUCCESSFUL SAVED #######");
	}
	
}
