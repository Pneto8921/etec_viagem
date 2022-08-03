package br.com.etechoracio.etec_viagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.etec_viagem.entity.Viagem;



public interface ViagemRepository extends JpaRepository<Viagem, Long> {

	
}
