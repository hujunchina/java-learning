import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.IOException;

public class MyDom {
    public static void main(String[] args) {
        try{
//            工厂模式，先得到工厂实例对象，然后让工厂创建一个对象
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
//            声明此对象用于解析操作
            Document doc = db.parse("school.xml");
//            得到从根节点开始的所有节点
            NodeList root = doc.getElementsByTagName("*");
            Node node = root.item(2);
            System.out.println(node.getNodeName());
            System.out.println(node.getChildNodes().item(0).getNodeValue());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
