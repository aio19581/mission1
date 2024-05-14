package db;

public class myLocation {
	//거리구하기
	public  double distance(double lat1, double lon1, double lat2, double lon2){
        Double theta = lon1 - lon2;
        Double dist = Math.sin(deg2rad(lat1))* Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1))*Math.cos(deg2rad(lat2))*Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60*1.1515*1609.344;
        dist = dist/1000;

        return dist; 
    }

    // 10진수를 radian(라디안)으로 변환
    private double deg2rad(Double deg){
        return (deg * Math.PI/180.0);
    }
    //radian(라디안)을 10진수로 변환
    private double rad2deg(Double rad){
        return (rad * 180 / Math.PI);
    }
    
    
    
    
}
