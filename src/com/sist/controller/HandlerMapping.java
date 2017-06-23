package com.sist.controller;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.sist.model.Model;

import java.io.*;
public class HandlerMapping {
  private Map clsMap=new HashMap();
  public HandlerMapping(String path)
  {
	  try
	  {
		  SAXParserFactory spf=
				 SAXParserFactory.newInstance();
		  // WML,HTML,HDML,XML
		  SAXParser sp=spf.newSAXParser();
		  XMLParser xp=new XMLParser();
		  sp.parse(new File(path), xp);
		  clsMap=xp.map;
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
  }
  public Model getBean(String id)
  {
	  return (Model)clsMap.get(id);
  }
}







