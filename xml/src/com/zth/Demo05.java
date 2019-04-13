package com.zth;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Demo05 {
    public static void main(String[] args) throws Exception{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse("res/stus.xml");

        // 获取根节点
        Element root = document.getDocumentElement();
        allEle(root);
    }

    public static void allEle(Node node){

        NodeList chileNode = node.getChildNodes();//获取子节点

        int length = chileNode.getLength();

        if(length == 0){    // 没有子节点

            System.out.print(node.getNodeValue());//输出node中的内容

        }else{
            System.out.print("<"+node.getNodeName());

            NamedNodeMap nnm = node.getAttributes();

            if(nnm.getLength() != 0){
                for (int i = 0; i < nnm.getLength(); i++) {
                    Node node2 =  nnm.item(i);
                    System.out.print(" "+node2.getNodeName());
                    System.out.print("=\""+node2.getNodeValue()+"\"");
                }
            }
            System.out.print(">");
            for (int i = 0; i <length ; i++) {
                allEle(chileNode.item(i));
            }
            System.out.println("</"+node.getNodeName()+">");
        }
    }

}
