import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {
	public static Connection conn = null;
	static String useThis;
	@SuppressWarnings("finally")
	public static Connection getConnection() {	
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/" + useThis,"sa","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		return conn;
		}
	}
		public static void LoadConfig(){
			ArrayList<String> server = null ;
			try {
				Path toFile = Paths.get("C:\\Users\\Acer Build\\Desktop\\praktikum2-master\\config.txt");//Smeni putq tuk i vuv faila config za da raboti
				//vnimavai za gornite zapetaiki i skobite zashtoto ti trqbvat tuk				
				//toi se namira v papkata na proekta i smeni vsichko mejdu = i ; no bez da promenqsh tqh //
				server =(ArrayList<String>) Files.readAllLines(toFile);
				useThis = server.get(0).replace("database=", "").replace(";", "");
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}