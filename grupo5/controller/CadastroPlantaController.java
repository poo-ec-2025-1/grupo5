package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

import model.Planta;
import model.PlantaRepositorio;
import model.Database;

import java.util.List;

public class CadastroPlantaController {

    @FXML private TextField campoId;
    @FXML private TextField campoNome;
    @FXML private TextField campoPreco;
    @FXML private TextField campoCategoria;
    @FXML private TextField campoDescricao;

    @FXML private TableView<Planta> tabelaPlantas;
    @FXML private TableColumn<Planta, String> colNome;
    @FXML private TableColumn<Planta, Double> colPreco;
    @FXML private TableColumn<Planta, String> colCategoria;
    @FXML private TableColumn<Planta, String> colDescricao;

    @FXML private Button btnAdicionar;
    @FXML private Button btnAtualizar;
    @FXML private Button btnDeletar;
    @FXML private Button btnCancelar;
    @FXML private Button btnSalvar;

    private ObservableList<Planta> listaPlantas;
    private PlantaRepositorio plantaRepositorio;
    private Database db;

    public CadastroPlantaController() {
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
        bloquearEdicao();

        tabelaPlantas.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) {
                preencherFormulario(novo);
                btnAtualizar.setDisable(false);
                btnDeletar.setDisable(false);
            }
        });
    }
    @FXML
    private void voltarParaTelaPrincipal(javafx.event.ActionEvent event) {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("/view/TelaPrincipal.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 360, 640)); // layout mobile
        stage.setTitle("Tela Principal");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }


    private void atualizarLista() {
        List<Planta> plantas = plantaRepositorio.listarTodas();
        listaPlantas = FXCollections.observableArrayList(plantas);
        tabelaPlantas.setItems(listaPlantas);
    }

    private void limparCampos() {
        campoId.clear();
        campoNome.clear();
        campoPreco.clear();
        campoCategoria.clear();
        campoDescricao.clear();
    }

    private void preencherFormulario(Planta planta) {
        campoId.setText(String.valueOf(planta.getId()));
        campoNome.setText(planta.getNome());
        campoPreco.setText(String.valueOf(planta.getPreco()));
        campoCategoria.setText(planta.getCategoria());
        campoDescricao.setText(planta.getDescricao());
    }

    private void habilitarEdicao() {
        campoNome.setDisable(false);
        campoPreco.setDisable(false);
        campoCategoria.setDisable(false);
        campoDescricao.setDisable(false);
    }

    private void bloquearEdicao() {
        campoNome.setDisable(false);
        campoPreco.setDisable(false);
        campoCategoria.setDisable(false);
        campoDescricao.setDisable(false);
        btnAtualizar.setDisable(true);
        btnSalvar.setDisable(true);
        btnCancelar.setDisable(true);
    }

    @FXML
    private void cadastrarPlanta() {
        try {
            String nome = campoNome.getText();
            double preco = Double.parseDouble(campoPreco.getText());
            String categoria = campoCategoria.getText();
            String descricao = campoDescricao.getText();

            Planta nova = new Planta(nome, preco, categoria, descricao);
            plantaRepositorio.adicionar(nova);
            atualizarLista();
            limparCampos();
        } catch (Exception e) {
            mostrarAlerta("Erro", "Dados inválidos ou incompletos.");
        }
    }

    @FXML
    private void removerPlanta() {
        Planta selecionada = tabelaPlantas.getSelectionModel().getSelectedItem();
        if (selecionada != null) {
            plantaRepositorio.deletar(selecionada);
            atualizarLista();
            limparCampos();
            bloquearEdicao();
        } else {
            mostrarAlerta("Aviso", "Selecione uma planta para remover.");
        }
    }

    @FXML
    private void onAtualizar() {
        habilitarEdicao();
        btnSalvar.setDisable(false);
        btnCancelar.setDisable(false);
        btnAdicionar.setDisable(true);
        btnAtualizar.setDisable(true);
    }

    @FXML
    private void onSalvar() {
        try {
            int id = Integer.parseInt(campoId.getText());
            Planta planta = plantaRepositorio.buscarPorId(id);
            if (planta != null) {
                planta.setNome(campoNome.getText());
                planta.setPreco(Double.parseDouble(campoPreco.getText()));
                planta.setCategoria(campoCategoria.getText());
                planta.setDescricao(campoDescricao.getText());

                plantaRepositorio.atualizar(planta);
                atualizarLista();
                limparCampos();
                bloquearEdicao();
                btnAdicionar.setDisable(false);
            }
        } catch (Exception e) {
            mostrarAlerta("Erro", "Erro ao salvar alterações.");
        }
    }

    @FXML
    private void onCancelar() {
        limparCampos();
        bloquearEdicao();
        btnAdicionar.setDisable(false);
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}


