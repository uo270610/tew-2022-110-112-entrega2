package impl.tew.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tew.model.PisoParaVisitar;
import com.tew.persistence.PisoParaVisitarDao;
import com.tew.persistence.exception.NotPersistedException;
import com.tew.persistence.exception.PersistenceException;

public class PisoParaVisitarJdbcDao implements PisoParaVisitarDao{

	@Override
	public List<PisoParaVisitar> getPisosParaVisitar() {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		
		List<PisoParaVisitar> pisos_para_visitar = new ArrayList<PisoParaVisitar>();

		try {
			// En una implemenntaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT * FROM PISOS_PARA_VISITAR");
			rs = ps.executeQuery();

			//System.out.println(pisos_para_visitar.size());
			PisoParaVisitar piso = new PisoParaVisitar();
			while (rs.next()) {

				piso.setidPiso(rs.getLong(("ID_PISO")));
				piso.setidCliente(rs.getLong("ID_CLIENTE"));
				piso.setFechaHoraCita(rs.getLong("FECHA_HORA_CITA"));
				piso.setEstado(rs.getInt("ESTADO"));
				pisos_para_visitar.add(piso);
				
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
		
		return pisos_para_visitar;
	}

	@Override
	public void delete(Long idp, Long idc) throws NotPersistedException {
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
			ps = con.prepareStatement("DELETE FROM PISOS_PARA_VISITAR WHERE ID_PISO = ? and ID_CLIENTE=?");
			
			ps.setLong(1, idp);
			ps.setLong(2, idc);

			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new NotPersistedException("Piso " + idp + idc + " not found");
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
	
}
