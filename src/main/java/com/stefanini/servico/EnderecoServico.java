package com.stefanini.servico;

import com.stefanini.dao.EnderecoDao;
import com.stefanini.dto.EnderecoDto;
import com.stefanini.model.Endereco;
import com.stefanini.parsers.EnderecoParserDto;

import javax.ejb.*;
import javax.inject.Inject;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * 
 * Classe de servico, as regras de negocio devem estar nessa classe
 * @author joaopedromilhome
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class EnderecoServico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private CepServico cep;
	
	@Inject
	private EnderecoParserDto parser;
	
	@Inject
	private EnderecoDao dao;


	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)

	public Endereco salvar(@Valid Endereco entity) {
		//return dao.salvar(entity);
		return dao.salvar(cep.converterCep(entity));
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)

	public Endereco atualizar(@Valid Endereco entity) {
		return dao.atualizar(entity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)

	public void remover(Long id) {
	dao.remover(id);
	}


	public Optional<List<Endereco>> getList() {
		return dao.getList();
	}

	public Optional<Endereco> encontrar(Long id) {
		return dao.encontrar(id);
	}
	
	public String encontrarPorCep(@Valid Endereco endereco) {
		return cep.buscarCep(endereco);
	}
	
	public Optional<List<Endereco>> getListParametros(@Valid EnderecoDto endereco) {
		List<EnderecoDto> enderecos = parser.toDtoList(dao.getListParametros(endereco).get());
		return Optional.of(parser.toEntityList(enderecos));
	}
	
	
}
