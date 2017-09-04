import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;

import java.io.*;

public class XMLParser {
	
	private String INPUTFILE = "/Users/thomasleysen/Documents/School/MOD 2/Webtok 3/restlet-jse-2.3.10/WebContent/WEB-INF/lib/bestellingen.xml";
	
	/** Get all races from the xml file and return them 
	 * in html format
	 */
	public String getBestellingen() {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Bestellingen</h2>";
	        
	        NodeList bestellingen = doc.getElementsByTagName("bestelling");

	        for (int i = 0; i < bestellingen.getLength(); i++) {
	        	 Node nNode = bestellingen.item(i);
	        	 Element eElement = (Element) nNode;
	        	 
	        	 result += "<br/><b>Naam klant : </b>" + eElement.getAttribute("name");
				 result += "<br/><b>Adres : </b>" + eElement.getAttribute("address");
				 result += "<br/><b>Datum bestelling : </b>" + eElement.getAttribute("date");
				 result += "<br/><b>Product: </b>" + eElement.getAttribute("product");
				 result += "<br/><b>Hoeveelheid : </b>" + eElement.getAttribute("amount");
	        	 result += "<br/>";
	        }
	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	public String addBestelling(String xml) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        dbFactory.setValidating(false);
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc1 = dBuilder.parse(inputFile);
	        Document doc2 = dBuilder.parse(new InputSource(new StringReader(xml)));
	        Element element = (Element) doc2.getDocumentElement();

	        Node copiedNode = doc1.importNode(element, true);
	        doc1.getDocumentElement().appendChild(copiedNode);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc1);
			StreamResult result = new StreamResult(new File(INPUTFILE));
			transformer.transform(source, result);
	        
	        return this.getBestellingen();
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
}
