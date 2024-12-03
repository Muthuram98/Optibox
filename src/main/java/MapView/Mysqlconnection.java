package MapView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysqlconnection {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "root";
		String password = "Test@123";

		String location = "AUASP";
		String Eqptype = "40HC";

		Connection connect = DriverManager.getConnection(url, user, password);

		String query = "SELECT Weeks FROM deficitsurplus WHERE Location = '" + location + "' AND EqpType = '" + Eqptype
				+ "'";
		PreparedStatement statement = connect.prepareStatement(query);

		// Execute the query
		ResultSet results = statement.executeQuery();

		// Process the results
		while (results.next()) {
			int week = results.getInt("Weeks");
			System.out.println("Weeks value: " + week);
		}

	}

}
