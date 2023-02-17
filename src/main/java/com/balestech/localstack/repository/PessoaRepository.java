package com.balestech.localstack.repository;


import com.balestech.localstack.domain.Pessoa;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface PessoaRepository extends CrudRepository<Pessoa, String> {

    @Override
    Optional<Pessoa> findById(String s);

    Optional<Pessoa> findByName(String name);
    void deleteByName(String name);

    void deleteById(String id);
}