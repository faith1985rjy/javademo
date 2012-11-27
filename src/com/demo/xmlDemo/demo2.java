package com.demo.xmlDemo;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class demo2 {

	@Test
	public void read() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		NodeList list = document.getElementsByTagName("����");
		Node node = list.item(1);

		String content = node.getTextContent();
		System.out.println(content);
	}

	@Test
	public void read1() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		Node root = document.getElementsByTagName("���").item(0);

		list(root);
	}

	private void list(Node node) {
		System.out.println(node.getNodeName());

		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node child = list.item(i);
			list(child);
		}
	}

	
	@Test
	public void read2() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		Node root = document.getElementsByTagName("���").item(0);

		listOut(root);
	}
	private void listOut(Node node) {
		if (node instanceof Element) {
			System.out.println(node.getNodeName());
		}
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node child = list.item(i);
			listOut(child);
		}
	}

	@Test
	public void read3() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		Element bookname = (Element) document.getElementsByTagName("����").item(0);
		
		String value = bookname.getAttribute("name");
		System.out.println(value);
	}
	// ��ĩβ�����ǩ
	@Test
	public void add() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		Element price = document.createElement("�ۼ�");
		price.setTextContent("59.00Ԫ");
		
		Element book = (Element) document.getElementsByTagName("��").item(0);
		book.appendChild(price);
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
//��ָ��λ�ò����ǩ
	@Test
	public void add2() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		Element price = document.createElement("�ۼ�");
		price.setTextContent("100.00Ԫ");
		
		Element refNode = (Element) document.getElementsByTagName("�ۼ�").item(0);
		Element book = (Element) document.getElementsByTagName("��").item(0);
		book.insertBefore(price, refNode);
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	//��������
	// name = "xxxx";
	@Test
	public void add3() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		Element bookname = (Element) document.getElementsByTagName("����").item(0);
		bookname.setAttribute("name", "xxxxx");
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	//ɾ����ǩ
	@Test
	public void delete() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		Element e = (Element) document.getElementsByTagName("�ۼ�").item(0);
			
		Element book = (Element) document.getElementsByTagName("��").item(0);
		book.removeChild(e);
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	//ɾ�����׵ı�ǩ
	@Test
	public void delete2() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		Element e = (Element) document.getElementsByTagName("�ۼ�").item(0);
		e.getParentNode().removeChild(e);
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	
	@Test
	public void update() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		Element e = (Element) document.getElementsByTagName("�ۼ�").item(0);
		
		e.setTextContent("1000Ԫ");
		
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
		
}
