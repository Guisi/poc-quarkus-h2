package com.rumolog.poc.quarkush2.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.rumolog.poc.quarkush2.model.Tabela;

@ApplicationScoped
public class TabelaService {
	
	@Inject
	private EntityManager em;

	@ConfigProperty(name = "minhapropriedade")
	private String propriedade;

	@Transactional
	public Tabela createTabela(Tabela tabela) {
		em.persist(tabela);
		return tabela;
	}
	
	@Transactional
	public List<Tabela> listTabelas() {
		/*CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tabela> query = cb.createQuery(Tabela.class);
		TypedQuery<Tabela> typedQuery = em.createQuery(query);*/
		
		System.out.println(propriedade);
		
		TypedQuery<Tabela> query = em.createQuery("SELECT t FROM Tabela t", Tabela.class);
		
		return query.getResultList();
	}
}