package com.mauro.project.helpdesk.services;

import com.mauro.project.helpdesk.dominio.Pessoa;
import com.mauro.project.helpdesk.dominio.Tecnico;
import com.mauro.project.helpdesk.dtos.TecnicoDTO;
import com.mauro.project.helpdesk.repositories.PessoaRepository;
import com.mauro.project.helpdesk.repositories.TecnicoRepository;
import com.mauro.project.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.mauro.project.helpdesk.services.exceptions.ObjectnotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Tecnico findyById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO objDto) {
        objDto.setId(null);
        objDto.setSenha(encoder.encode(objDto.getSenha()));
        objDto.setSenha((objDto.getSenha()));
        ValidaPorCpfEEmail(objDto);
        Tecnico newObj = new Tecnico(objDto);
        return repository.save(newObj);
    }

    public Tecnico update(Integer id, @Valid TecnicoDTO objDto) {
        objDto.setId(id);
        Tecnico oldObj = findyById(id);
        ValidaPorCpfEEmail(objDto);
        oldObj = new Tecnico(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id){
        Tecnico obj = findyById(id);

        if (obj.getChamados().size() > 0){
            throw new DataIntegrityViolationException("Técnico possui ordem de serviço e não pode ser deletado!");
        }
        repository.deleteById(id);
    }

    private void ValidaPorCpfEEmail(TecnicoDTO objDto){
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
