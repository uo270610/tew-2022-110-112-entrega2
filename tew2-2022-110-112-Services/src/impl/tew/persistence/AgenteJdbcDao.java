package impl.tew.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tew.model.Agente;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.AgenteDao;
import com.tew.persistence.exception.NotPersistedException;
import com.tew.persistence.exception.PersistenceException;

public class AgenteJdbcDao implements AgenteDao {

	@Override
	public List<Agente> getAgentes() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				PreparedStatement ps = null;
				ResultSet rs = null;
				Connection con = null;
				
				List<Agente> Agentes = new ArrayList<Agente>();

				try {
					// En una implemenntaciï¿½ï¿½n mï¿½ï¿½s sofisticada estas constantes habrï¿½ï¿½a 
					// que sacarlas a un sistema de configuraciï¿½ï¿½n: 
					// xml, properties, descriptores de despliege, etc 
					String SQL_DRV = "org.hsqldb.jdbcDriver";
					String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

					// Obtenemos la conexiï¿½ï¿½n a la base de datos.
					Class.forName(SQL_DRV);
					con = DriverManager.getConnection(SQL_URL, "sa", "");
					ps = con.prepareStatement("SELECT * FROM AGENTES");
					rs = ps.executeQuery();

					while (rs.next()) {
						Agente a = new Agente();
						a.setId(rs.getLong("ID"));
						a.setLogin(rs.getString("LOGIN"));
						a.setPasswd(rs.getString("PASSWD"));

						Agentes.add(a);
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
				
				return Agentes;
	}

	/*@Override
	public void save(Agente a) throws AlreadyPersistedException {
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
			ps = con.prepareStatement(
					"insert into PUBLIC.AGENTES (login, passwd) " +
					"values ( ?, ?)");
			
			ps.setString(1, a.getLogin());
			ps.setString(2, a.getPasswd());
			
			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new AlreadyPersistedException("Agente " + a + " already persisted");
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
	}*/

	/*@Override
	public void update(Agente a) throws NotPersistedException {
		// TODO Auto-generated method stub
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
					ps = con.prepareStatement(
							"update AGENTES set " +
							" login = ?, passwd = ? where agentes.id=?");
					
					
					ps.setString(1, a.getLogin());
					ps.setString(2, a.getPasswd());
					ps.setLong(3, a.getId());

					rows = ps.executeUpdate();
					if (rows != 1) {
						throw new NotPersistedException("Agente " + a + " not found");
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
	}*/

	/*@Override
	public void delete(Long id) throws NotPersistedException {
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
			ps = con.prepareStatement("delete from Agentes where id = ?");
			
			ps.setLong(1, id);

			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new NotPersistedException("Cliente " + id + " not found");
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
	}*/

	@Override
	public Agente findById(Long id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		Agente agente = null;
		
		try {
			// En una implementaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("select * from AGENTES where id = ?");
			ps.setLong(1, id);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				agente = new Agente();
				agente.setId(rs.getLong("ID"));
				agente.setLogin(rs.getString("LOGIN"));
				agente.setPasswd(rs.getString("PASSWD"));
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
		
		return agente;
	}

	@Override
	public void resetDB() throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement tablaAgentes = null; PreparedStatement tablaClientes = null; 
		PreparedStatement tablaPisosParaVisitar = null; PreparedStatement tablaPisos = null;
		Connection con = null;
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			tablaAgentes = con.prepareStatement("delete from Agentes");
			tablaClientes = con.prepareStatement("delete from Clientes");
			tablaPisosParaVisitar = con.prepareStatement("delete from pisos_para_visitar");
			tablaPisos = con.prepareStatement("delete from pisos");
			
			tablaAgentes.executeUpdate();
			tablaClientes.executeUpdate();
			tablaPisosParaVisitar.executeUpdate();
			tablaPisos.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			if (tablaAgentes != null) {try{ tablaAgentes.close(); } catch (Exception ex){}};
			if (tablaClientes != null) {try{ tablaClientes.close(); } catch (Exception ex){}};
			if (tablaPisosParaVisitar != null) {try{ tablaPisosParaVisitar.close(); } catch (Exception ex){}};
			if (tablaPisos != null) {try{ tablaPisos.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
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
			ps = con.prepareStatement("SELECT * FROM PISOS_PARA_VISITAR INNER JOIN PISOS "
					+ "ON PISOS.ID=PISOS_PARA_VISITAR.ID_PISO WHERE PISOS.ID_AGENTE=? AND PISOS_PARA_VISITAR.ESTADO=1");
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
	public void citarVisita(long idp, long idc) throws NotPersistedException {
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
			ps.setInt(1, 2);
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