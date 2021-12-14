package impl.tew.business.classes;

import java.util.ArrayList;
import java.util.List;

import com.tew.infrastructure.Factories;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.ClienteDao;

public class ClientesConsultaPisoVisitar {

	public List<PisoParaVisitar> consultaPisoVisitar(Long id) {
		ClienteDao dao = Factories.persistence.createClienteDao();
		List<PisoParaVisitar> pisos = new ArrayList<PisoParaVisitar>();
		try {
			pisos = dao.consultaPisoVisitar(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pisos;
	}
}
