import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NodeList;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XmlParse {

	public static void main(String[] args) {
		XmlParse xmlParse = new XmlParse();
		xmlParse.xmlToObj();

	}

	public void xmlToObj() {

		try {
			
			File inputFile = new File("sam.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("Row");
			
			Node node = null;
			List<Sam> samList = new ArrayList<>();
			if(nodeList != null && nodeList.getLength() > 0) {
				for(int i=0; i < nodeList.getLength(); i++) {
					node = nodeList.item(i);
					NodeList innerNodeList =  doc.getElementsByTagName("Col");
					
					Node innerNodeID = innerNodeList.item(0);
					Node innerNodeType = innerNodeList.item(1);
					
					String id =  innerNodeID.getTextContent();
					String type = innerNodeType.getTextContent();
					Sam sam = new Sam(id, type, null);
					System.out.println(sam.toString());
					
					samList.add(sam);
				}
				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class Sam {
	String id;
	String type;
	String data;
	public Sam(String id, String type, String data) {
		this.id = id;
		this.type = type;
		this.data = data;
	}
	@Override
	public String toString() {
		return "Sam [id=" + id + ", type=" + type + ", data=" + data + "]";
	}
	
}
