package view;

import javafx.beans.property.*;

public class PlantaView {
    private IntegerProperty id;
    private StringProperty nome;
    private StringProperty categoria;
    private DoubleProperty preco;
    private StringProperty descricao;

    public PlantaView(int id, String nome, String categoria, double preco, String descricao) {
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.categoria = new SimpleStringProperty(categoria);
        this.preco = new SimpleDoubleProperty(preco);
        this.descricao = new SimpleStringProperty(descricao);
    }

    public int getId() { return id.get(); }
    public void setId(int id) { this.id.set(id); }

    public String getNome() { return nome.get(); }
    public void setNome(String nome) { this.nome.set(nome); }

    public String getCategoria() { return categoria.get(); }
    public void setCategoria(String categoria) { this.categoria.set(categoria); }

    public double getPreco() { return preco.get(); }
    public void setPreco(double preco) { this.preco.set(preco); }

    public String getDescricao() { return descricao.get(); }
    public void setDescricao(String descricao) { this.descricao.set(descricao); }
}

