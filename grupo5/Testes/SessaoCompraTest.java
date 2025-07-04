package model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class SessaoCompraTest {

    private SessaoCompra sessao;

    @Before
    public void setup() {
        sessao = SessaoCompra.getInstancia();
        sessao.limpar(); // limpa antes de cada teste para evitar interferência
    }

    @Test
    public void testeAdicionarCarrinhoECalculoTotal() {
        Planta p1 = new Planta("Rosa", 10.0, "Flor", "Linda");
        Planta p2 = new Planta("Tulipa", 15.0, "Flor", "Bonita");

        sessao.setCarrinho(Arrays.asList(p1, p2));

        assertEquals(2, sessao.getCarrinho().size());
        assertEquals(25.0, sessao.getTotal(), 0.001);
    }

    @Test
    public void testeLimparCarrinho() {
        Planta p1 = new Planta("Rosa", 10.0, "Flor", "Linda");
        sessao.setCarrinho(Arrays.asList(p1));

        sessao.limpar();

        assertTrue(sessao.getCarrinho().isEmpty());
        assertEquals(0.0, sessao.getTotal(), 0.001);
    }

    @Test
    public void testeSingleton() {
        SessaoCompra outraInstancia = SessaoCompra.getInstancia();
        assertSame(sessao, outraInstancia);
    }
}
