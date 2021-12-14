package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.model.ReturnVerify;
import com.tew.model.User;
import com.tew.persistence.LoginDao;
import com.tew.persistence.exception.NotPersistedException;

public class Login {

	public ReturnVerify verify(String name, String passwd) throws NotPersistedException {
		String contra="clave1";
		String nombrecito="agente1@micorreo.com";
		User usuario=new User(nombrecito, contra);
		ReturnVerify pepe = new ReturnVerify();
		pepe.setUsuario(usuario);
		pepe.setClase("AGENTE");
		LoginDao dao = Factories.persistence.createLoginDao();
		//ReturnVerify rv = dao.verify(name, passwd);
		ReturnVerify rv = pepe;
		if(rv==null) {
			throw new NotPersistedException("No se ha encontrado al usuario");
		}
		return rv;
	}
	
}
