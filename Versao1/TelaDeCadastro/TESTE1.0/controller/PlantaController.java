package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import repository.PlantaRepositorio;
import view.PlantaView;
import model.Database;
import model.Planta;

public class PlantaController implements Initializable {
    @FXML private TableView<view.PlantaView> tabela;
    @FXML private TableColumn<view.PlantaView, Integer> idCol;
    @FXML private TableColumn<view.PlantaView, String> nomeCol;
    @FXML private TableColumn<view.PlantaView, String> categoriaCol;
    @FXML private TableColumn<view.PlantaView, Double> precoCol;
    @FXML private TableColumn<view.PlantaView, String> descricaoCol;

    @FXML private TextField idField;
    @FXML private TextField nomeField;
    @FXML private TextField categoriaField;
    @FXML private TextField precoField;
    @FXML private TextField descricaoField;

    @FXML private Button adicionarButton;
    @FXML private Button atualizarButton;
    @FXML private Button deletarButton;
    @FXML private Button cancelarButton;
    @FXML private Button salvarButton;
    
    
    private static model.Database database = new model.Database("mktplace.sqlite");
    private static repository.PlantaRepositorio plantaRepo = new repository.PlantaRepositorio(database);
        
    private void desabilitarBotoes(boolean adicionar, boolean atualizar, boolean deletar, boolean cancelar, boolean salvar) {
        adicionarButton.setDisable(adicionar);
        atualizarButton.setDisable(atualizar);
        deletarButton.setDisable(deletar);
        cancelarButton.setDisable(cancelar);
        salvarButton.setDisable(salvar);        
    }
    
    private void desabilitarCampos(boolean desabilitado) {
        nomeField.setDisable(desabilitado);
        precoField.setDisable(desabilitado);
        categoriaField.setDisable(desabilitado);
        descricaoField.setDisable(desabilitado); 
    }
    
    private void limparCampos() {
    idField.setText("");
        nomeField.setText("");
        precoField.setText("");
        categoriaField.setText("");
        descricaoField.setText("");           
    }
    
    @FXML
    public void onCancelarButtonAction() {
        desabilitarCampos(true);
        desabilitarBotoes(false,true,true,true,true);
        limparCampos();
        tabela.getSelectionModel().select(-1);        
    }
    
    @FXML
    public void onSalvarButtonAction() {
        try {
            model.Planta planta = new model.Planta();            
            planta.setNome(nomeField.getText());
            planta.setCategoria(categoriaField.getText());
            planta.setPreco(Double.parseDouble(precoField.getText()));
            planta.setDescricao(descricaoField.getText());           
            
            model.Planta planta_salva = plantaRepo.create(planta); 
            view.PlantaView plantaView = modelToView(planta_salva);
            tabela.getItems().add(plantaView);
            tabela.getSelectionModel().select(plantaView);    
            desabilitarCampos(true);
            desabilitarBotoes(false,true,true,true,true);            
        }
        catch(Exception e) {
            new Alert(AlertType.ERROR, "Erro ao salvar: "+e.getMessage()).show();
        }
    }    
    
    @FXML
    public void onAdicionarButtonAction() {
        tabela.getSelectionModel().select(-1);
        desabilitarCampos(false);
        desabilitarBotoes(true,true,true,false,false);
        limparCampos();
    }

    @FXML
    private void handlePlantaSelected(view.PlantaView newSelection) {
        if (newSelection != null)
            idField.setText(Integer.toString(newSelection.getId()));
            nomeField.setText(newSelection.getNome());
            categoriaField.setText(newSelection.getCategoria());
            precoField.setText(Double.toString(newSelection.getPreco()));
            descricaoField.setText(newSelection.getDescricao());
            desabilitarBotoes(false, false, false, true, true);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        categoriaCol.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        precoCol.setCellValueFactory(new PropertyValueFactory<>("preco"));
        descricaoCol.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        
        tabela.setItems(loadAllPlantas());
        tabela.getSelectionModel().selectedItemProperty().addListener(
            (observableValue, oldSelection, newSelection) -> {
                handlePlantaSelected(newSelection);
            });
    }
    
    private view.PlantaView modelToView(model.Planta planta) {
        return new view.PlantaView(
            planta.getId(),
            planta.getNome(),
            planta.getCategoria(),
            planta.getPreco(),
            planta.getDescricao()
        );
    }
    
    private ObservableList<view.PlantaView> loadAllPlantas() {
        ObservableList<view.PlantaView> lista = 
            FXCollections.observableArrayList();
        List<model.Planta> listaFromDatabase = plantaRepo.loadAll();
        for(model.Planta planta: listaFromDatabase) {
            lista.add(modelToView(planta));
        }
        return lista;
    }
}