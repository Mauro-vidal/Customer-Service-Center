package com.mauro.project.helpdesk.resources;

import com.mauro.project.helpdesk.dominio.Tecnico;
import com.mauro.project.helpdesk.dtos.TecnicoDTO;
import com.mauro.project.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {
    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){

        Tecnico obj = service.findyById(id);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

    @GetMapping // getMapping sem parâmetros, vai ser chamado o métod /tecnicos.
    public ResponseEntity<List<TecnicoDTO>> findAll(){
        List<Tecnico> list = service.findAll();
        List<TecnicoDTO> listDto = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }
}
