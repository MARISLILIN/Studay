package org.javaWeb.Xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class MainTest2 {
  public static void main(String[] args) {
      try {
          //1创建sax读取对象
          SAXReader reader = new SAXReader();
          //2指定解析的xml源
          Document document = reader.read(new File("src/main/java/org/javaWeb/Xml/demo.xml"));

      // 3得到元素
          Element rootElement = document.getRootElement();
          //要想使用xpath，需要添加支持的jar    jaxen
          Element nameElement = (Element) rootElement.selectSingleNode("//name");

      System.out.println(nameElement.getText());

          List<Element> list = rootElement.selectNodes("//name");

      for (Element element : list) {
        System.out.println(element.getText());
      }

      } catch (DocumentException e) {
          e.printStackTrace();
      }


  }
}
