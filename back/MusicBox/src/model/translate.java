package model;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;;

public class translate {

		private static final String SERVICE_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?";
	  private static final String TRANSLATION_LABEL = "text";
	  private static final String API_KEY="trnsl.1.1.20180215T133556Z.d49681c8c1eeac84.6bf90321f2604f2bbf83670823b610ea24caf5a9";
	  private static final String ENCODING="UTF-8";
	
	
	public translate() {
		
		
	}
	
	
	public static String traduci(String from, String to, String text) throws Exception {
		String params =
				"key="+URLEncoder.encode(API_KEY,ENCODING)+
				"&text="+URLEncoder.encode(text,ENCODING)+
				"&lang="+URLEncoder.encode(from+"-"+to,ENCODING);
		System.out.println(SERVICE_URL+params);
				
		URL obj = new URL(SERVICE_URL+params);
		HttpURLConnection con = (HttpsURLConnection) obj.openConnection();	   
		con.addRequestProperty("User-Agent", "Mozilla");
		System.out.println(con.getResponseCode());
		if(200==con.getResponseCode()) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		     String inputLine;
		     StringBuffer response = new StringBuffer();
		     while ((inputLine = in.readLine()) != null) {
		      	response.append(inputLine);
		      }
		     in.close();
		     inputLine=response.toString();
		     inputLine=inputLine.replace(":[", ":");
		     inputLine=inputLine.replace("]}", "}");
		     System.out.println(inputLine);
		     JSONObject risposta = new JSONObject(inputLine);
		     inputLine=risposta.getString("text");
		     inputLine=inputLine.replaceAll("\\ì", "i");
		     inputLine=inputLine.replaceAll("\\è", "e");
		     inputLine=inputLine.replaceAll("\\ù", "u");
		     inputLine=inputLine.replaceAll("\\�", "a");
		     return inputLine.replaceAll("\\|", "\n");
		}
		return "fail";
	 }
	
}


