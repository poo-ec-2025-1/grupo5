#  Documentação dos Testes dos Arquivos FXML

Este documento descreve como foram realizados os testes para as interfaces gráficas do projeto JavaFX, implementadas com arquivos `.fxml` e seus respectivos controladores (`controllers`). O foco está em garantir que os componentes da interface e suas funcionalidades estejam corretamente conectados, funcionais e integrados com a lógica do sistema.

---

##  Tela: `TelaPrincipal.fxml`

* **Controller:** `TelaPrincipalController.java`
* **Funções testadas:**

  * Navegação para `CadastroPlanta.fxml` com `Main.mudarTela("CadastroPlanta")`.
  * Navegação para a tela de compras com `Main.mudarTela("Comprar")`.
* **Testes aplicados:**

  * Testes manuais de botões.
  * Verificação visual da mudança de tela.

---

##  Tela: `CadastroPlanta.fxml`

* **Controller:** `CadastroPlantaController.java`
* **Funções testadas:**

  * Cadastro de nova planta.
  * Atualização e deleção de plantas selecionadas na tabela.
  * Controle de estados dos botões (Salvar, Cancelar, Atualizar).
  * Integração com o banco de dados via `PlantaRepositorio`.
* **Testes aplicados:**

  * Testes unitários nos métodos `cadastrarPlanta`, `removerPlanta`, `onSalvar` etc.
  * Teste de integração com banco de dados.

---

##  Tela: `Compra.fxml`

* **Controller:** `CompraController.java`
* **Funções testadas:**

  * Listagem de plantas na interface.
  * Adição ao carrinho usando `SessaoCompra`.
  * Navegação para `EnderecoDeEntrega.fxml`.
  * Validação de carrinho vazio.
* **Testes aplicados:**

  * Testes manuais de fluxo de compra.
  * Testes de lógica do carrinho com `SessaoCompraTest.java`.

---

##  Tela: `EnderecoDeEntrega.fxml`

* **Controller:** `EnderecoDeEntregaController.java`
* **Funções testadas:**

  * Selecão entre "meu endereço" e "novo endereço".
  * Navegação condicional para `FormaDePagamento.fxml` ou `NovoEndereco.fxml`.
* **Testes aplicados:**

  * Testes manuais das opções de endereço.

---

##  Tela: `FormaDePagamento.fxml`

* **Controller:** `FormaDePagamentoController.java`
* **Funções testadas:**

  * Navegação para `CartaoDeCredito.fxml`, `Pix.fxml`, `Boleto.fxml`.
* **Testes aplicados:**

  * Testes manuais clicando nos botões de escolha da forma de pagamento.

---

##  Tela: `CartaoDeCredito.fxml`

* **Controller:** `CartaoDeCreditoController.java`
* **Funções testadas:**

  * Validação dos campos de entrada.
  * Selecção de parcelas via `ToggleGroup`.
  * Salvamento no banco `meubanco.db`.
  * Navegação para `CompraFinalizada.fxml`.
* **Testes aplicados:**

  * Testes manuais com dados válidos e inválidos.
  * Teste do método `salvarDados`.

---

##  Tela: `Pix.fxml`

* **Controller:** `PixController.java`
* **Funções testadas:**

  * Confirmação de pagamento.
  * Navegação para `CompraFinalizada.fxml`.
* **Testes aplicados:**

  * Teste manual da ação do botão "Concluí o pagamento".

---

##  Tela: `CompraFinalizada.fxml`

* **Controller:** `CompraFinalizadaController.java`
* **Funções testadas:**

  * Botão "Voltar para o início" limpa o carrinho e volta para a `TelaPrincipal.fxml`.
* **Testes aplicados:**

  * Teste visual da tela final de compra.
  * Confirmação de que o carrinho é resetado.

---

##  Tela: `Login.fxml`

* **Controller:** `LoginController.java`
* **Funções testadas:**

  * Ação do botão Entrar redireciona para `TelaPrincipal.fxml` com `Main.mudarTela()`.
* **Testes aplicados:**

  * Teste manual do botão Entrar.

---

##  Tela: `NovoEndereco.fxml`

* **Controller:** (em desenvolvimento ou referenciado via `EnderecoDeEntregaController`)
* **Funções testadas:**

  * Abertura condicional com base na opção escolhida.

---

##  Considerações Gerais

* Todas as telas foram validadas por testes manuais no BlueJ e Scene Builder.
* Eventos `onAction` e `fx:id` foram verificados e estão corretamente conectados aos controladores.
* Navegações e interações visuais foram testadas em execução.
* Alguns botões e menus ainda precisam de ajustes para funcionamento futuro, como:
  * A opção de "Novo Endereço" na tela `EnderecoDeEntrega.fxml`, que depende de lógica complementar.
  * O botão de **boleto bancário** na tela `FormaDePagamento.fxml`, que ainda não está implementado.
  * Esses ajustes pendentes **não comprometem o funcionamento geral do aplicativo** e podem ser implementados em versões futuras.


---

##  Conclusão

Todos os arquivos `.fxml` estão funcionalmente conectados com seus controladores. Os testes realizados asseguram que os componentes da interface estão operando corretamente, garantindo uma experiência de uso fluida para o usuário.
