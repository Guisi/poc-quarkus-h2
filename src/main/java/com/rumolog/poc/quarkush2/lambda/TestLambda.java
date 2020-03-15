package com.rumolog.poc.quarkush2.lambda;

import java.util.List;

import javax.inject.Inject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rumolog.poc.quarkush2.model.Tabela;
import com.rumolog.poc.quarkush2.service.TabelaService;

public class TestLambda implements RequestHandler<String, Object> {
	
	@Inject
	private TabelaService tabelaService;
	
	@Override
	public Object handleRequest(String request, Context context) {
		
		context.getLogger().log("Recebeu request: " + request);
		
		context.getLogger().log("Iniciando consulta das tabelas");
		
		List<Tabela> tabelas = tabelaService.listTabelas();
		tabelas.forEach(tabela -> context.getLogger().log(tabela.toString()));
		
		context.getLogger().log("Concluiu consulta das tabelas");
		
		return null;
	}
}