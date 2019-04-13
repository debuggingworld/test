package com.zth;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class demo03 {
    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse("res/stus.xml");

        NodeList stusList = document.getElementsByTagName("stus");

        Element stus = (Element)stusList.item(0);

        NodeList nodeList = stus.getElementsByTagName("stu");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element)nodeList.item(i);

            System.out.println("姓名："+element.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
            printNodeAttr(element.getElementsByTagName("name").item(0));
            System.out.println("年龄："+element.getElementsByTagName("age").item(0).getFirstChild().getNodeValue());
            System.out.println("性别："+element.getElementsByTagName("sex").item(0).getFirstChild().getNodeValue());
            System.out.println("+++++++++++++++++++++++++++");

        }
    }

    public static void printNodeAttr(Node node){
        NamedNodeMap nodeMap = node.getAttributes();

        for (int i = 0; i < nodeMap.getLength(); i++) {
           Node node1 = nodeMap.item(0);
            System.out.println("\t"+node1.getNodeName()+":::"+node1.getFirstChild().getNodeValue());
        }
    }
}
