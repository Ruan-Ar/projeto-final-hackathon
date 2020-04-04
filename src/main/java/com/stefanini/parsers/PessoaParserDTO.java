package com.stefanini.parsers;

import java.util.ArrayList;
import java.util.List;

import com.stefanini.dto.PessoaDto;
import com.stefanini.model.Pessoa;

public class PessoaParserDTO extends AbstractParser<PessoaDto, Pessoa> {

	@Override
	public PessoaDto toDTO(Pessoa entity) {
		PessoaDto dto = new PessoaDto();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setEmail(entity.getEmail());
		dto.setDataNascimento(entity.getDataNascimento());
		dto.setSituacao(entity.getSituacao());
		return dto;
	}

	@Override
	public Pessoa toEntity(PessoaDto dto) {
		Pessoa entity = new Pessoa();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setDataNascimento(dto.getDataNascimento());
		entity.setEmail(dto.getEmail());
		entity.setSituacao(dto.getSituacao());
		return entity;
	}
	
	public List<Pessoa> toEntityList(List<PessoaDto> dtos) {
		List<Pessoa> entities = new ArrayList<>();

		for (PessoaDto dto : dtos) {
			entities.add(toEntity(dto));
		}

		return entities;
	}
	
	public List<PessoaDto> toDtoList(List<Pessoa> pessoas) {
		List<PessoaDto> dtos = new ArrayList<>();

		for (Pessoa pessoa : pessoas) {
			dtos.add(toDTO(pessoa));
		}

		return dtos;
	}

}