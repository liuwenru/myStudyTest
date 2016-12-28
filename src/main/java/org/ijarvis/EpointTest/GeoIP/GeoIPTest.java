package org.ijarvis.EpointTest.GeoIP;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.*;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ijarvis on 12/5/16.
 */
public class GeoIPTest {
    public  static  void  main(String[] args) throws IOException, GeoIp2Exception {
        //使用File对象打开数据库文件
        File database = new File("/home/ijarvis/Documents/workspace/EpointTest/src/main/resources/GeoLite2-City.mmdb");

        DatabaseReader reader = new DatabaseReader.Builder(database).build();

        InetAddress ipAddress = InetAddress.getByName("218.4.136.119");

        CityResponse response = reader.city(ipAddress);
        //获取国家信息
        Country country = response.getCountry();
        System.out.println(country.getNames().get("zh-CN")); // 获取国家名称
        System.out.println(country.getNames().get("en")); //

        //获取省份信息
        Subdivision subdivision = response.getMostSpecificSubdivision();
        System.out.println(subdivision.getNames().get("zh-CN"));    // 获取省份
        System.out.println(subdivision.getNames().get("en"));    //

        //获取城市信息
        City city = response.getCity();
        System.out.println(city.getNames().get("zh-CN")); //获取城市名称
        System.out.println(city.getNames().get("en"));

        //实现获取经纬度
        Location location = response.getLocation();
        System.out.println(location.getLatitude());  //纬度
        System.out.println(location.getLongitude()); //经度
        
        Map<String, Object> tMap=HashMap<String, Object>();
    }
}
