package view;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Planta {

    private SimpleIntegerProperty id;
    private SimpleStringProperty nome;
    private SimpleStringProperty categoria;
    private SimpleDoubleProperty preco;
    private SimpleStringProperty descricao;

    public Planta(int id, String nome, String categoria, double preco, String descricao) {
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.categoria = new SimpleStringProperty(categoria);
        this.preco = new SimpleDoubleProperty(preco);
        this.descricao = new SimpleStringProperty(descricao);
    }

    // Getters e setters

    public int getId() {
        return this.id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNome() {
        return this.nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getCategoria() {
        return this.categoria.get();
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }

    public double getPreco() {
        return this.preco.get();
    }

    public void setPreco(double preco) {
        this.preco.set(preco);
    }

    public String getDescricao() {
        return this.descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }
}