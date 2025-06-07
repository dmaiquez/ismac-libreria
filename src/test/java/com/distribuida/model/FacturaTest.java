package com.distribuida.model;

import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FacturaTest {

    private Factura factura;
    private Cliente cliente;

    @BeforeEach
    public void setUp(){

        cliente = new Cliente(1,"1701234567","Juan","Taipe","Av. por ahi.","0987654321","jtaipe@correo.com");
        factura = new Factura();

        factura.setIdFactura(1);
        factura.setNumFactura("FAC-0001");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);

        factura.setCliente(cliente);

    }

    @Test
    public void testFacturaConstructorAndGetters(){
        assertAll("validar datos de factura",
                () -> assertEquals(1,factura.getIdFactura()),
                () -> assertEquals("FAC-0001",factura.getNumFactura()),
                //() -> assertEquals(new Date(),factura.getFecha()),
                () -> assertEquals(100.00,factura.getTotalNeto()),
                () -> assertEquals(15.00,factura.getIva()),
                () -> assertEquals(115.00,factura.getTotal()),
                () -> assertEquals(115.00,factura.getTotal())
        );
    }

    @Test
    public void testFacturaSetters(){

        cliente = new Cliente(2,"1701234562","Juan2","Taipe2","Av. por ahi.2","0987654322","jtaipe2@correo.com");
        factura = new Factura();

        factura.setIdFactura(2);
        factura.setNumFactura("FAC-0002");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.02);
        factura.setIva(15.02);
        factura.setTotal(115.02);

        factura.setCliente(cliente);
        assertAll("Validar datos de factura",
                () -> assertEquals(2,factura.getIdFactura()),
                () -> assertEquals("FAC-0002",factura.getNumFactura()),
               // () -> assertEquals(new Date(),factura.getFecha()),
                () -> assertEquals(100.02,factura.getTotalNeto()),
                () -> assertEquals(15.02,factura.getIva()),
                () -> assertEquals(115.02,factura.getTotal())
        );
    }

    @Test
    public void testFacturaToString(){
        String str = factura.toString();
        assertAll("Validad datos factura",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("FAC-0001")),
                () -> assertTrue(str.contains("100.0")),
                () -> assertTrue(str.contains("15.0")),
                () -> assertTrue(str.contains("115.0")),
                () -> assertTrue(str.contains("Juan"))
        );
    }

    @Test
    public void testFacturaClienteInyeccion(){
        assertAll( "Validar datos factura",
                () -> assertNotNull(factura.getCliente()),
                () -> assertEquals("Juan", factura.getCliente().getNombre())
        );


    }

    @Test
    public void testValoresNegativosFactura(){
        factura.setTotalNeto(-100.00);
        assertAll("Validar datos factura",
                () -> assertEquals(-100.00,factura.getTotalNeto())
                );
        // agregar validaciones para evitar valores negativos
    }

}
