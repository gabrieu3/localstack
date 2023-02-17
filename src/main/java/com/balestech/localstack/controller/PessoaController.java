package com.balestech.localstack.controller;

import com.balestech.localstack.domain.Pessoa;
import com.balestech.localstack.dto.PessoaDTO;
import com.balestech.localstack.service.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/all")
    public List<Pessoa> getAll() {
        return pessoaService.findAllPerson();
    }

    @PostMapping("/save")
    public Pessoa saveName(@RequestBody PessoaDTO request) {
        return pessoaService.savePessoa(request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePeson(@PathVariable String id) {
        pessoaService.deletePessoa(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
