package pasco.cai.java.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileOperation {
	
	private String newLineChar[] = {"<br>", "\r\n"}; 

	public void write(int logType, String path, String content) {
	      String s = new String();
	      String s1 = new String();
	      if(logType==1)
	    	  System.out.println(content);
	      else{
	    	  try {
		    	  File f = new File(path);
		    	  if (f.exists()) {
		    		  System.out.println("文件存在");
		    	  } else {
		    		  System.out.println("文件不存在，正在創建...");
		    		  if (f.createNewFile()) {
		    			  System.out.println("文件創建成功！");
		    		  } else {
		    			  System.out.println("文件創建失敗！");
		    		  }
		    	  }
		    	  BufferedReader input = new BufferedReader(new FileReader(f));
		    	  while ((s = input.readLine()) != null) {
		    		  s1 = s1 + s + newLineChar[1];
		    	  }
		    	  System.out.println("文件內容：" + s1);
		    	  input.close();
		    	  s1 += content;

		    	  BufferedWriter output = new BufferedWriter(new FileWriter(f));
		    	  output.write(s1);
		    	  output.close();
		      } catch (Exception e) {
		    	  e.printStackTrace();
		      }
	      }
	}
	
	public void write(int logType, String path, String content, String color) {
	      String s = new String();
	      String s1 = new String();
	      if(logType==1){
	    	  System.out.println(content);
	      } else{
	    	  try {
		    	  File f = new File(path);
		    	  if (f.exists()) {
		    		  System.out.println("文件存在");
		    	  } else {
		    		  System.out.println("文件不存在，正在創建...");
		    		  if (f.createNewFile()) {
		    			  System.out.println("文件創建成功！");
		    		  } else {
		    			  System.out.println("文件創建失敗！");
		    		  }
		    	  }
		    	  BufferedReader input = new BufferedReader(new FileReader(f));
		    	  while ((s = input.readLine()) != null) {
		    		  s1 = s1 + s + newLineChar[logType];
		    	  }
		    	  System.out.println("文件內容：" + s1);
		    	  input.close();
		    	  content = "<span style=\"color:" + color + "\">" + content + "</span>";
		    	  s1 += content;

		    	  BufferedWriter output = new BufferedWriter(new FileWriter(f));
		    	  output.write(s1);
		    	  output.close();
		      } catch (Exception e) {
		    	  e.printStackTrace();
		      }
	      }
	}
	
	public void write(String path, String content) {
	      String oldStr = new String();
	      String newStr = new String();
	      try {
	    	  File f = new File(path);
	    	  if (f.exists()) {
	    		  //System.out.println("文件存在");
	    	  } else {
	    		  //System.out.println("文件不存在，正在創建...");
	    		  if (f.createNewFile()) {
	    			  //System.out.println("文件創建成功！");
	    		  } else {
	    			  //System.out.println("文件創建失敗！");
	    		  }
	    	  }
	    	  BufferedReader input = new BufferedReader(new FileReader(f));
	    	  while ((oldStr = input.readLine()) != null) {
	    		  newStr += oldStr;
	    	  }
	    	  //System.out.println("文件內容：" + newStr);
	    	  input.close();
	    	  newStr += content;

	    	  BufferedWriter output = new BufferedWriter(new FileWriter(f));
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
			System.out.println("文件存在！");
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
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
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				while ((str = reader.readLine()) != null) {
					buffer.append(str);
				}
				//System.out.println(buffer);
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
