import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static utils.FileUtils.readAsString;

public class Main {
  public static Logger logger = Logger.getLogger(Main.class);

  public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
    String filePath = "C:\\env\\gx_client.xml";

    String xml = readAsString(filePath);

    Document xmlParse = parse(filePath);

    xmlParse.getDocumentElement().normalize();
    Element root = xmlParse.getDocumentElement();

    NodeList nList = root.getChildNodes();

    Node entry = nList.item(5);

    for (int i = 0; i < entry.getAttributes().getLength(); i++) {
      logger.info(entry.getAttributes().item(i).getNodeName() + " = " + entry.getAttributes().item(i).getNodeValue());
    }


  }

  public static Document parse(String path) throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setValidating(true);
    factory.setIgnoringElementContentWhitespace(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    File file = new File(path);
    Document doc = builder.parse(file);
    // Do something with the document here.
    return  doc;
  }
}
