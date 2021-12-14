package impl.tew.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tew.model.Cliente;
import com.tew.model.Piso;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.ClienteDao;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;
import com.tew.persistence.exception.PersistenceException;

public class ClienteJdbcDao implements ClienteDao {

	@Override
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		
		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			// En una implemenntaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT * FROM CLIENTES");
			rs = ps.executeQuery();
			Cliente cliente = new Cliente();
			while (rs.next()) {
				cliente.setId(rs.getLong("ID"));
				cliente.setLogin(rs.getString("LOGIN"));
				cliente.setPasswd(rs.getString("PASSWD"));
				cliente.setNombre(rs.getString("NOMBRE"));
				cliente.setApellidos(rs.getString("APELLIDOS"));
				cliente.setEmail(rs.getString("EMAIL"));
				
				clientes.add(cliente);
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
		
		return clientes;
	}

	@Override
	public void save(Cliente c) throws AlreadyPersistedException {
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
			ps = con.prepareStatement("INSERT INTO CLIENTES(LOGIN, PASSWD, NOMBRE, APELLIDOS, EMAIL) VALUES (?, ?, ?, ?, ?)");
			
			ps.setString(1, c.getLogin());
			ps.setString(2, c.getPasswd());
			ps.setString(3, c.getNombre());
			ps.setString(4, c.getApellidos());
			ps.setString(5, c.getEmail());
			
			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new AlreadyPersistedException("Cliente " + c + " already persisted");
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
	public void update(Cliente c) throws NotPersistedException {
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
			ps = con.prepareStatement("UPDATE CLIENTES LOGIN=?, PASSWD=?, NOMBRE=?, APELLIDOS=?, EMAIL=? "
					+ "WHERE CLIENTES.ID=?");
			
			ps.setString(1, c.getLogin());
			ps.setString(2, c.getPasswd());
			ps.setString(3, c.getNombre());
			ps.setString(4, c.getApellidos());
			ps.setString(5, c.getEmail());
			ps.setLong(6, c.getId());

			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new NotPersistedException("Cliente " + c + " not found");
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
	public void delete(Long id) throws NotPersistedException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection con = null;
		int rows = 0;
		
		PreparedStatement psaux=null;
		
		try {
			// En una implementaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("DELETE FROM CLIENTES WHERE CLIENTES.ID=?");
			
			ps.setLong(1, id);

			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new NotPersistedException("Cliente " + id + " not found");
			} 
			ps.close();
			ps = con.prepareStatement("DELETE FROM PISOS_PARA_VISITAR WHERE ID_CLIENTE=?");
			ps.setLong(1, id);
			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new NotPersistedException("El cliente " + id + " not tenia pisos para visitar");
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
			if (psaux != null) {try{ psaux.close(); } catch (Exception ex){}};
		}
	}



	@Override
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		Cliente cliente = null;
		
		try {
			// En una implementaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT * FROM CLIENTES WHERE CLIENTES.ID=?");
			ps.setLong(1, id);
			
			rs = ps.executeQuery();
			
			cliente = new Cliente();
			if (rs.next()) {				
				cliente.setId(rs.getLong("ID"));
				cliente.setLogin(rs.getString("LOGIN"));
				cliente.setNombre(rs.getString("NOMBRE"));
				cliente.setApellidos(rs.getString("APELLIDOS"));
				cliente.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			if (rs != null) {try{ rs.close(); } catch (Exception ex){}};
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
		return cliente;
	}

	@Override
	public List<Piso> consultaPisosPorCiudad(String ciudad) {
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
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT * FROM PISOS WHERE UPPER(?)=CIUDAD");
			ps.setString(1, ciudad);
			rs = ps.executeQuery();
			
			Piso piso = new Piso();
			while(rs.next()) {
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
	public List<Piso> consultaPisoPorPrecio(double min, double max) {
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
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT * FROM PISOS WHERE PRECIO>=? AND PRECIO<=?");
			ps.setDouble(1, min);
			ps.setDouble(2, max);
			rs = ps.executeQuery();
			
			Piso piso = new Piso();
			while(rs.next()) {
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
	public List<PisoParaVisitar> consultaPisoVisitar(long id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		
		List<PisoParaVisitar> pisosParaVisitar = new ArrayList<PisoParaVisitar>();
		
		try {
			// En una implemenntaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT * FROM PISOS_PARA_VISITAR WHERE ID_CLIENTE=? AND ESTADO=2");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			PisoParaVisitar pisoParaVisitar = new PisoParaVisitar();
			while(rs.next()) {
				pisoParaVisitar.setidPiso(rs.getLong(("ID_PISO")));
				pisoParaVisitar.setidCliente(rs.getLong("ID_CLIENTE"));
				pisoParaVisitar.setFechaHoraCita(rs.getLong("FECHA_HORA_CITA"));
				pisoParaVisitar.setEstado(rs.getInt("ESTADO"));
				pisosParaVisitar.add(pisoParaVisitar);
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
		
		return pisosParaVisitar;
	}

	@Override
	public void solicitarVisita(long idp, long idc) throws NotPersistedException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		int rows = 0;
		Connection con = null;
		
		try {
			// En una implemenntaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("INSERT INTO PISOS_PARA_VISITAR (id_piso, id_cliente, fecha_hora_cita, estado) "
					+ "VALUES(?,?,?,?)");
			ps.setLong(1, idp);
			ps.setLong(2, idc);
			//ps.setString(3, idk);
			ps.setInt(4, 1);			
			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new NotPersistedException("Cliente " + idc + " o piso " + idp + " not found");
			} 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
	}

	@Override
	public void confirmarVisita(long idp, long idc) throws NotPersistedException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		int rows = 0;
		Connection con = null;
		
		try {
			// En una implemenntaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("UPDATE PISOS_PARA_VISITAR SET ESTADO=? WHERE ID_PISO=? AND ID_CLIENTE=?");
			ps.setInt(1, 3);
			ps.setLong(2, idp);
			ps.setLong(3, idc);
			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new NotPersistedException("Cliente " + idc + " o piso " + idp + " not found");
			} 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
	}
	
}
