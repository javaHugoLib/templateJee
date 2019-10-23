package com.template.app.rest.company;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.template.app.entity.CompanyEntity;
import com.template.app.exception.AppException;
import com.template.app.rest.service.company.CompanyService;

@Path("/company")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class CompanyRest {
	
	private final static Logger LOGGER = Logger.getLogger(CompanyRest.class.getName());
	
	@Inject
	private CompanyService companyService;

	@GET
	@Path("/all")
	public List<CompanyEntity> getAllCompanies() throws AppException{
		LOGGER.info("CompanyRest.getAllCompanies");
		List<CompanyEntity> listCompanies = companyService.GetAllCompanies();
				

		LOGGER.info("CompanyRest.getAllCompanies: "+listCompanies);
		return listCompanies;
	}
	
	@POST
	@Path("/create")
	public CompanyEntity create(CompanyEntity entity) throws AppException{
		return companyService.create(entity);
	}
	
	@DELETE
	@Path("/delete")
	public void delete(CompanyEntity entity) throws AppException{
		companyService.delete(entity);
	}
	
	
}
