package fp.itmd523.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource implements AutoCloseable {

	protected Connection connection;
    private String url = "jdbc:mysql://www.papademas.net/510labs";
    private String username = "db510";
    private String password = "510";
    
    public DataSource() {
    	try {
            connection = DriverManager.getConnection("jdbc:mysql://www.papademas.net/510labs?"+"user=db510&password=510");
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
    }
    
	@Override
	public void close() {
    	try {
            connection.close();
            connection = null;
        } catch(SQLException e) {
            System.out.println("Error closing connection: " + e);
        }
	}
}

