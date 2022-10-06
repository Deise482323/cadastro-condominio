package com.cadastroCondominio.repository;

import com.cadastroCondominio.model.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondominioRepository extends JpaRepository<Condominio,Long> {
}
