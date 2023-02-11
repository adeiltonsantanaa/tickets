package br.com.unils.ticket.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.unils.ticket.model.TicketModel;

@Repository
public interface TicketRepository extends JpaRepository<TicketModel, Long> {

	@Modifying
	@Transactional
	@Query("UPDATE TicketModel t SET t.ativo = 'false' WHERE t.codTicket=:cod")
	void disableTicket(@Param(value = "cod") Long cod);

	@Query("SELECT t FROM TicketModel t WHERE t.ativo = true")
	List<TicketModel> findTicketsActives();

	@Query("SELECT t FROM TicketModel t WHERE t.ativo = true AND t.funcionarios.codFuncionario=:codFunc")
	List<TicketModel> findTicketsActivesRoleFunc(@Param(value = "codFunc") Long codFunc);

}
