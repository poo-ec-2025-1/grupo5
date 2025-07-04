# Explicação dos Testes do Projeto

Este documento descreve os testes realizados no projeto, incluindo testes de unidade e de integração, com o objetivo de garantir a confiabilidade das funcionalidades desenvolvidas.

---

## Testes de Unidade

Testes que verificam o funcionamento de classes individuais, sem dependências externas como banco de dados.

### 1. `SessaoCompraTest.java`
- Testa a lógica do carrinho de compras (`SessaoCompra`).
- Verifica:
  - Se o carrinho aceita uma lista de plantas.
  - Se o total de compra é calculado corretamente.
  - Se o carrinho pode ser limpo com segurança.

### 2. `PlantaTest.java`
- Testa a classe `model.Planta` utilizada com ORMLite.
- Verifica:
  - Funcionamento correto dos getters e setters de:
    - Nome
    - Preço
    - Categoria
    - Descrição

### 3. `PlantaViewTest.java`
- Testa a classe `view.Planta` que usa propriedades do JavaFX.
- Verifica:
  - Atribuição correta dos dados.
  - Funcionamento dos métodos `get` e `set` com:
    - `SimpleStringProperty`
    - `SimpleDoubleProperty`
    - `SimpleIntegerProperty`

---

##  Teste de Integração

Testa a comunicação da aplicação com o banco de dados SQLite através do repositório.

### 4. `PlantaRepositorioIntegrationTest.java`
- Testa a classe `PlantaRepositorio`, que interage com o banco `plantas.db`.
- Verifica as operações CRUD:
  - **Create:** inserção de uma nova planta.
  - **Read:** busca por ID e listagem geral.
  - **Update:** alteração dos dados da planta.
  - **Delete:** remoção da planta do banco.

> *Observação:* Os testes foram realizados em uma **cópia do projeto**, para evitar alterações acidentais nos dados reais.

---

##  Ferramentas Utilizadas

- **BlueJ** – Ambiente de desenvolvimento usado para programar e executar os testes.
- **JUnit 4** – Framework de testes compatível com o BlueJ.
- **SQLite + ORMLite** – Banco de dados e biblioteca ORM usada no projeto.

---

##  Organização dos Arquivos de Teste

Os testes estão organizados na pasta `testes/` do projeto, da seguinte forma:

grupo5/testes/
├── SessaoCompraTest.java
├── PlantaTest.java
├── PlantaRepositorioIntegrationTest.java
├── PlantaViewTest.java


---

##  Conclusão

Com esses testes, o projeto garante:

- Validação do comportamento das classes principais.
- Verificação da integração entre a aplicação e o banco de dados.
- Maior segurança, clareza e confiabilidade do sistema.

Estes testes ajudam na manutenção do código e facilitam futuras melhorias ou expansões do projeto.


