import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

public class XmlModificationDom {

	public static void main(String[] args) {
		XmlModificationDom XmlModificationDom = new XmlModificationDom();
		XmlModificationDom.updateXmlAndSave();
	}
	
	public void updateXmlAndSave() {
		try {
			File inputFile = new File("document.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(inputFile);
			document.getDocumentElement().normalize();

			Node parentNode = document.getFirstChild();
			iterateChildNodesAndUpate(parentNode);

			writeAndSaveXML(document);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void writeAndSaveXML(Document document) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("updated-document.xml"));
		transformer.transform(source, result);
	}

	public void iterateChildNodesAndUpate(Node parentNode) {

		NodeList nodeList = parentNode.getChildNodes();

		for (int index = 0; index < nodeList.getLength(); index++) {
			Node node = nodeList.item(index);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				//System.out.print(element.getNodeName());

				if (element.hasChildNodes() && element.getChildNodes().getLength() > 1) {
					//System.out.println("Child > " + element.getNodeName());
					iterateChildNodesAndUpate(element);
				} else {
					//System.out.println(" - " + element.getTextContent());
					if (element.getTextContent().contains("'")) {
						String str = element.getTextContent().replaceAll("\'", "\"");
						element.setTextContent(str);
					}
				}
			}
		}
	}
}
