package pasco.cai.java.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

public class HTTPRequestPoster {

	public String sendGetRequest(String url, String strCookie) {
		String result = null;
		if (url.startsWith("http://")) {
			try {
				URL getUrl = new URL(url);
				HttpURLConnection conn = (HttpURLConnection) getUrl.openConnection();
				conn.setRequestProperty("cookie", strCookie);
				conn.connect();
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
				result = getResponse(rd);
		        rd.close();
				conn.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url.startsWith("https://")) {
			try {
				URL getUrl = new URL(url);
				HttpsURLConnection conn = (HttpsURLConnection) getUrl.openConnection();
				conn.setRequestProperty("cookie", strCookie);
				conn.connect();
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
				result = getResponse(rd);
		        rd.close();
				conn.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public String sendPostRequest(String url, String strCookie, String postData) {
		String result = null;
		if (url.startsWith("http://")) {
			try {
		        URL postUrl = new URL(url); 
		        HttpURLConnection conn = (HttpURLConnection) postUrl.openConnection();
		        conn.setRequestProperty("cookie", strCookie);
		        conn.setDoOutput(true);
		        conn.setDoInput(true);
		        conn.setRequestMethod("POST");
		        conn.setUseCaches(false);
		        conn.setInstanceFollowRedirects(true);
		        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		        conn.connect();
		        
		        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		        String content = postData + "&activatecode=" + URLEncoder.encode("中文", "utf-8");
		        out.writeBytes(content);
		        out.flush();
		        out.close();
		        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
		        result = getResponse(rd);
		        rd.close();
		        conn.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
    }

	private String getResponse(BufferedReader rd) {
		String line, result=null;
        try {
			while ((line = rd.readLine()) != null){  
			    if(result == null)
			    	result = line;
			    else
			    	result += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        return result;
	}
}
