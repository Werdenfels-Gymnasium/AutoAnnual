package de.paulgap.scribusapi;

import java.util.Map;
import java.util.TreeMap;

public class ScribusAttributeObject {

	public final TreeMap<String, String> rootattributes = new TreeMap<String, String>();
	public final TreeMap<String, TreeMap<String, String>> attributes = new TreeMap<String, TreeMap<String, String>>();

	public void setRootAttribute(final String key, final String value) {
		rootattributes.put(key, value);
	}
	
	public void setRootAttributes(final Map<String, String> attributes) {
		rootattributes.clear();
		rootattributes.putAll(attributes);
	}

	public void setAttribute(final String mapname, final String key, final String value) {
		ScribusUtil.putIfAbsent(this.attributes, mapname, new TreeMap<String, String>());
		attributes.get(mapname).put(key, value);
	}
	
	public void setAttributes(final String mapname, final Map<String, String> attributes) {
		ScribusUtil.putIfAbsent(this.attributes, mapname, new TreeMap<String, String>());
		this.attributes.get(mapname).putAll(attributes);
	}
	
	public String getAttribute(final String mapname, final String key) {
		return this.attributes.get(mapname).get(key);
	}
	
	public TreeMap<String, String> getRootAttributes() {
		return this.rootattributes;
	}
	
	public TreeMap<String, String> getAttributes(final String mapname) {
		return this.attributes.get(mapname);
	}
}
