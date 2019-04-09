package com.zth;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class Demo01 {
	
	public static void main(String agrs[]) throws Exception{
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parse = spf.newSAXParser();

		File file = new File("G:\\test\\xml\\res\\stus.xml");

		parse.parse(file,new MyHandler());
		
		
	}

	public static class MyHandler extends DefaultHandler{
		@Override
		public void startDocument() throws SAXException {
			System.out.println("开始解析文档。。。。");
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("结束文档解析。。。");
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			System.out.println("开始元素：："+qName);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println("结束元素：："+qName);
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			System.out.println("文本内容:::"+new String(ch,start,length));
		}

		@Override
		public void error(SAXParseException e) throws SAXException {
			System.out.println("出错了。。。。");
		}
	}

}

