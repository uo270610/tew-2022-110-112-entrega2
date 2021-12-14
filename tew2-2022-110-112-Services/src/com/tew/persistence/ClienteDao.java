package com.tew.persistence;

import java.util.List;

import com.tew.model.Cliente;
import com.tew.model.Piso;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;

public interface ClienteDao {

	List<Cliente> getClientes();
	void save(Cliente a) throws AlreadyPersistedException;
	void update(Cliente a) throws NotPersistedException;
	void delete(Long id) throws NotPersistedException;
	Cliente findById(Long id);
	List<Piso> consultaPisosPorCiudad(String ciudad);
	List<Piso> consultaPisoPorPrecio(double min, double max);
	List<PisoParaVisitar> consultaPisoVisitar(long idCliente);
	void solicitarVisita(long idPiso, long idCliente) throws NotPersistedException;
	void confirmarVisita(long idPiso, long idCliente) throws NotPersistedException;
	
}
