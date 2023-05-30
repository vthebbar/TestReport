package com.qa.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFReader {

	public static String getPdfContent(String url)  {
		
		String stripText=null;
		
		try {
		 URL pdfURL = new URL(url);
	     InputStream is = pdfURL.openStream();
		 BufferedInputStream bis = new BufferedInputStream(is);
		 PDDocument doc = PDDocument.load(bis);
		 PDFTextStripper strip = new PDFTextStripper();
		 stripText = strip.getText(doc);
		 System.out.println(stripText);
		 doc.close();
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		 return stripText;
       }
}
