package impl.tew.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tew.model.Piso;
import com.tew.persistence.PisoDao;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;
import com.tew.persistence.exception.PersistenceException;

public class PisoJdbcDao implements PisoDao{

	@Override
	public List<Piso> getPisos() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		
		List<Piso> pisos = new ArrayList<Piso>();

		try {
			// En una implemenntaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT * FROM PISOS");
			rs = ps.executeQuery();
			Piso piso = new Piso();
			while (rs.next()) {
				piso.setId(rs.getLong("ID"));
				piso.setIdAgente(rs.getLong("ID_AGENTE"));
				piso.setPrecio(rs.getDouble("PRECIO"));
				piso.setDireccion(rs.getString("DIRECCION"));
				piso.setCiudad(rs.getString("CIUDAD"));
				piso.setAno(rs.getInt("ANO"));
				piso.setEstado(rs.getInt("ESTADO"));
				
				pisos.add(piso);
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
		
		return pisos;
	}

	@Override
	public void save(Piso p) throws AlreadyPersistedException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection con = null;
		int rows = 0;
		
		try {
			// En una implementaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("INSERT INTO PISOS(ID_AGENTE, PRECIO, DIRECCION, CIUDAD, ANO, ESTADO) VALUES (?, ?, ?, ?, ?, ?)");
			
			ps.setLong(1, p.getIdAgente());
			ps.setDouble(2, p.getPrecio());
			ps.setString(3, p.getDireccion());
			ps.setString(4, p.getCiudad());
			ps.setInt(5, p.getAno());
			ps.setInt(6, p.getEstado());
			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new AlreadyPersistedException("Piso " + p + " already persisted");
			} 

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
	}

	@Override
	public void update(Piso p) throws NotPersistedException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection con = null;
		int rows = 0;
		
		try {
			// En una implementaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("UPDATE PISOS ID_AGENTE=?, PRECIO=?, DIRECCION=?, CIUDAD=?, ANO=?, ESTADO=?"
					+ "WHERE PISO.ID=?");
			
			ps.setLong(1, p.getIdAgente());
			ps.setDouble(2, p.getPrecio());
			ps.setString(3, p.getDireccion());
			ps.setString(4, p.getCiudad());
			ps.setInt(5, p.getAno());
			ps.setLong(6, p.getEstado());
			ps.setLong(7, p.getId());

			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new NotPersistedException("Piso " + p + " not found");
			} 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
	}

	@Override
	public void delete(Long idp) throws NotPersistedException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection con = null;
		int rows = 0;
		
		PreparedStatement psaux = null;
		ResultSet r = null;
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
			ps = con.prepareStatement("DELETE FROM PISOS WHERE ID=?");
			ps.setLong(1, idp);
			ps.executeUpdate();
			psaux = con.prepareStatement("SELECT * FROM PISOS_PARA_VISITAR WHERE ID_PISO=?");
			psaux.setLong(1, idp);
			r = psaux.executeQuery();
			

			if(r!=null) {
				psaux.close();
				psaux = con.prepareStatement("DELETE FROM PISOS_PARA_VISITAR WHERE ID=?");
				psaux.setLong(1, idp);
				psaux.executeUpdate();
			}
			else {
				System.out.print("No habia entrada en pisos_para_visitar");
			}
			
			ps.setLong(1, idp);
			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new NotPersistedException("Piso " + idp + " not found");
			} 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			if (r != null) {try{ r.close(); } catch (Exception ex){}};
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (psaux != null) {try{ psaux.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
	}

	@Override
	public Piso findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
