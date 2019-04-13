package com.zth;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Demo02 {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse("./res/stus.xml");
        NodeList nodeList = document.getElementsByTagName("stu");

        Element element = (Element)nodeList.item(0);

        System.out.println("姓名："+element.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
        System.out.println("年龄："+element.getElementsByTagName("age").item(0).getFirstChild().getNodeValue());
        System.out.println("年龄："+element.getElementsByTagName("age").item(0).getFirstChild().getNodeName());
        System.out.println("性别："+element.getElementsByTagName("sex").item(0).getFirstChild().getNodeValue());

    }

}
