package com.tew.business.resteasy;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.tew.business.PisoService;
import com.tew.model.Piso;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;

public interface PisosServicesRs extends PisoService{

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Piso> getPisos() throws Exception;

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	Piso findById(@PathParam("id") Long id) throws NotPersistedException;

	@DELETE
	@Path("{id}")
	void deletePiso(@PathParam("id") Long id) throws NotPersistedException;

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	void savePiso(Piso piso) throws AlreadyPersistedException;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	void updateAlumno(Piso piso) throws NotPersistedException;

}
