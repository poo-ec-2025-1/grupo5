#  Erro Corrigido no Teste `SessaoCompraTest.java`

Durante o desenvolvimento dos testes de unidade do projeto, foi identificado um erro na classe `SessaoCompra.java`, relacionado à tentativa de esvaziar uma lista imutável.

---

##  Descrição do Erro

Ao executar o teste `SessaoCompraTest`, foi lançada a seguinte exceção:

`java.lang.UnsupportedOperationException
at java.util.AbstractList.clear(AbstractList.java:245)
at model.SessaoCompra.limpar(SessaoCompra.java:40)`

Esse erro ocorreu na seguinte linha do método `limpar()`:

``java
carrinho.clear();

#  Causa
O problema estava no método setCarrinho(...):

`public void setCarrinho(List<Planta> carrinho) {
    this.carrinho = carrinho;
    calcularTotal();
}`

 lista passada como parâmetro poderia ser uma lista imutável, como as criadas com Arrays.asList(...).
Ao tentar limpar essa lista com clear(), a exceção UnsupportedOperationException era lançada.

#  Solução Aplicada
A solução foi alterar o método setCarrinho(...) para que sempre seja criada uma nova lista mutável a partir da recebida:

`public void setCarrinho(List<Planta> carrinho) {
    this.carrinho = new ArrayList<>(carrinho); // cria cópia mutável
    calcularTotal();
}`

Com essa alteração, o método limpar() pode limpar a lista com segurança, sem risco de exceções.

#  Resultado
Após aplicar a correção:

-O erro deixou de ocorrer.\
-O teste SessaoCompraTest passou com sucesso.\
-A classe SessaoCompra ficou mais robusta e segura para uso com diferentes tipos de listas.







