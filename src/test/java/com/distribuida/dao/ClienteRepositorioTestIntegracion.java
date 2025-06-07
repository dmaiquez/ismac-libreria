package com.distribuida.dao;

import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(false)
public class ClienteRepositorioTestIntegracion {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void findAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        assertNotNull(clientes);
        assertTrue(clientes.size() >= 0);
        for (Cliente item: clientes){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Cliente> cliente = clienteRepository.findById(56);
        assertTrue(cliente.isPresent(), "El cliente con id = 56 , debería existir.");
        System.out.println(cliente.toString());
    }


    @Test
    public void save( ){
        //Cliente cliente = new Cliente();
        Cliente cliente = new Cliente(0,"1701234566","Juan6","Taipe6","Av. por ahi.", "0987654321","jtaipe@correo.com");
        Cliente clienteGuardado = clienteRepository.save(cliente);
        assertNotNull(clienteGuardado.getIdCliente(),"El cliente guardado debe tener un id.");
        assertEquals("1701234566",clienteGuardado.getCedula());
        assertEquals("Juan6",clienteGuardado.getNombre());

    }

    @Test
    //@Rollback(false)
    public void update(){
        Optional<Cliente> cliente = clienteRepository.findById(56);
        assertTrue(cliente.isPresent(),"El cliente con id=56 debe de existir para ser actualizado");


        cliente.orElse(null).setCedula("1701233334");
        cliente.orElse(null).setNombre("Juan4");
        cliente.orElse(null).setApellido("Taipe4");
        cliente.orElse(null).setDireccion("Av. 33");
        cliente.orElse(null).setTelefono("0987654333");
        cliente.orElse(null).setCorreo("jtaipe33@correo.com");

        Cliente clienteActualizado = clienteRepository.save(cliente.orElse(null));

        assertEquals("Juan4", clienteActualizado.getNombre());
        assertEquals("Taipe4", clienteActualizado.getApellido());

    }


    @Test
    //@Rollback(value = false)
    public void delete(){
        if(clienteRepository.existsById(55)){
            clienteRepository.deleteById(55);
        }

        assertFalse(clienteRepository.existsById(56), "El id=55 debería haberse eliminado");
    }


}
