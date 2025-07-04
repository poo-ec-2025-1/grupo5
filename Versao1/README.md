
> ⚠️ *Este repositório é mantido apenas como referência da primeira tentativa. A versão funcional e final do projeto está disponível no repositorio `Versao2`.*


# 🌱 Projeto Versão 1 - Aplicativo ecommerce de vendas, compras e informações sobre as plantas

Este projeto representa a **primeira versão** do aplicativo desenvolvido para gerenciamento de cadastro de plantas e simulação de vendas. Ele foi desenvolvido no início do processo do trabalho, mas acabou sendo **abandonado e refeito do zero** devido a diversas dificuldades enfrentadas durante o desenvolvimento.

## ❌ Por que essa versão deu errado?

Apesar da proposta ser interessante, diversos fatores impediram o bom funcionamento do projeto. Entre os principais erros e dificuldades estão:

### 1. Falta de integração entre as telas
- As **telas FXML** não se comunicavam corretamente entre si.
- Faltou uma estrutura clara de navegação (por exemplo, ir da tela de login para o menu principal ou para a tela de cadastro de forma fluida).
- Os controladores (controllers) estavam mal organizados ou incompletos, dificultando a manutenção e a evolução do projeto.

### 2. Organização confusa do código
- Algumas classes estavam incompletas ou mal nomeadas.
- Código repetido e pouca separação entre lógica de negócio e interface gráfica.
- (Isso devida a tentativa simultanea de varios membros tentando realizar uma mesma tarefa).

### 3. Dificuldade na implementação do banco de dados
- A tentativa de conexão com banco de dados com o carrinho foi exaustiva e não houve exito.
- As operações de salvar, buscar ou listar dados ainda não funcionavam corretamente.

### 4. Falta de MVC e boas práticas
- O projeto não seguia um padrão como o **Modelo-Visão-Controlador (MVC)**, o que dificultava o crescimento e manutenção, começamos a implementar apenas no meio do projeto.
- Muitos trechos de código estavam misturados diretamente na interface gráfica ou sem clareza de função.

## 🛠️ O que foi aprendido com essa versão?

Apesar dos erros, esta versão foi **importante como aprendizado**. Através dela, a equipe percebeu a necessidade de:
- Adotar um padrão de projeto (como MVC);
- Separar bem as responsabilidades entre as classes;
- Ter uma boa comunicação entre os membros e seus feitos;
- Usar o **Scene Builder** corretamente para criar as telas e integrá-las via código.

## 🔁 O que mudou na versão final?

Após abandonar essa versão, a equipe recomeçou o projeto com:
- Estrutura mais limpa e organizada, com o padrão MVC;
- Implementação correta das **funcionalidades de cadastro, compra e carrinho**;
- Integração com banco de dados funcional;
- Interface conectada de forma fluida e funcional, respeitando o padrão JavaFX CRUD.

---

## 📂 Estrutura do projeto (Versão 1)

