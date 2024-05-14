package db;
import org.apache.jasper.tagplugins.jstl.core.Out;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.util.*;

public class publicWifi {
	static final String KEY = "";
	static int TOTALCNT;
	
	public static int TotalCnt() throws ParseException{
		URL url = null;
		HttpURLConnection con = null;
		JSONObject result = null;
		StringBuilder sb = new StringBuilder();
		int start = 1;
		int end = 1;
		String baseUrl = "http://openapi.seoul.go.kr:8088/62525a664d61696f353457754f6252/json/TbPublicWifiInfo/"+start+"/"+end+"/";
		
		try {
			url = new URL(baseUrl);
			con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-type", "application/json");
			con.setDoOutput(true);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			while(br.ready()) {
				sb.append(br.readLine());
			}
			con.disconnect();
		} catch(Exception e) {
			e.printStackTrace();
		}
		result = (JSONObject)new JSONParser().parse(sb.toString());
		StringBuilder out = new StringBuilder();
		
		JSONObject data = (JSONObject)result.get("TbPublicWifiInfo");
		int totalGet = Integer.parseInt(data.get("list_total_count").toString());
		
		return totalGet;
	}
}