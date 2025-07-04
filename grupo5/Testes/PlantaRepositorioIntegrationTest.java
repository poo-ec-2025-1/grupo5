package model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class PlantaRepositorioIntegrationTest {

    private Database db;
    private PlantaRepositorio repo;

    @Before
    public void setup() throws SQLException {
        // Cria o banco usando o arquivo real (no seu projeto de cópia)
        db = new Database("plantas.db");  
        repo = new PlantaRepositorio(db);
    }

    @Test
    public void testCRUD() {
        // Criar planta
        Planta planta = new Planta("Rosa", 10.0, "Flor", "Rosa vermelha");
        repo.adicionar(planta);

        // Buscar por ID
        Planta buscada = repo.buscarPorId(planta.getId());
        assertNotNull(buscada);
        assertEquals("Rosa", buscada.getNome());

        // Atualizar
        buscada.setPreco(12.0);
        repo.atualizar(buscada);

        Planta atualizada = repo.buscarPorId(buscada.getId());
        assertEquals(12.0, atualizada.getPreco(), 0.001);

        // Listar todas
        List<Planta> todas = repo.listarTodas();
        assertTrue(todas.size() >= 1);

        // Deletar
        repo.deletar(atualizada);
        Planta deletada = repo.buscarPorId(atualizada.getId());
        assertNull(deletada);
    }
}
