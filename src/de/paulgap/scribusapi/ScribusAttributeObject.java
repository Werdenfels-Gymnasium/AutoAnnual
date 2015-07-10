package de.paulgap.scribusapi;

import java.util.Map;
import java.util.TreeMap;

public class ScribusAttributeObject {

	public final TreeMap<String, String> rootattributes = new TreeMap<String, String>();
	public final TreeMap<String, TreeMap<String, String>> attributes = new TreeMap<String, TreeMap<String, String>>();

	public void setRootAttribute(String key, String value) {
		rootattributes.put(key, value);
	}
	
	public void setRootAttributes(Map<String, String> attributes) {
		rootattributes.clear();
		rootattributes.putAll(attributes);
	}

	public void setAttribute(String mapname, String key, String value) {
		ScribusUtil.putIfAbsent(this.attributes, mapname, new TreeMap<String, String>());
		attributes.get(mapname).put(key, value);
	}
	
	public void setAttributes(String mapname, Map<String, String> attributes) {
		ScribusUtil.putIfAbsent(this.attributes, mapname, new TreeMap<String, String>());
		this.attributes.get(mapname).putAll(attributes);
	}
	
	public String getAttribute(String mapname, String key) {
		return this.attributes.get(mapname).get(key);
	}
	
	public TreeMap<String, String> getRootAttributes() {
		return this.rootattributes;
	}
	
	public TreeMap<String, String> getAttributes(String mapname) {
		return this.attributes.get(mapname);
	}
}
