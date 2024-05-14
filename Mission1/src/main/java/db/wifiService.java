package db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import db.publicWifi;

public class wifiService {
    public List<wifi> list(){
    	List<wifi> wifiList = new ArrayList<>();
    	
        String url ="jdbc:mariadb://127.0.0.1:3070/test";
        String dbUserId = "testuser";
        String dbPassword ="1234";

        //1.드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        //2.커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            statement = connection.createStatement();
            String sql = "select * from wifiList LIMIT 20 ;";
            
            //4.쿼리 실행
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String MGR_NO = rs.getString("MGR_NO");
                String WRDOFC = rs.getString("WRDOFC");
                String MAIN_NM = rs.getString("MAIN_NM");
                String ADRES1 = rs.getString("ADRES1");
                String ADRES2 = rs.getString("ADRES2");
                String FLOOR = rs.getString("FLOOR");
                String TY = rs.getString("TY");
                String MBY = rs.getString("MBY");
                String SE = rs.getString("SE");
                String CMCWR = rs.getString("CMCWR");
                int CNSTC_YEAR = rs.getInt("CNSTC_YEAR");
                String INOUT_DOOR = rs.getString("INOUT_DOOR");
                String REMARS3 = rs.getString("REMARS3");
                double LNT = rs.getDouble("LNT");
                double LAT = rs.getDouble("LAT");
                String WORK_DTTM = rs.getString("WORK_DTTM");
                
                wifi wf = new wifi();
                wf.setMGR_NO(MGR_NO);
                wf.setWRDOFC(WRDOFC);
                wf.setMAIN_NM(MAIN_NM);
                wf.setADRES1(ADRES1);
                wf.setADRES2(ADRES2);
                wf.setFLOOR(FLOOR);
                wf.setTY(TY);
                wf.setMBY(MBY);
                wf.setSE(SE);
                wf.setCMCWR(CMCWR);
                wf.setCNSTC_YEAR(CNSTC_YEAR);
                wf.setINOUT_DOOR(INOUT_DOOR);
                wf.setREMARS3(REMARS3);
                wf.setLAT(LAT);
                wf.setLNT(LNT);
                wf.setWORK_DTTM(WORK_DTTM);
                
                wifiList.add(wf);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //객체 닫기
            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(statement != null && !statement.isClosed()){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return wifiList;
    }
    
    public void wifiInsert() throws ParseException {
    	String url ="jdbc:mariadb://127.0.0.1:3070/test";
        String dbUserId = "testuser";
        String dbPassword ="1234";
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        try {
            
            int start=0;
            int end = 0;
            int total = 0; 
            
            int totalCnt = publicWifi.TotalCnt();
            int pageEnd = totalCnt/1000;
            int pageEndRemain = totalCnt%1000;
            
            for (int i=0; i<=pageEnd; i++) {
            	start = (int)Math.pow(10, 3)*i+1;
            	if(i==pageEnd) {
            		end=start+pageEndRemain -1;
            	} 
            	else {
            		end = (int)Math.pow(10, 3)*(i+1);
            	}
            	
            	String baseUrl = "http://openapi.seoul.go.kr:8088/62525a664d61696f353457754f6252/json/TbPublicWifiInfo/";
            	baseUrl = baseUrl + start + "/" + end + "/";
            	
            	URL url2 = null;
            	HttpURLConnection con = null;
            	JSONObject result = null;
            	StringBuilder sb = new StringBuilder();
            	
            	try {
            		url2 = new URL(baseUrl);
        			con = (HttpURLConnection)url2.openConnection();
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
        		
        		JSONObject data = (JSONObject)result.get("TbPublicWifiInfo");
        		JSONArray array = (JSONArray) data.get("row");
        		
        		JSONObject tmp;
        		
        		for (int j =0; j< array.size(); j++) {
        			tmp = (JSONObject)array.get(j);
        			connection = DriverManager.getConnection(url, dbUserId, dbPassword);
        			String sql = "insert into wifilist "
                    		+ "(MGR_NO, WRDOFC, MAIN_NM, ADRES1, ADRES2, FLOOR, TY, MBY, SE, CMCWR, CNSTC_YEAR, INOUT_DOOR, REMARS3, LNT, LAT, WORK_DTTM) "
                    		+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, (String)tmp.get("X_SWIFI_MGR_NO"));
                    preparedStatement.setString(2, (String)tmp.get("X_SWIFI_WRDOFC"));
                    preparedStatement.setString(3, (String)tmp.get("X_SWIFI_MAIN_NM"));
                    preparedStatement.setString(4, (String)tmp.get("X_SWIFI_ADRES1"));
                    preparedStatement.setString(5, (String)tmp.get("X_SWIFI_ADRES2"));
                    preparedStatement.setString(6, (String)tmp.get("X_SWIFI_INSTL_FLOOR"));
                    preparedStatement.setString(7, (String)tmp.get("X_SWIFI_INSTL_TY"));
                    preparedStatement.setString(8, (String)tmp.get("X_SWIFI_INSTL_MBY"));
                    preparedStatement.setString(9, (String)tmp.get("X_SWIFI_SVC_SE"));
                    preparedStatement.setString(10, (String)tmp.get("X_SWIFI_CMCWR"));
                    String strYear = (String)tmp.get("X_SWIFI_CNSTC_YEAR");
                    int cnstcYear = Integer.valueOf(strYear);
                    preparedStatement.setInt(11, cnstcYear);
                    preparedStatement.setString(12, (String)tmp.get("X_SWIFI_INOUT_DOOR"));
                    preparedStatement.setString(13, (String)tmp.get("X_SWIFI_REMARS3"));
                    String strLnt = (String)tmp.get("LNT");
                    double Lnt = Double.valueOf(strLnt);
                    preparedStatement.setDouble(14, Lnt);
                    String strLat = (String)tmp.get("LAT");
                    double Lat = Double.valueOf(strLat);
                    preparedStatement.setDouble(15, Lat);
                    preparedStatement.setString(16, (String)tmp.get("WORK_DTTM")); 
                    preparedStatement.addBatch();
                    preparedStatement.executeBatch();
            		preparedStatement.clearBatch();
        		}
        		
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
