package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Planta;
import model.PlantaRepositorio;
import model.Database;
import model.SessaoCompra;

import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.util.List;

public class CompraController {

    @FXML private TableView<Planta> tabelaPlantas;
    @FXML private TableColumn<Planta, String> colNome;
    @FXML private TableColumn<Planta, Double> colPreco;
    @FXML private TableColumn<Planta, String> colCategoria;
    @FXML private TableColumn<Planta, String> colDescricao;

    @FXML private Button btnAdicionarAoCarrinho;
    @FXML private Button btnFinalizarCompra;

    private ObservableList<Planta> listaPlantas;

    private PlantaRepositorio plantaRepositorio;
    private Database db;

    public CompraController() {
        try {
            db = new Database("plantas.db");
            plantaRepositorio = new PlantaRepositorio(db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNome()));
        colPreco.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getPreco()));
        colCategoria.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCategoria()));
        colDescricao.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDescricao()));

        atualizarLista();
    }

    private void atualizarLista() {
        List<Planta> plantas = plantaRepositorio.listarTodas();
        listaPlantas = FXCollections.observableArrayList(plantas);
        tabelaPlantas.setItems(listaPlantas);
    }

 @FXML
private void adicionarAoCarrinho() {
    Planta selecionada = tabelaPlantas.getSelectionModel().getSelectedItem();
    if (selecionada != null) {
        SessaoCompra sessao = SessaoCompra.getInstancia();
        List<Planta> carrinho = sessao.getCarrinho();
        carrinho.add(selecionada);
        sessao.setCarrinho(carrinho); // Atualiza o total
        mostrarAlerta("Carrinho", "Planta adicionada ao carrinho!");
    } else {
        mostrarAlerta("Aviso", "Selecione uma planta para adicionar ao carrinho.");
    }
}


@FXML
private void finalizarCompra(ActionEvent event) {
    SessaoCompra sessao = SessaoCompra.getInstancia();
    if (sessao.getCarrinho().isEmpty()) {
        mostrarAlerta("Carrinho vazio", "Adicione plantas ao carrinho antes de finalizar a compra.");
        return;
    }

    try {
        Parent root = FXMLLoader.load(getClass().getResource("/view/EnderecoDeEntrega.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 360, 640));
        stage.setTitle("Endereço de Entrega");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        mostrarAlerta("Erro", "Erro ao carregar a tela de Endereço de Entrega.");
    }
}



    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    @FXML
    private void voltar() {
        System.out.println("Voltando para tela anterior...");
    }

    @FXML
    private void sair() {
        System.exit(0);
    }
}

