package com.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Demo05 {

	public static void main(String[] args)throws Exception {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		
		
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(new File("c:\\students.xml"));
		
			NodeList names=doc.getElementsByTagName("name");
			if(null!=names&&names.getLength()>0)
			{
				for(int i=0;i<names.getLength();i++)
				{
				Element name=(Element)names.item(i);
				System.out.println(name.getFirstChild().getNodeValue());
				}
			}

	}

}
