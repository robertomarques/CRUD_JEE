package com.github.robertomarques.crudjee.services;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.github.robertomarques.crudjee.bean.PessoaBean;
import com.github.robertomarques.crudjee.entity.Pessoa;

@WebService(name="PessoaService")
@SOAPBinding(style=Style.DOCUMENT,use=Use.LITERAL)
public class PessoaService {

	@EJB
	private PessoaBean pessoaBean;
	
	@WebMethod
	public boolean incluir(@WebParam(name="nome") String nome) {
		pessoaBean.incluir(new Pessoa(null,nome));
		return true;
	}
	
	@WebMethod
	public boolean editar(@WebParam(name="pessoa") Pessoa pessoa) {
		pessoaBean.alterar(pessoa);
		return true;
	}
	
	@WebMethod
	public boolean excluir(@WebParam(name="id") Long id) {		
		pessoaBean.excluir(new Pessoa(id,null));
		return true;
	}
	
	@WebMethod
	public @WebResult(name="pessoa") List<Pessoa> listar() {		  
	  return pessoaBean.listar();
	}
	
	
}
