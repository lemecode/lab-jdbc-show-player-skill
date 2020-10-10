package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {

		Properties prop = loadPropertiesFile();

		final String driver = prop.getProperty("driver");
		final String url = prop.getProperty("url");
		final String user = prop.getProperty("username");
		final String pass = prop.getProperty("pass");

		// final String driver = "oracle.jdbc.OracleDriver";
		// final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// final String user = "playerskill";
		// final String pass = "playerskill";

		Class.forName(driver);

		Connection con = DriverManager.getConnection(url, user, pass);

		return con;
	}

	public static Properties loadPropertiesFile() throws IOException {

		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;

	}

}
