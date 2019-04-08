package com.dom;

import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;

public class Demo02 {

	public static void main(String[] args) {
		
	 	//Properties p=System.getProperties();
		//p.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.dom.MyDocumentBuilderFactory");
		//System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.dom.MyDocumentBuilderFactory");
       
		
		//抽像类
		DocumentBuilderFactory   dbf=DocumentBuilderFactory.newInstance();
	    System.out.println(dbf);
	}

}
