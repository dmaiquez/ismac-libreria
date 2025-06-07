package com.distribuida.service;

import com.distribuida.dao.ClienteRepository;
import com.distribuida.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findOne(int id){
        Optional<Cliente> cliente =  clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente update(int id, Cliente clienteNuevo){
        Cliente clienteExistente = findOne(id);

        if(clienteExistente == null  ){
            return null;
        }

        clienteExistente.setCedula(clienteNuevo.getCedula());
        clienteExistente.setNombre(clienteNuevo.getNombre());
        clienteExistente.setApellido(clienteNuevo.getApellido());
        clienteExistente.setDireccion(clienteNuevo.getDireccion());
        clienteExistente.setTelefono(clienteNuevo.getTelefono());
        clienteExistente.setCorreo(clienteNuevo.getCorreo());

        return clienteRepository.save(clienteExistente);

    }

    public void delete(int id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        }
    }


}
