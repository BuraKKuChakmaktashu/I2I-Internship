import java.sql.Connection;
import java.sql.SQLException;

public interface DB_operations {
	
	public Connection connection(String port,String username,String password) throws SQLException;

	public void createSubscribersTable(Connection conn) throws SQLException;

	public long insertSubscribersTime(Connection conn, String[] numbers, String[] packets) throws SQLException;
	
	public long getSubscribersTime(Connection conn) throws SQLException;
	
	public String truncateSubscribersTable(Connection conn);

	public String dropSubscribersTable(Connection conn) throws SQLException;

	public void closeConnection(Connection conn) throws SQLException;


}