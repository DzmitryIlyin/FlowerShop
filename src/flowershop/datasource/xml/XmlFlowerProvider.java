package flowershop.datasource.xml;

import flowershop.datasource.FlowerCreator;
import flowershop.datasource.FlowerProvider;
import flowershop.flower.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlFlowerProvider extends FlowerCreator implements FlowerProvider {

    //    XML nodes constants
    private static final String FLOWER_TAG_NAME = "Flower";
    private static final String FLOWER_NAME_TAG = "FlowerName";
    private static final String FLOWER_SIZE_TAG = "FlowerSize";
    private static final String FLOWER_PRICE_TAG = "FlowerPrice";
    private static final String COLOR_TAG = "color";
    private static final String PETAL_TAG = "petal";
    private static final String DENSITY_TAG = "density";
    private static final String FLOWERS_XML_FILE = "FlowersXML.xml";

    private Map<String, Flower> storage = new HashMap<>();

    public XmlFlowerProvider() {
        try {
            List<Flower> flowers = readXmlDoc();
            for(Flower flower:flowers){
                storage.put(flower.getFlowerName(), flower);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Flower> readXmlDoc() throws Exception {
        List<Flower> result = new ArrayList<>();

        try {
            File flowerXML = new File(FLOWERS_XML_FILE);
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = f.newDocumentBuilder();
            Document document = db.parse(flowerXML);
            document.getDocumentElement().normalize();

            NodeList nl = document.getElementsByTagName(FLOWER_TAG_NAME);
            for (int tmp = 0; tmp < nl.getLength(); tmp++) {
                Node node = nl.item(tmp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    String name = getNodeText(e, FLOWER_NAME_TAG);
                    String size = getNodeText(e, FLOWER_SIZE_TAG);
                    String price = getNodeText(e, FLOWER_PRICE_TAG);
                    String color = getNodeText(e, COLOR_TAG);
                    String petal = getNodeText(e, PETAL_TAG);
                    String density = getNodeText(e, DENSITY_TAG);

                    result.add(createFlower(name, getIntValue(size), getIntValue(price), color, getIntValue(petal), getIntValue(density)));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String getNodeText(Element e, String tagName){
        try{
            return e.getElementsByTagName(tagName).item(0).getTextContent();
        } catch (NullPointerException npe){
            return null;
        }

    }

    @Override
    public Flower getFlowerByName(String name) {
        return storage.get(name);
    }
}