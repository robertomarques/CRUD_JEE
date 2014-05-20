package com.github.robertomarques.crudjee.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.github.robertomarques.crudjee.entity.Pessoa;

@LocalBean
@Stateless
public  class PessoaBean {

	@PersistenceContext
	private EntityManager em;
	
	

	public void incluir( Pessoa pessoa) {
		em.persist(pessoa);
		em.flush();
	}
	

	public void excluir(Pessoa pessoa) {		
		pessoa = em.getReference(Pessoa.class, pessoa.getId());
		em.remove(pessoa);
		em.flush();
	}
	
	
	public void alterar( Pessoa pessoa) {
	    Pessoa p = em.merge(pessoa);
	    em.flush();
	}
	
	public  java.util.List<Pessoa> listar() {
		TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p", Pessoa.class);
		return query.getResultList();		
	}
	
	
}
