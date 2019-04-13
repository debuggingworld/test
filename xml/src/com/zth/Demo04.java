package com.zth;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * DOM 修改 XML 文件后写入磁盘
 */
public class Demo04 {
    public static void main(String[] args) throws Exception{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse("res/stus.xml");

        Element stus = (Element)document.getElementsByTagName("stus").item(0);

        Element e = document.createElement("stu");
        stus.appendChild(e);
        Element newstu = (Element)document.getElementsByTagName("stus").item(0).getLastChild();

        Element name = document.createElement("stu");
        Element age = document.createElement("stu");
        Element sex = document.createElement("stu");

        Text nameText = document.createTextNode("咯咯");
        Text ageText = document.createTextNode("18");
        Text sexText = document.createTextNode("女");

        newstu.appendChild(name);
        newstu.appendChild(age);
        newstu.appendChild(sex);

    }
}
