package com.stefanini.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.dto.EnderecoDto;
import com.stefanini.model.Endereco;

/**
 * O Unico objetivo da Dao 
 * @author joaopedromilhome
 *
 */
public class EnderecoDao extends GenericDao<Endereco, Long> {

	public EnderecoDao() {
		super(Endereco.class);
	}
	
	public Optional<List<Endereco>> getListParametros(EnderecoDto dto){

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Endereco> query = criteriaBuilder.createQuery(Endereco.class);
		Root<Endereco> root = query.from(Endereco.class); 

		Path<String> ufPath = root.<String>get("uf");
		Path<String> cepPath = root.<String>get("cep");
		Path<String> bairroPath = root.<String>get("bairro");
		Path<String> localidadePath = root.<String>get("localidade");
		Path<String> complementoPath = root.<String>get("complemento");
		Path<String> logradouroPath = root.<String>get("logradouro");


		List<Predicate> predicates = new ArrayList<>();



		if(dto.getUf() != null) {
		Predicate ufIgual = criteriaBuilder.equal(ufPath, dto.getUf());
		predicates.add(ufIgual);
		}
		if(dto.getCep() != null) {
		Predicate cepIgual = criteriaBuilder.equal(cepPath, dto.getCep());
		predicates.add(cepIgual);
		}
		if(dto.getBairro() != null){
		Predicate bairroIgual = criteriaBuilder.equal(bairroPath, dto.getBairro());
		predicates.add(bairroIgual);
		}
		if(dto.getLocalidade() != null) {
		Predicate localidadeIgual = criteriaBuilder.equal(localidadePath, dto.getCep());
		predicates.add(localidadeIgual);
		}
		if(dto.getComplemento() != null) {
		Predicate complementoIgual = criteriaBuilder.equal(complementoPath, dto.getComplemento());
		predicates.add(complementoIgual);
		}
		if(dto.getLogradouro() != null) {
		Predicate logradouroIgual = criteriaBuilder.equal(logradouroPath, dto.getLogradouro());
		predicates.add(logradouroIgual);
		}

	//	query.where(ufIgual);
		query.where((Predicate[]) predicates.toArray(new Predicate[0]));
		TypedQuery<Endereco> typedQuery = entityManager.createQuery(query);
		return Optional.of(typedQuery.getResultList());
	}

}
