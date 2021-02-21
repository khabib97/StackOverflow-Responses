import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NodeList;
import org.jdom2.input.SAXBuilder;
import org.jdom2.transform.JDOMSource;
import org.w3c.dom.*;

import java.io.*;

public class XmlModificationJDom {

	public static void main(String[] args) {
		XmlModificationJDom xmlModificationJDom = new XmlModificationJDom();
		xmlModificationJDom.updateXmlAndSaveJDom();

	}

	public void updateXmlAndSaveJDom() {
		try {
			File inputFile = new File("document.xml");
			SAXBuilder saxBuilder = new SAXBuilder();
			org.jdom2.Document xmlDocument = saxBuilder.build(inputFile);
			org.jdom2.Element rootElement = xmlDocument.getRootElement();

			iterateAndUpdateElementsUsingJDom(rootElement);

			saveUpdatedXmlUsingJDomSource(xmlDocument);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void iterateAndUpdateElementsUsingJDom(org.jdom2.Element element) {

		if (element.getChildren().size() == 0) {
			// System.out.println(element.getName() + ","+ element.getText());
			if (element.getText().contains("'")) {
				element.setText(element.getText().replaceAll("\'", "\""));
			}
		} else {
			// System.out.println(element.getName());
			for (org.jdom2.Element childElement : element.getChildren()) {
				iterateAndUpdateElementsUsingJDom(childElement);
			}
		}
	}
}
