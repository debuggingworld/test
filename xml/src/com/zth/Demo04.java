package com.zth;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;


/**
 * DOM 修改 XML 文件后写入磁盘
 */
public class Demo04 {
    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse("res/stus.xml");


        Element stus = (Element) document.getElementsByTagName("stus").item(0);

        Element e = document.createElement("stu");
        stus.appendChild(e);
        Element newstu = (Element) document.getElementsByTagName("stus").item(0).getLastChild();
        Element name = document.createElement("name");
        Element age = document.createElement("age");
        Element sex = document.createElement("sex");

        name.setAttribute("id", "2");

        Text nameText = document.createTextNode("咯咯");
        Text ageText = document.createTextNode("18");
        Text sexText = document.createTextNode("女");

        newstu.appendChild(name);
        newstu.appendChild(age);
        newstu.appendChild(sex);

        name.appendChild(nameText);
        age.appendChild(ageText);
        sex.appendChild(sexText);

        saveXML(document);

    }

    public static void saveXML(Document document) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);

        FileOutputStream out = new FileOutputStream("res/stus1.xml");
        StreamResult streamResult = new StreamResult(out);

        transformer.transform(domSource, streamResult);

        out.close();

    }

}
