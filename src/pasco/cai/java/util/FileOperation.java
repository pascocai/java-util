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
	
	public void read(String file) {
		String s = null;
		StringBuffer sb = new StringBuffer();
		File f = new File(file);
		if (f.exists()) {
			System.out.println("文件存在！");
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				while ((s = br.readLine()) != null) {
					sb.append(s);
				}
				System.out.println(sb);
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("文件不存在！");
		}
	}
}
