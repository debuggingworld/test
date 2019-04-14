package com.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;

public class Demo01 {
    public static void main(String[] args) throws Exception {

        /*Document document = DocumentHelper.createDocument();
        Element root = DocumentHelper.createElement("stus");
        document.setRootElement(root);*/

        Element root = DocumentHelper.createElement("stus");
        Document document = DocumentHelper.createDocument(root);

        Element stu1 = root.addElement("stu");
        stu1.addAttribute("id","01");
        Element name = stu1.addElement("name");
        name.setText("张三");
        Element age = stu1.addElement("age");
        Element sex = stu1.addElement("sex");

        name.setText("zhangsan");
        age.setText("18");
        sex.setText("男");

        // org.dom4j.io.OutputFormat;
        // 缩进和换行
        OutputFormat format = new OutputFormat("    ",true);
        // 使用美化格式
        OutputFormat format1 = OutputFormat.createPrettyPrint();
        format1.setEncoding("utf-8");
        format1.setIndent("    ");

        //XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("res/stus2.xml"));
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("res/stus2.xml"),format1);
        xmlWriter.write(document);
        xmlWriter.close();
        System.out.println("OVER");

    }
}
