# grupo5
# Projeto(Marketplace de Plantas)

---

## Membros e Funções

- **Eik Ericson de Oliveira Filho** – Líder do grupo e responsável por testes  
- **Millena Costa Pimentel** – Responsável pelo front-end e interface gráfica  
- **Letícia Barbosa** – Responsável pela documentação do projeto e organização das tarefas no GitHub  
- **Rodrigo Frota** – Responsável pelo back-end e modelagem UML  

---

## Introdução

Este projeto consiste no desenvolvimento de um **marketplace de plantas**, motivado pela experiência pessoal de um dos integrantes, que enfrentou dificuldades para obter orientações e insumos adequados para o cultivo de suas plantas – o que resultou na perda de várias delas.

A partir dessa vivência, surgiu a ideia de criar uma plataforma que conecte apaixonados por plantas a vendedores especializados, facilitando o acesso a produtos, informações e suporte necessário para o cuidado adequado. O objetivo é proporcionar uma solução acessível e eficiente, contribuindo para que outras pessoas não enfrentem os mesmos obstáculos.

---

## Objetivos

### Objetivo Geral

Criar uma plataforma voltada à comunidade jardineira e/ou florista, para auxiliar na prática da horticultura por meio do comércio de produtos para cultivo e do fornecimento de informações que enriqueçam essa experiência.

### Objetivos Específicos

- Obter informações a fim de criar contas para identificação de usuários  
- Criar um espaço para vendas de recursos para o plantio  
- Permitir que usuários da plataforma possam cadastrar lojas e vender produtos voltados à horticultura  
- Oferecer informações sobre o cuidado de cada planta  
- Recomendar plantas de acordo com a região do usuário  
- Notificar o usuário sobre os cuidados necessários com suas plantas  
- Gerenciar uma área de suporte para usuários e vendedores  

---

## Divisão de Tarefas

### 🔹 Funções Gerais

| Membro             | Função                                                  |
|--------------------|----------------------------------------------------------|
| Eik Ericson        | Testes e liderança do grupo                              |
| Millena Pimentel   | Desenvolvimento do front-end                             |
| Rodrigo Frota      | Desenvolvimento do back-end e modelagem UML              |
| Letícia Barbosa    | Documentação e organização de tarefas no GitHub          |

---

### 🔹 Etapa 1 - Planejamento e Início (Prazo: 03/06/2025)

| Tarefa                             | Responsável        | Status   |
|------------------------------------|--------------------|----------|
| Introdução do Projeto              | Eik Ericson        | Feito    |
| Plano do Projeto                   | Millena Pimentel   | Feito    |
| Modelagem Inicial                  | Rodrigo Frota      | Feito    |
| Documentação Geral e README        | Letícia Barbosa    | Feito    |
| Criação de Issues e Kanban         | Letícia Barbosa    | Feito    |

---

## Estrutura do Projeto

A estrutura de pastas segue uma organização modular para facilitar o entendimento e manutenção do código:

```
src/
├── controller/        # Controllers responsáveis pela lógica de cada tela
├── model/             # Classes de domínio (Planta, Usuario, Loja)
├── view/              # Arquivos FXML das telas criadas
├── util/              # Classes utilitárias e helpers
└── Main.java          # Classe principal que inicializa a aplicação
```

> As telas foram criadas com o **SceneBuilder** e conectadas aos controllers via FXML.

---

## Telas Implementadas

Estas são as telas desenvolvidas até o momento no projeto:

- **Tela de Login** – Tela inicial de autenticação do usuário  
- **TeladLogin** – Versão alternativa ou experimental da tela de login  
- **Tela de Cadastro** – Criação de nova conta de usuário  
- **Tela de Edição** – Edição das informações do usuário  
- **Tela de Edição Vendedor** – Edição de dados da loja ou vendedor  
- **Tela Principal** – Tela central da aplicação após login  
- **Tela Perfil de Usuário** – Visualização e edição do perfil pessoal  
- **Tela Lista Plantas** – Listagem de todas as plantas da plataforma  
- **Tela Carrinho** – Visualização dos itens no carrinho  
- **Tela Finalizar Compra** – Etapa final de confirmação de pedido  
- **paginaAlgodao** – Página com informações da planta "Algodão"  
- **paginaCaju** – Página com informações da planta "Caju"  

