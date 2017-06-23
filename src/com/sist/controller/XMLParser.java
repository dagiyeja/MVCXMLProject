package com.sist.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
// <bean id="list" class="ListModel"/>
/*
 *   <?xml version="1.0" encoding="UTF-8">
 *     startDocument()
 *   <a> startElement()
 *    <b>aaa</b> startElement() charactors
 *               endElement
 *   </a> endElement
 *    endDocument
 */
import java.util.*;
public class XMLParser extends DefaultHandler{
    public Map map=new HashMap();
	@Override
	public void startElement(String uri, 
			String localName, String qName, 
			Attributes attributes) throws SAXException {
		try
		{
			if(qName.equals("bean"))
			{
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				Class clsName=Class.forName(cls);
				Object obj=clsName.newInstance();
				map.put(id, obj);
				// COUNT,MAX,NVL ,SUBSTR,TO_CHAR,INSTR,RPAD
				// substring(1,2) 
				// SUBSTR(5,1)
				// 리플렉션 => 클래스 정보를 읽어서 제어
				// 메소드,생성자 ,멤버변수,생성자의 매개변수 
				/*
				 *    @
				 *    public class A
				 *    {
				 *       @
				 *       B b;
				 *       @
				 *       public A(B b)
				 *       {
				 *       }
				 *       @
				 *       public void display()
				 *       {
				 *       }
				 *    }
				 */
			}
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
   
}



