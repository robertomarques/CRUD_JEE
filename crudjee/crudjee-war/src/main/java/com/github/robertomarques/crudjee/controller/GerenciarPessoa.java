package com.github.robertomarques.crudjee.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.github.robertomarques.crudjee.bean.PessoaBean;
import com.github.robertomarques.crudjee.entity.Pessoa;

@ManagedBean(name="gerenciarPessoa")
@SessionScoped
public class GerenciarPessoa {

	@EJB
	private PessoaBean pessoaBean;
	
	private Pessoa pessoa = new Pessoa();
	
	public List<Pessoa> getPessoas() {
		return pessoaBean.listar();
	}
	
	public String incluir() {
		pessoa = new Pessoa();
		return "incluir";
	}
	
	public String excluir() {
		pessoaBean.excluir(pessoa);
		return "index?faces-redirect=true";
	}
	
	public String editar() {		
		return "editar";
	}
	
	public String confirmarEdicao() {
		pessoaBean.alterar(pessoa);
		return "index?faces-redirect=true";
	}
	
	public String confirmarInclusao() {
		pessoaBean.incluir(pessoa);
		return "index?faces-redirect=true";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	
	
	
}
