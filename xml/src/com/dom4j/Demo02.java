package com.dom4j;
        import org.dom4j.Document;
        import org.dom4j.Element;
        import org.dom4j.io.DOMReader;
        import org.dom4j.io.SAXReader;
        import javax.xml.parsers.DocumentBuilder;
        import javax.xml.parsers.DocumentBuilderFactory;
        import java.io.File;
        import java.util.Iterator;
        import java.util.List;

public class Demo02 {
    public static void main(String[] args) throws Exception{

        //SAXReader 类来构造dom4j 文档对象
        SAXReader saxReader = new SAXReader();
        org.dom4j.Document document = saxReader.read(new File("res/stus2.xml"));

        //DOMReader类构造dom4j文档对象
      /*  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        org.w3c.dom.Document document1= documentBuilder.parse("res/stus.xml");

        DOMReader domReader = new DOMReader();
        org.dom4j.Document document2 = domReader.read(document1);*/

        Element root = document.getRootElement();

        //root.element("stu");
        List<Element> elements = root.elements();

        Iterator iterator = root.elementIterator();

        while (iterator.hasNext()){
            Element stu = (Element)iterator.next();

            System.out.println("学号："+stu.attributeValue("id"));
            System.out.println("姓名："+stu.elementText("name"));
            System.out.println("年龄："+stu.elementText("age"));
            System.out.println("性别："+stu.elementText("sex"));

            System.out.println("+++++++++++++++++++");
        }

    }
}
