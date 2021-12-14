package impl.tew.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tew.model.ReturnVerify;
import com.tew.model.User;
import com.tew.persistence.LoginDao;
import com.tew.persistence.exception.PersistenceException;

public class LoginJdbcDao implements LoginDao{

	@Override
	public ReturnVerify verify(String email, String passwd) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		ReturnVerify rv;
		
		try {
			// En una implemenntaciï¿½ï¿½n mï¿½ï¿½s sofisticada estas constantes habrï¿½ï¿½a 
			// que sacarlas a un sistema de configuraciï¿½ï¿½n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexiï¿½ï¿½n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT * FROM AGENTES WHERE LOGIN='agente1@micorreo.com' AND PASSWD='clave1'");
			ps.setString(1, email);
			ps.setString(2, passwd);
			rs = ps.executeQuery();

			rv = new ReturnVerify();
			if(rs.next()) {
				User user = new User(rs.getString("LOGIN"), rs.getString("PASSWD"));
				rv.setUsuario(user);
				rv.setClase("AGENTE");
			}
			
			ps.close();
			rs.close();
			
			ps = con.prepareStatement("SELECT * FROM CLIENTES WHERE LOGIN=? AND PASSWD=?");
			ps.setString(1, email);
			ps.setString(2, passwd);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				User user2 = new User(rs.getString("LOGIN"), rs.getString("PASSWD"));
				rv.setUsuario(user2);
				rv.setClase("CLIENTE");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally  {
			if (rs != null) {try{ rs.close(); } catch (Exception ex){}};
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
		return rv;
	}
	
}
