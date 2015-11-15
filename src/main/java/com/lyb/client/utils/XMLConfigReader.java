package com.lyb.client.utils;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLConfigReader {

	private Document document = null;

	public void load(URL url) throws DocumentException {
		SAXReader reader = new SAXReader();
		document = reader.read(url);
	}

	public Document getDocument() {
		return document;
	}

	public void load(String file) throws DocumentException,
			MalformedURLException {
		load(new File(file));
	}

	public void load(File file) throws DocumentException, MalformedURLException {
		SAXReader reader = new SAXReader();
		document = reader.read(file);
	}

	public void load(Reader source) throws DocumentException {
		SAXReader reader = new SAXReader();
		document = reader.read(source);
	}

	public void load(InputStream source) throws DocumentException {
		SAXReader reader = new SAXReader();
		document = reader.read(source);
	}

	public String readString(String path, String defaultValue) {
		Element e = getSingleElement(path);
		if (null != e)
			return e.getTextTrim();
		else
			return defaultValue;

	}

	public String readString(String path) {
		return readString(path, "");
	}

	public List<String> readMultiString(String path) {
		List<String> values = new LinkedList<String>();

		List<Element> list = getMultiElement(path);
		if (null != list && list.size() > 0) {
			for (Iterator<Element> iter = list.iterator(); iter.hasNext();) {
				Element element = (Element) iter.next();
				values.add(element.getTextTrim());
			}
		}

		return values;
	}

	@SuppressWarnings("unchecked")
	public Element getSingleElement(String path) {
		List<Element> list = document.selectNodes(path);
		Element e = null;
		if (null != list && list.size() == 1) {
			e = list.get(0);
		}

		return e;
	}

	@SuppressWarnings("unchecked")
	public List<Element> getMultiElement(String path) {
		List<Element> list = document.selectNodes(path);
		return list;
	}

	public int readInt(String path, int defaultValue) {
		Element e = getSingleElement(path);
		int value = defaultValue;
		try {
			value = Integer.parseInt(e.getTextTrim());
		} catch (NumberFormatException nfe) {
		}
		;

		return value;
	}

	public byte readByte(String path, byte defaultValue) {
		Element e = getSingleElement(path);
		byte value = defaultValue;
		try {
			value = Byte.parseByte(e.getTextTrim());
		} catch (NumberFormatException nfe) {
		}
		;

		return value;
	}

	public long readLong(String path, long defaultValue) {
		Element e = getSingleElement(path);
		long value = defaultValue;
		try {
			value = Long.parseLong(e.getTextTrim());
		} catch (NumberFormatException nfe) {
		}
		;

		return value;
	}

	public boolean readBoolean(String path, boolean defaultValue) {

		String value = readString(path);
		if (null != value
				&& (value.equalsIgnoreCase("true") || value
						.equalsIgnoreCase("false"))) {
			return ((value != null) && value.equalsIgnoreCase("true"));
		} else
			return defaultValue;
	}

}
