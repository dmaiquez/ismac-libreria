package com.distribuida.model;

import com.distribuida.model.Cliente;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@Epic("Módulo Clientes")
@Feature("Validación de datos")
public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setup(){
        cliente = new Cliente(1,"1701234567","Juan","Taipe","Av. por ahi.","0987654321","jtaipe@correo.com");
    }

    @Test
    @Story("Validar cliente")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Debe crear Constructor y Getters con datos válidos")
    public void testClienteConstructorAndGetters(){
        assertAll("Validar datos del cliente",
                () -> assertEquals(1, cliente.getIdCliente()),
                () -> assertEquals("1701234567", cliente.getCedula()),
                () -> assertEquals("Juan", cliente.getNombre()),
                () -> assertEquals("Taipe", cliente.getApellido()),
                () -> assertEquals("Av. por ahi.", cliente.getDireccion()),
                () -> assertEquals("0987654321", cliente.getTelefono()),
                () -> assertEquals("jtaipe@correo.com", cliente.getCorreo())
                );
    }

    @Test
    @Story("Validar cliente")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Debe crear cliente con Setters y con datos válidos")
    public void testClienteSetters(){
        cliente.setIdCliente(2);
        cliente.setCedula("1701234568");
        cliente.setNombre("Juan3");
        cliente.setApellido("Taipe3");
        cliente.setDireccion("Av. por ahi. 3.");
        cliente.setTelefono("0987654323");
        cliente.setCorreo("jtaipe3@correo.com");

        assertAll("Validar datos del cliente con Setters",
                () -> assertEquals(2,cliente.getIdCliente()),
                () -> assertEquals("1701234568",cliente.getCedula()),
                () -> assertEquals("Juan3", cliente.getNombre()),
                () -> assertEquals("Taipe3", cliente.getApellido()),
                () -> assertEquals("Av. por ahi. 3.", cliente.getDireccion()),
                () -> assertEquals("0987654323", cliente.getTelefono()),
                () -> assertEquals("jtaipe3@correo.com", cliente.getCorreo())
                );
    }


    @Test
    @Story("Validar cliente")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Debe ejecutar el método toString con datos válidos")
    public void testClienteToString(){
         String str = cliente.toString();
        assertAll("Validad datos de cliente con toString",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("1701234567")),
                () -> assertTrue(str.contains("Juan")),
                () -> assertTrue(str.contains("Taipe")),
                () -> assertTrue(str.contains("Av. por ahi.")),
                () -> assertTrue(str.contains("0987654321")),
                () -> assertTrue(str.contains("jtaipe@correo.com"))
                );
    }
}
