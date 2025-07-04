package view;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlantaViewTest {

    @Test
    public void testeGettersESetters() {
        Planta planta = new Planta(1, "Rosa", "Flor", 10.0, "Linda rosa vermelha");

        // Testar getters
        assertEquals(1, planta.getId());
        assertEquals("Rosa", planta.getNome());
        assertEquals("Flor", planta.getCategoria());
        assertEquals(10.0, planta.getPreco(), 0.001);
        assertEquals("Linda rosa vermelha", planta.getDescricao());

        // Testar setters
        planta.setId(2);
        planta.setNome("Tulipa");
        planta.setCategoria("Flor");
        planta.setPreco(12.5);
        planta.setDescricao("Tulipa amarela");

        assertEquals(2, planta.getId());
        assertEquals("Tulipa", planta.getNome());
        assertEquals("Flor", planta.getCategoria());
        assertEquals(12.5, planta.getPreco(), 0.001);
        assertEquals("Tulipa amarela", planta.getDescricao());
    }
}
