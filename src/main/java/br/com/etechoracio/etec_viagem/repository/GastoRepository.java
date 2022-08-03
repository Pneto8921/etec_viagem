package br.com.etechoracio.etec_viagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.etec_viagem.entity.Gasto;



public interface GastoRepository extends JpaRepository<Gasto, Long> {

	List<Gasto> findByViagemId(Long id);
	
}
