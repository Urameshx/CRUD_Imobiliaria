package bound;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Imovel;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import controller.ImovelController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ImobBoundary extends Application{
	private TextField tfidImovel = new TextField();
	private TextField tfEnderecoImov = new TextField();
	private TextField tfBairro = new TextField();
	private TextField tfCEP = new TextField();
	private Button btnInserirImovel = new Button("Inserir");
	private Button btnBuscarImovel = new Button("Buscar");
	private Button btnAtualizarImovel = new Button("Atualizar");
	private Button btnExcluirImovel = new Button("Excluir");
	private Button btnListarImovel = new Button("Listar");
	private TextArea taListaImoveis = new TextArea();

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane pane = new AnchorPane();
		
		//Inserindo tamanhos
		tfidImovel.setLayoutX(120);
		tfidImovel.setLayoutY(30);
		tfidImovel.setPrefHeight(25);
		tfidImovel.setPrefWidth(165);
		
		tfEnderecoImov.setLayoutX(162);
		tfEnderecoImov.setLayoutY(64);
		tfEnderecoImov.setPrefHeight(25);
		tfEnderecoImov.setPrefWidth(362);
		
		tfBairro.setLayoutX(80);
		tfBairro.setLayoutY(106);
		tfBairro.setPrefHeight(25);
		tfBairro.setPrefWidth(145);
		
		tfCEP.setLayoutX(290);
		tfCEP.setLayoutY(106);
		tfCEP.setPrefHeight(25);
		tfCEP.setPrefWidth(148);
		
		btnInserirImovel.setLayoutX(36);
		btnInserirImovel.setLayoutY(161);
		btnInserirImovel.setOnAction((event) -> {
			String cmd = event.getSource().toString();
			System.out.println(cmd); 
			ImovelController imovelController = 
					new ImovelController(tfidImovel,tfEnderecoImov,tfBairro,tfCEP,taListaImoveis); 
			
			if ((cmd.contains("Inserir")) && (tfidImovel.getText().isEmpty() 
					|| tfEnderecoImov.getText().isEmpty() || tfBairro.getText().isEmpty() || 
					tfCEP.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha o campo",
						"ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				if (cmd.contains("Inserir")) {
					Imovel i = new Imovel();
					i.setCodigo(Integer.parseInt(tfidImovel.getText()));
					i.setEndereco(tfEnderecoImov.getText());
					i.setBairro(tfBairro.getText());
					i.setCep(tfCEP.getText());
					imovelController.inserirImovel(i);
				} 
			} catch(ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO"
						, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
        });
		
		btnAtualizarImovel .setLayoutX(151);
		btnAtualizarImovel.setLayoutY(161);
		btnAtualizarImovel.setOnAction((event) -> {
			String cmd = event.getSource().toString();
			System.out.println(cmd); 
			ImovelController imovelController = 
					new ImovelController(tfidImovel,tfEnderecoImov,tfBairro,tfCEP,taListaImoveis); 
			
			if ((cmd.contains("Atualizar")) && (tfidImovel.getText().isEmpty() 
					|| tfEnderecoImov.getText().isEmpty() || tfBairro.getText().isEmpty() ||
					tfCEP.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha o campo",
						"ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				if (cmd.contains("Atualizar")) {
					Imovel i = new Imovel();
					i.setCodigo(Integer.parseInt(tfidImovel.getText()));
					i.setEndereco(tfEnderecoImov.getText());
					i.setBairro(tfBairro.getText());
					i.setCep(tfCEP.getText());
					imovelController.atualizarImovel(i);
				} 
			} catch(ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO"
						, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
        });
		
		btnBuscarImovel .setLayoutX(300);
		btnBuscarImovel.setLayoutY(30);
		btnBuscarImovel.setOnAction((event) -> {
			String cmd = event.getSource().toString();
			System.out.println(cmd); 
			ImovelController imovelController = 
					new ImovelController(tfidImovel,tfEnderecoImov,tfBairro,tfCEP,taListaImoveis);
			try {
				if (cmd.contains("Buscar")) {
					Imovel i = new Imovel();
					i.setCodigo(Integer.parseInt(tfidImovel.getText()));
					//i.setEndereco(tfEnderecoImov.getText());
					//i.setBairro(tfBairro.getText());
					//i.setCep(tfCEP.getText());
					imovelController.buscarImovel(i);
				} 
			} catch(ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO"
						, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		});	
		
		btnExcluirImovel.setLayoutX(274);
		btnExcluirImovel.setLayoutY(161);
		btnExcluirImovel.setOnAction((event) -> {
			String cmd = event.getSource().toString();
			System.out.println(cmd); 
			ImovelController imovelController = 
					new ImovelController(tfidImovel,tfEnderecoImov,tfBairro,tfCEP,taListaImoveis);
			try {
				if (cmd.contains("Excluir")) {
					Imovel i = new Imovel();
					i.setCodigo(Integer.parseInt(tfidImovel.getText()));
					//i.setEndereco(tfEnderecoImov.getText());
					//i.setBairro(tfBairro.getText());
					//i.setCep(tfCEP.getText());
					imovelController.excluirImovel(i);
				} 
			} catch(ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO"
						, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
        });
			
		
		btnListarImovel.setLayoutX(394);
		btnListarImovel.setLayoutY(161);
		btnListarImovel.setOnAction((event) -> {
			String cmd = event.getSource().toString();
			System.out.println(cmd); 
			ImovelController imovelController = 
					new ImovelController(tfidImovel,tfEnderecoImov,tfBairro,tfCEP,taListaImoveis);
			try {
				if (cmd.contains("Listar")) {
					imovelController.buscarImoveis();
				} else {
					Imovel i = new Imovel();
					i.setCodigo(Integer.parseInt(tfidImovel.getText()));
					i.setEndereco(tfEnderecoImov.getText());
					i.setBairro(tfBairro.getText());
					i.setCep(tfCEP.getText());
				}
			} catch(ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO"
						, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		});	
		
		taListaImoveis.setLayoutX(26);
		taListaImoveis.setLayoutY(200);
		taListaImoveis.setPrefHeight(161);
		taListaImoveis.setPrefWidth(553);
		
		Label labelId = new Label("Id do Imovel");
        labelId.setLayoutX(36);
        labelId.setLayoutY(34);
		pane.getChildren().add(labelId);
		
		Label labelEnd = new Label("Endereço do Imovel");
        labelEnd.setLayoutX(36);
        labelEnd.setLayoutY(68);
		pane.getChildren().add(labelEnd);
        
		Label labelB = new Label("Bairro");
		labelB.setLayoutX(36);
		labelB.setLayoutY(110);
		pane.getChildren().add(labelB);
		
		Label labelC = new Label("CEP");
		labelC.setLayoutX(252);
		labelC.setLayoutY(110);
		pane.getChildren().add(labelC);
		
		
		
		ScrollPane scr = new ScrollPane();
		scr.setLayoutX(26);
		scr.setLayoutY(200);
		pane.getChildren().add(scr);
		
				
		pane.getChildren().addAll(tfidImovel,tfEnderecoImov,tfBairro,tfCEP,btnInserirImovel,btnBuscarImovel,btnAtualizarImovel,
					btnExcluirImovel,btnListarImovel,taListaImoveis);
		 
		 Scene scene = new Scene(pane,600,400);
		 primaryStage.setTitle("Cadastro de Imoveis");
		 primaryStage.setScene(scene);
		 primaryStage.show();
		 		 
	}
	
}




