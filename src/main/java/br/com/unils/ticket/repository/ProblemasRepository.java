package br.com.unils.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unils.ticket.model.ProblemasModel;

@Repository
public interface ProblemasRepository extends JpaRepository<ProblemasModel, Long> {

}
