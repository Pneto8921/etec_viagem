package br.com.etechoracio.etec_viagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.etechoracio.etec_viagem.entity.Gasto;
import br.com.etechoracio.etec_viagem.entity.Viagem;
import br.com.etechoracio.etec_viagem.repository.GastoRepository;
import br.com.etechoracio.etec_viagem.repository.ViagemRepository;

public class GastoService {
	
	@Autowired
	private GastoRepository gastorepository;
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	public List<Gasto> listarTodos() {
		return gastorepository.findAll();
	} 
	
	public Optional<Gasto> buscarPorId(Long id){
		return gastorepository.findById(id);
	}
	
	public Gasto inserir(Gasto obj) {
		Optional<Viagem> existe = viagemRepository.findById(obj.getViagem().getId());
		if (!existe.isPresent()) {
			throw new RuntimeException("Viagem não encontrada.");
		}
		//NÃO INSERIR UM GASTO SE A VIAGEM EXISTE POREM LA FOI FINALIZADO
		//NÃO INSERIR UM  GASTO SE A DATA DO GASTO E ANTERIOR A DATA DE vIAGEM
		return gastorepository.save(obj);
	}
	
	public Optional<Gasto> atualizar(Long id, Gasto gasto){
		boolean existe = gastorepository.existsById(id);
		if(!existe) {
			return Optional.empty();
		}
		
		return Optional.of(gastorepository.save(gasto));
	}
}
