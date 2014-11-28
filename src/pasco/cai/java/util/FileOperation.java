package pasco.cai.java.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileOperation {
	
	public void write(String path, String content) {
	      String oldStr = new String();
	      String newStr = new String();
	      try {
	    	  File file = new File(path);
	    	  if (file.exists()) {
	    		  //System.out.println("文件存在");
	    	  } else {
	    		  //System.out.println("文件不存在，正在創建...");
	    		  if (file.createNewFile()) {
	    			  //System.out.println("文件創建成功！");
	    		  } else {
	    			  //System.out.println("文件創建失敗！");
	    		  }
	    	  }
	    	  BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
	    	  while ((oldStr = input.readLine()) != null) {
	    		  newStr += oldStr;
	    	  }
	    	  //System.out.println("文件內容：" + newStr);
	    	  input.close();
	    	  newStr += content;

	    	  PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8")));
	    	  output.write(newStr);
	    	  output.close();
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	}
	
	public void read(String filename) {
		String str = null;
		StringBuffer buffer = new StringBuffer();
		File file = new File(filename);
		if (file.exists()) {
			//System.out.println("文件存在！");
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
				while ((str = reader.readLine()) != null) {
					buffer.append(str);
				}
				System.out.println(buffer);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("文件不存在！");
		}
	}
	
	public String getFileContent(String path) {
		String str = null;
		String returnStr = null;
		StringBuffer buffer = new StringBuffer();
		File file = new File(path);
		if (file.exists()) {
			//System.out.println("文件存在！");
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
				while ((str = reader.readLine()) != null) {
					buffer.append(str);
				}
				returnStr = buffer.toString();
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("文件不存在！");
		}
		return returnStr;
	}
	
	public boolean createFolder(String path) {
		File file =new File(path);
		if(!file.exists()&&!file.isDirectory()) {     // 不存在
		    file.mkdir();
		    if(file.isDirectory())
		    	return true;
		} else {	// 存在
			if(file.isDirectory())	// 是目錄
				return true;
		}
		return false;
	}
}
