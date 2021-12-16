package com.tew.business.resteasy;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.tew.business.PisoService;
import com.tew.model.Piso;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;

@Path("/PisosServicesRs")
public interface PisosServicesRs extends PisoService{

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Piso> getPisos() throws Exception;

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	Piso findById(@PathParam("id") Long id) throws NotPersistedException;

	@POST
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	void deletePiso(@PathParam("id") Long id) throws NotPersistedException;

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	void savePiso(Piso piso) throws AlreadyPersistedException;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	void updatePiso(Piso piso) throws NotPersistedException;

}
