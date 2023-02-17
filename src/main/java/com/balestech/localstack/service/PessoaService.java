package com.balestech.localstack.service;

import java.util.List;
import java.util.Optional;

import com.balestech.localstack.domain.Pessoa;
import com.balestech.localstack.dto.PessoaDTO;
import com.balestech.localstack.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa savePessoa(PessoaDTO pessoaDTO) {
        if(pessoaRepository.findByName(pessoaDTO.getName()).isPresent()) {
            throw new RuntimeException("There is already a person with this document number");
        }
        return pessoaRepository.save(new ObjectMapper().convertValue(pessoaDTO, Pessoa.class));
    }

    public List<Pessoa> findAllPerson() {
        return (List<Pessoa>) pessoaRepository.findAll();
    }

    public void deletePessoa(String id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if(pessoa.isEmpty()) {
            throw new RuntimeException("There is no person with this document number");
        }

        pessoaRepository.delete(pessoa.get());
    }
}