---

## Navegação entre Telas

A navegação entre telas está sendo implementada utilizando os recursos do JavaFX:

- Cada tela é carregada via `FXMLLoader`
- Os controladores manipulam eventos de botão para trocar a cena atual
- Uma classe central (como `Main.java` ou uma classe utilitária) facilita as trocas de tela


## Funcionalidades Desenvolvidas

As principais funcionalidades implementadas ou em andamento:

- Autenticação de usuários  
- Cadastro de novos usuários  
- Cadastro e listagem de produtos  
- Visualização de detalhes da planta  
- Adição de itens ao carrinho  
- Edição de perfil de usuário e vendedor  
- Finalização da compra  
- Navegação entre telas via botões  

---

## Modelagem Inicial

Foram elaborados os seguintes diagramas UML:

- **Diagrama de Classes** – estrutura do sistema  
- **Diagrama de Casos de Uso** – funcionalidades previstas  
- **Diagramas de Sequência** – fluxo de ações  

> Os arquivos estão disponíveis na pasta `/Diagramas`.

---

## Ambiente e Ferramentas

- **Git/GitHub** – Versionamento e organização de tarefas  
- **BlueJ** – Ambiente de desenvolvimento Java  
- **Markdown** – Documentação clara e estruturada  
- **SceneBuilder** – Criação das interfaces gráficas (FXML)  
- **PlantUML** – Modelagem UML dos diagramas  

---

## Testes e Validações

Os testes estão sendo realizados de forma manual, com foco em:

- Navegação entre telas  
- Entrada e validação de dados nos formulários  
- Verificação visual da interface  
- Funcionamento dos botões e ações associadas  
- Testes de cadastro, login e fluxo de compra

### Testes das Telas de Finalizar Compra

- **Descrição geral:**  
  Testes realizados nas telas do fluxo de finalização de compra, verificando a funcionalidade e interação entre elas.
- **Status dos testes:**  
  - Todas as telas estão funcionando corretamente e se comunicam entre si como esperado.  
  - A exceção é o botão **"Concluir compra"** na tela de boletos, que ainda não está funcionando corretamente para direcionar à tela de compra finalizada.
- **Detalhes do problema encontrado:**  
  - Ao clicar no botão **"Concluir compra"** na tela de boletos, a transição para a tela de compra finalizada não ocorre.  
  - Esse ponto precisa ser investigado e corrigido para garantir o fluxo completo de finalização de compra.

### Testes da Tela de Carrinho de Compras

- **Descrição geral:**  
  A tela de carrinho de compras está funcionando corretamente em sua maior parte, apresentando os produtos adicionados e permitindo interação do usuário.
- **Status dos testes:**  
  - A exibição dos produtos adicionados está correta.  
  - A remoção de produtos (se aplicável) está funcionando.  
  - O problema identificado está na soma dos valores dos produtos.
- **Detalhes do problema encontrado:**  
  - Quando mais de um produto é selecionado, o valor total **não está sendo somado corretamente**.  
  - O sistema aparenta considerar apenas o valor de um único produto, ignorando os demais na hora de calcular o total da compra.


---

## Síntese do Trabalho Realizado

Até o momento, o grupo concluiu com sucesso as etapas iniciais do projeto, incluindo:

- Planejamento geral  
- Definição de objetivos e funções  
- Criação e configuração do repositório GitHub  
- Organização via Kanban  
- Elaboração dos primeiros diagramas UML  
- Estruturação da documentação inicial  
- Implementação das principais telas e controllers  
- Desenvolvimento inicial da navegação e funcionalidades principais


