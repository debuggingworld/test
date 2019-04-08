package com.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Demo03 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DocumentBuilderFactory   dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder   db=dbf.newDocumentBuilder();
		
		File f=new File("c:\\students.xml");
		//解析为DOM
		Document doc=db.parse(f);
		
		
		Element root=doc.getDocumentElement();
		printNode(root);
	}
	
	
	public static void printNode(Node node)
	{
		System.out.println("-------------"+node.getNodeName()+"  开始------------------------");
		System.out.println("节点类型："+node.getNodeType());
		System.out.println("节点值："+node.getNodeValue());
		System.out.println("节点属性：");
		NamedNodeMap nnm=node.getAttributes();
		if(null!=nnm)
		{
			for(int i=0;i<nnm.getLength();i++)
			{
				Node attr=nnm.item(i);
				printNode(attr);
			}
		}
		System.out.println("子元素:");
		NodeList subs=node.getChildNodes();
		if(null!=subs&&subs.getLength()>0)
		{
			for(int i=0;i<subs.getLength();i++)
			{
				printNode(subs.item(i));
			}
		}
	}

}
