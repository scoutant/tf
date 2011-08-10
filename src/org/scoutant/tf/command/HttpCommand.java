package org.scoutant.tf.command;

import java.io.IOException;
import java.net.URI;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.util.Log;

public abstract class HttpCommand implements Command {

	private static final String tag = "http";
	protected DocumentBuilder builder;
	public HttpCommand() {
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	protected Document doGet(URI uri) {
		return doGet(""+uri);
	}

	protected Document doGet(String url) {
		Document doc=null;
		Log.i (tag, "doGet with url : " + url); 
		try {
			doc = builder.parse( url);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
    /**
     * Will get the value of a child element like following : <distance>7.1866</distance>
     */
    protected String valueFor(Node node, String name) {
    	if (name == null || name.length() == 0 ) return null;
		NodeList props = node.getChildNodes();
    	for (int p = 0; p<props.getLength(); p++) {
    		if ( name.equals( props.item(p).getNodeName())) {
    			Node text = props.item(p).getFirstChild();
    			return ( text == null ? null : text.getNodeValue());
    		}
    	}
    	return null;
    }
	
}
