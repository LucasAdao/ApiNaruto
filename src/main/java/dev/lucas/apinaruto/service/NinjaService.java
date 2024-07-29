package dev.lucas.apinaruto.service;

import dev.lucas.apinaruto.model.Ninja;
import dev.lucas.apinaruto.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    //TODO: Refatorar a instância
    @Autowired
    private NinjaRepository repository;

    //Criar um novo ninja
    public Ninja createNinja(Ninja ninja){
        return repository.save(ninja);
    }

    //Buscar todos os ninjas
    public List<Ninja> getAllNinjas(){
        return repository.findAll();
    }

    //buscar ninja por Id
    public Optional<Ninja> findNinjaById(Long id){
        return repository.findById(id);
    }

    //TODO: Fazer persistência de dados caso null
    public Ninja upadateNinja( Long id, Ninja ninja){
        Optional<Ninja> oldNinja = repository.findById(id);
        if(oldNinja.isPresent()){

            Ninja newNinja = oldNinja.get();

            if(ninja.getNome() != null) {
                newNinja.setNome(ninja.getNome());
            }

            if(ninja.getIdade() != 0) {
                newNinja.setIdade(ninja.getIdade());
            }
            if(ninja.getElemento() != null) {
                newNinja.setElemento(ninja.getElemento());
            }
            if(ninja.getAldeia() != null ) {
                newNinja.setAldeia(ninja.getAldeia());
            }
            if(ninja.getImgUrl() != null) {
                newNinja.setImgUrl(ninja.getImgUrl());
            }

            return  repository.save(newNinja);
        }
        else{
            throw new RuntimeException("Ninja com o Id:" + id + " não encontrado!");
        }
    }

    public void deleteNinja(Long id){
        repository.deleteById(id);
    }

}
