package com.alura.forumbhub.domain.resposta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RespostasRepository extends JpaRepository<Resposta, Long> {
    @Query("SELECT r from Resposta r where r.topico.id = :id")
    Page<Resposta> findByTopicoId(Long id, Pageable paginacao);
}
