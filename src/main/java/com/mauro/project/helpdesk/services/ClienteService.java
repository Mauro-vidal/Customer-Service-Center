package com.mauro.project.helpdesk.services;

import com.mauro.project.helpdesk.dominio.Cliente;
import com.mauro.project.helpdesk.dominio.Pessoa;
import com.mauro.project.helpdesk.dtos.ClienteDTO;
import com.mauro.project.helpdesk.repositories.ClienteRepository;
import com.mauro.project.helpdesk.repositories.PessoaRepository;
import com.mauro.project.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.mauro.project.helpdesk.services.exceptions.ObjectnotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findyById(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(ClienteDTO objDto) {
        objDto.setId(null);
        ValidaPorCpfEEmail(objDto);
        Cliente newObj = new Cliente(objDto);
        return repository.save(newObj);
    }

    public Cliente update(Integer id, @Valid ClienteDTO objDto) {
        objDto.setId(id);
        Cliente oldObj = findyById(id);
        ValidaPorCpfEEmail(objDto);
        oldObj = new Cliente(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id){
        Cliente obj = findyById(id);

        if (obj.getChamados().size() > 0){
            throw new DataIntegrityViolationException("Cliente possui ordem de serviço e não pode ser deletado!");
        }
        repository.deleteById(id);
    }

    private void ValidaPorCpfEEmail(ClienteDTO objDto){
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("Cpf já cadastrado no sistema!");
        }

        obj = pessoaRepository.findByEmail(objDto.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");

        }
    }


}
