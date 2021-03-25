package org.javaWeb.Xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class MainTest {
  public static void main(String[] args) {
      try {
          //1创建sax读取对象
          SAXReader reader = new SAXReader();
          //2指定解析的xml源
          Document document = reader.read(new File("src/main/java/org/javaWeb/Xml/demo.xml"));

      // 3得到元素
          Element rootElement = document.getRootElement();
//      System.out.println(rootElement.element("stu").element("age").getText());
          List<Element> elements = rootElement.elements();
      for (Element element : elements) {
          String name = element.element("name").getText();
          String age = element.element("age").getText();
          String des = element.element("des").getText();

        System.out.println(name + "---" + age + "---" + des);
      }


      } catch (DocumentException e) {
          e.printStackTrace();
      }


  }
}
