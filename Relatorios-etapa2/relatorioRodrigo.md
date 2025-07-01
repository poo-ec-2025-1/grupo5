## Relatório Individual – Projeto Java (Marketplace de Plantas)

**Autor**: Rodrigo Frota  
**Repositório**: [https://github.com/poo-ec-2025-1/grupo5.git]  
**Data**: 30/06/2025

---

### 🛠️ 1. Domínio do Ambiente e Ferramentas

Durante o desenvolvimento do projeto, foi possível consolidar o uso de diversas ferramentas importantes para o ciclo de vida de software:

- **Git e GitHub**: controle de versão, commits com mensagens descritivas, branches e merge. Também usamos `issues` e `projetos` para organizar o trabalho.
- **BlueJ**: utilizado como ambiente principal para a estruturação, execução e testes do código Java com interface gráfica (JavaFX).
- **Scene Builder**: ferramenta utilizada para montar a interface gráfica (.fxml) conectada ao JavaFX.

---

### 2. Domínio da Linguagem Java

As funcionalidades do projeto foram implementadas utilizando conceitos importantes da linguagem Java:

- Criação de **classes**, **métodos**, **construtores** e **encapsulamento**.
- Utilização de **eventos JavaFX** (por exemplo, com `@FXML` e `onAction`).
- Implementação de um modelo de **CRUD completo** com integração com banco de dados via ORMLite.
- Separação de responsabilidades com o padrão **MVC (Model-View-Controller)**.
- **Cadastro de Plantas:** Tela completa de cadastro, leitura, atualização e deleção de plantas (CRUD).
- **Tela de Login:** Tela inicial do sistema com autenticação básica.
**Exemplos de classes implementadas:**

- `Planta` (modelo da entidade)
- `PlantaRepositorio` (acesso ao banco de dados)
- `PlantaController` (lógica de controle da interface)
- `PlantaView` (adaptador para exibição em TableView)

---

### 3. Domínio da Modelagem

O projeto foi guiado por uma modelagem prévia que incluiu os seguintes diagramas UML:

- **Diagrama de Classes**: representação das principais entidades e seus relacionamentos (`Planta`, `PlantaRepositorio`, `Database`, `PlantaView`, etc).
- **Diagrama de Casos de Uso**: representando as interações do usuário com o sistema, como “Cadastrar Planta”, “Atualizar Planta”, “Remover Planta”.
- **Diagrama de Sequência**: ilustrando o fluxo entre a interface (`PlantaController`), o modelo (`Planta`) e o repositório.
---

### 📄 4. Domínio da Documentação

A documentação do projeto foi feita com arquivos Markdown para facilitar a leitura e colaboração. Exemplos:

- `README.md`: explicação geral do projeto, como executar, estrutura de pastas e principais funcionalidades.
- `relatorioRodrigo.md`: este relatório.
- Documentação de código com comentários e nomes de métodos representativos.

