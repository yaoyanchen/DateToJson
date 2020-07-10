package com.mytest.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Yaoyao {

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "123456";
		String url = "jdbc:mysql://localhost:3306/mytest";	//依次为连接方式  地址  最后为数据库
		try
		{
			Class.forName(driver);
			Connection con  = (Connection) DriverManager.getConnection(url, user, password);
			Statement statment = (Statement) con.createStatement(); 
			String sqlString = "select * from test";
			ResultSet rs = statment.executeQuery(sqlString);
			
			List<Map<String,String>> list = new ArrayList<Map<String,String>>();
            while(rs.next()) 
            {
                Map<String,String> map = new HashMap<String,String>();
                map.put("mLP_Name",rs.getString(2));
                map.put("mLP_Date",rs.getString(3));
                map.put("mLP_LostPlace",rs.getString(4));
                list.add(map);
            }
            Gson gson = new Gson();
            String jsonstr = null;
            jsonstr = gson.toJson(list);
            System.out.println(jsonstr);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

