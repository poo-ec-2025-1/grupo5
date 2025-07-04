package model;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlantaTest {

    @Test
    public void testeConstrutorEGetters() {
        Planta planta = new Planta("Rosa", 15.5, "Flor", "Linda rosa vermelha");

        assertEquals("Rosa", planta.getNome());
        assertEquals(15.5, planta.getPreco(), 0.001);
        assertEquals("Flor", planta.getCategoria());
        assertEquals("Linda rosa vermelha", planta.getDescricao());
    }

    @Test
    public void testeSetters() {
        Planta planta = new Planta();
        
        planta.setNome("Margarida");
        planta.setPreco(12.0);
        planta.setCategoria("Flor");
        planta.setDescricao("Flor amarela");

        assertEquals("Margarida", planta.getNome());
        assertEquals(12.0, planta.getPreco(), 0.001);
        assertEquals("Flor", planta.getCategoria());
        assertEquals("Flor amarela", planta.getDescricao());
    }

    @Test
    public void testeToString() {
        Planta planta = new Planta("Orquídea", 20.0, "Flor", "Orquídea bonita");
        String esperado = "Orquídea - R$20.0";
        assertEquals(esperado, planta.toString());
    }
}
