# Marketplace de Plantas

## Descrição do Projeto

Este é um projeto acadêmico cujo objetivo foi desenvolver um **Produto Mínimo Viável (MVP)** de um **aplicativo de Marketplace de Plantas**, utilizando **Java**, **JavaFX** e **ORMLite**.  

A aplicação permite que vendedores cadastrem plantas com informações como nome, categoria, preço e descrição. O usuário pode visualizar a lista de plantas, atualizar os dados e deletar registros com facilidade.  

O projeto foca em demonstrar **boas práticas de programação orientada a objetos**, **persistência de dados com banco SQLite**, e **interfaces gráficas modernas** integradas via **FXML + Scene Builder**.

---

## Versão

**Data da entrega:** 30/06  
**Status:** MVP funcional completo com operações CRUD

---

## Como Iniciar o Projeto

Siga os passos abaixo para executar o projeto localmente:

### Pré-requisitos:
- Java JDK 8 ou superior
- BlueJ instalado
- Scene Builder (para edição das interfaces FXML)
- Biblioteca ORMLite (já incluída no projeto)

### Passos:

1. **Clone o repositório:** https://github.com/

```bash
git clone https://github.com/RodrigoFrota/poo-ec-2025-1/grupo5.git
-----
Autores

Rodrigo Frota
Millena Pimentel
Letícia Barbosa

Funcionalidades

Cadastro de novas plantas com nome, categoria, preço e descrição
Atualização de registros existentes
Deleção de plantas
Visualização de todos os registros em uma tabela dinâmica
Interface intuitiva desenvolvida com Scene Builder
Persistência com banco de dados SQLite via ORMLite

Instruções para o Usuário

Ao abrir a aplicação, clique em "Adicionar" para inserir uma nova planta.
Preencha os campos: Nome, Categoria, Preço e Descrição.
Clique em "Salvar" para registrar a planta no banco de dados.
Para editar uma planta, selecione-a na tabela e clique em "Atualizar".
Para excluir, selecione e clique em "Deletar".
Use o botão "Cancelar" para limpar os campos e retornar ao estado inicial.

Objetivo

O propósito deste projeto é consolidar os conhecimentos em Java, arquitetura MVC, controle de versão com GitHub, modelagem com UML e interfaces gráficas com JavaFX, além de trabalhar em equipe para entregar um MVP funcional.

Estrutura do Projeto

src/
├── app/
│   └── Main.java
├── controller/
│   └── PlantaController.java
├── model/
│   └── Planta.java, Database.java
├── repository/
│   └── PlantaRepositorio.java
├── view/
│   └── cadastro.fxml, PlantaView.java
└── README.md
Este projeto foi desenvolvido como parte da disciplina de Programação Orientada a Objetos.


