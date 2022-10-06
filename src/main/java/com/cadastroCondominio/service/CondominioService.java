package com.cadastroCondominio.service;

import com.cadastroCondominio.exeption.CondominioNaoEncontradoException;
import com.cadastroCondominio.model.Condominio;
import com.cadastroCondominio.repository.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondominioService {
    @Autowired

    private CondominioRepository repository;

    public void salvar(Condominio morador) {
        repository.save(morador);
    }

    public List<Condominio> findAll() {
        return repository.findAll();
    }

    public Condominio findById(Long id) {
        return repository.findById(id).get();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void atualizar(Long id, Condominio morador) {
        Optional<Condominio> res = repository.findById(id);
        if (res.isPresent()) {
            Condominio moradorDb = res.get();
            moradorDb.setMorador(morador.getMorador());
            moradorDb.setApartamento(morador.getApartamento());
            moradorDb.setTorre(morador.getTorre());
            moradorDb.setAndar(morador.getAndar());

            repository.save(moradorDb);
        } else {
            throw new CondominioNaoEncontradoException();
        }
    }
}
