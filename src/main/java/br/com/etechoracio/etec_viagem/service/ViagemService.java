package br.com.etechoracio.etec_viagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etechoracio.etec_viagem.entity.Viagem;
import br.com.etechoracio.etec_viagem.repository.GastoRepository;
import br.com.etechoracio.etec_viagem.repository.ViagemRepository;

@Service
public class ViagemService {
	
	@Autowired
	private ViagemRepository viagemrepository;
	
	@Autowired
	private GastoRepository gastorepository;
	
	public List<Viagem> listarTodos() {
		return viagemrepository.findAll();
	} 
	
	public Optional<Viagem> buscarPorId(Long id){
		return viagemrepository.findById(id);
	}
	
	public Viagem inserir(Viagem obj) {
		return viagemrepository.save(obj);
	}
	
	public Optional<Viagem> atualizar(Long id, Viagem viagem){
		boolean existe = viagemrepository.existsById(id);
		if(!existe) {
			return Optional.empty();
		}
		
		return Optional.of(viagemrepository.save(viagem));
	}
	
/*	public boolean excluir(Long id) {
		boolean existe = viagemrepository.existsById(id);
		if(!existe){
			return false;
		}
		
	}*/
	
	
}
