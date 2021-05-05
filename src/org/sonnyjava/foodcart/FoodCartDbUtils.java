package org.sonnyjava.foodcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FoodCartDbUtils {
	
	public  static List<Food> getFoodListAndConnection() throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?"
		+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String userName = "hbstudent";
		String password = "hbstudent";
		
		ArrayList<Food> foodList = new ArrayList<>();

		// Step 1: Load the mysql Driver:
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Get the Connection:
		Connection con = DriverManager.getConnection(url, userName, password);

		// Step 3: Create a Statement:
		Statement stmt = con.createStatement();

		// Step 4: Execute the Statement and Loop over the ResultSet:
		ResultSet rs = stmt.executeQuery("Select * from hb_student_tracker.food");

		while (rs.next()) {

			int id = rs.getInt(1);
			String item = rs.getString(2);
			float price = rs.getFloat(3);

			Food myFood = new Food(id, item, price);
			foodList.add(myFood);

		}

		return foodList;
	}

}
