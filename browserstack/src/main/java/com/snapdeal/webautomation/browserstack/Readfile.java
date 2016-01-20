package com.snapdeal.webautomation.browserstack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Readfile {
	
	
	public String readpropertyvariable(String parameter,String filename)
	{
	File file = new File(filename);
	String query=parameter;
	FileInputStream fileInput =null;
	
	try 
	{
		fileInput = new FileInputStream(file);
	} 
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	Properties prop = new Properties();
	
	
	
	
	//load properties file
	try 
	{
		prop.load(fileInput);
	}
	catch (IOException e1) 
	{
		e1.printStackTrace();
	}
	

	return prop.getProperty(query);

}
	
	public String Readfiledata(String filename,String folderpath) throws IOException 
	{
	String filenamewithlocation=folderpath+filename+".txt";	
	File file = new File(filenamewithlocation);
	String jsonData = null;
	
		BufferedReader br = new BufferedReader(new FileReader(file));

		jsonData = br.readLine();
		
		
		br.close();
        return jsonData;
	
	
	
	


}
	
}	

	
	


