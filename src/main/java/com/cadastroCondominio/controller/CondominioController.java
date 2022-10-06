package com.cadastroCondominio.controller;

import com.cadastroCondominio.model.Condominio;
import com.cadastroCondominio.service.CondominioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/v1/cad-condominio")
@CrossOrigin
public class CondominioController {
    @Autowired
    private CondominioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void salvar(@RequestBody Condominio morador ) {
        service.salvar(morador);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Condominio> finAll() {
        return service.findAll();
    }

    @GetMapping("/por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Condominio findById(@RequestParam("id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @PutMapping("/update-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@RequestParam("id") Long id, @RequestBody Condominio morador) {
        service.atualizar(id, morador);
    }
}
