package com.rumolog.poc.quarkush2.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rumolog.poc.quarkush2.model.Tabela;
import com.rumolog.poc.quarkush2.service.TabelaService;

@Path("/tabela")
public class TestResource {
	
	@Inject
	private TabelaService tabelaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tabela> listTabelas() {
        return this.tabelaService.listTabelas();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tabela createTabela(Tabela tabela) {
        return this.tabelaService.createTabela(tabela);
    }
}