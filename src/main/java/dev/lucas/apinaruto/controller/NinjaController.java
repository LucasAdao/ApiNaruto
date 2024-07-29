package dev.lucas.apinaruto.controller;


import dev.lucas.apinaruto.model.Ninja;
import dev.lucas.apinaruto.service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ninja")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @Operation( tags = "CRUD", summary = "Adicionar um Ninja", description = "Adicione um novo Ninja!!")
    @PostMapping("/add")
    public ResponseEntity<Ninja> addNinja(@RequestBody Ninja ninja){
        Ninja newNinja = ninjaService.createNinja(ninja);
        return new ResponseEntity<>(newNinja, HttpStatus.CREATED);
    }

    @Operation(tags = "CRUD", summary ="Buscar Todos os Ninjas", description = "Veja todos os ninjas que foram Adicionados!")
    @GetMapping("/all")
    public ResponseEntity<List<Ninja>> getAllNinjas(){
        List<Ninja> allNinjas = ninjaService.getAllNinjas();
        return new ResponseEntity<>(allNinjas, HttpStatus.OK);
    }

    @Operation(tags = "CRUD" , summary = "Buscar um Ninja por ID", description = "Busque um Ninja salvo pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getNinjaById(@PathVariable Long id){
        Optional<Ninja> ninjaBuscadoPorId = ninjaService.findNinjaById(id);
        if (ninjaBuscadoPorId.isPresent()){
            return new ResponseEntity<>(ninjaBuscadoPorId.get(), HttpStatus.OK);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
        }
    }

    //TODO: Usar optional para tratar casos que um usuário insira um valor invalido
    @Operation(tags = "CRUD", summary = "Deletar um Ninja por ID", description = "Remova um ninja da aplicação")
    @DeleteMapping("/delete/{id}")
    public void deleteNinja(@PathVariable Long id){
        ninjaService.deleteNinja(id);
    }

    @Operation(tags = "CRUD", summary = "Atualizar Ninja por ID", description = "Pesquise um Ninja por ID e faça a remoção dele!")
    @PutMapping("/update/{id}")
    public ResponseEntity<Ninja> updateNinja(@PathVariable Long id, @RequestBody Ninja ninja){
        try{
            Ninja ninjaSougthForUpdate = ninjaService.upadateNinja(id, ninja);
            return new ResponseEntity<>(ninjaSougthForUpdate, HttpStatus.OK);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }
}
