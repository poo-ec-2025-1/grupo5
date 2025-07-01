package model;

import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName="planta")
public class Planta {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(dataType=DataType.STRING)
    private String nome;

    @DatabaseField(dataType=DataType.STRING)
    private String categoria;

    @DatabaseField(dataType=DataType.DOUBLE)
    private double preco;

    @DatabaseField(dataType=DataType.STRING)
    private String descricao;

    // Getters e Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
