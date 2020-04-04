package com.stefanini.parsers;
import java.util.ArrayList;
import java.util.List;

import com.stefanini.dto.EnderecoDto;
import com.stefanini.model.Endereco;

public class EnderecoParserDto extends AbstractParser<EnderecoDto, Endereco> {

	@Override
	public EnderecoDto toDTO(Endereco entity) {
		EnderecoDto dto = new EnderecoDto();
		dto.setId(entity.getId());
		dto.setCep(entity.getCep());
		dto.setUf(entity.getUf());
		dto.setLocalidade(entity.getLocalidade());
		dto.setBairro(entity.getBairro());
		dto.setComplemento(entity.getComplemento());
		dto.setLogradouro(entity.getLogradouro());
		dto.setIdPessoa(entity.getIdPessoa());
		return dto;
	}

	@Override
	public Endereco toEntity(EnderecoDto dto) {
		Endereco entity = new Endereco();
		entity.setId(dto.getId());
		entity.setCep(dto.getCep());
		entity.setUf(dto.getUf());
		entity.setLocalidade(dto.getLocalidade());
		entity.setBairro(dto.getBairro());
		entity.setComplemento(dto.getComplemento());
		entity.setLogradouro(dto.getLogradouro());
		entity.setIdPessoa(dto.getIdPessoa());
		return entity;
	}

	public List<Endereco> toEntityList(List<EnderecoDto> dtos) {
		List<Endereco> entities = new ArrayList<>();

		for (EnderecoDto dto : dtos) {
			entities.add(toEntity(dto));
		}

		return entities;
	}

	public List<EnderecoDto> toDtoList(List<Endereco> enderecos) {
		List<EnderecoDto> dtos = new ArrayList<>();

		for (Endereco endereco : enderecos) {
			dtos.add(toDTO(endereco));
		}

		return dtos;
	}
	

}
