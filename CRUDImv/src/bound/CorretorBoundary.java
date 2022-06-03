package bound;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Corretor;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;


import java.sql.SQLException;


import javax.swing.JOptionPane;

import controller.CorretorController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class CorretorBoundary extends Application{
	private TextField tfidCorretor = new TextField();
	private TextField tfNomeCorretor = new TextField();
	private TextField tfRegiaoCorretor = new TextField();
	private TextField tfTelefoneCorretor = new TextField();
	private Button btnInserirCorretor = new Button("Inserir");
	private Button btnBuscarCorretor = new Button("Buscar");
	private Button btnAtualizarCorretor = new Button("Atualizar");
	private Button btnExcluirCorretor = new Button("Excluir");
	private Button btnListarCorretor = new Button("Listar");
	private TextArea taListaCorretor = new TextArea();

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane pane = new AnchorPane();
		
		//Inserindo tamanhos
		tfidCorretor.setLayoutX(277);
		tfidCorretor.setLayoutY(23);
		tfidCorretor.setPrefHeight(25);
		tfidCorretor.setPrefWidth(168);
		
		tfNomeCorretor.setLayoutX(277);
		tfNomeCorretor.setLayoutY(53);
		tfNomeCorretor.setPrefHeight(25);
		tfNomeCorretor.setPrefWidth(289);
		
		tfRegiaoCorretor.setLayoutX(277);
		tfRegiaoCorretor.setLayoutY(83);
		tfRegiaoCorretor.setPrefHeight(25);
		tfRegiaoCorretor.setPrefWidth(171);
		
		tfTelefoneCorretor.setLayoutX(277);
		tfTelefoneCorretor.setLayoutY(111);
		tfTelefoneCorretor.setPrefHeight(25);
		tfTelefoneCorretor.setPrefWidth(171);
		
		
		btnInserirCorretor.setLayoutX(88);
		btnInserirCorretor.setLayoutY(161);
		btnInserirCorretor.setOnAction((event) -> {
			String cmd = event.getSource().toString();
			System.out.println(cmd); 
			CorretorController corretorController = 
					new CorretorController(tfidCorretor,tfNomeCorretor,tfRegiaoCorretor,tfTelefoneCorretor,taListaCorretor);
			if ((cmd.contains("Inserir")) && (tfidCorretor.getText().isEmpty() 
					|| tfNomeCorretor.getText().isEmpty()) || tfRegiaoCorretor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o campo",
						"ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				if (cmd.contains("Inserir")) {
					Corretor c = new Corretor();
					c.setCreci(tfidCorretor.getText());
					c.setNome(tfNomeCorretor.getText());
					c.setRegiao(tfRegiaoCorretor.getText());
					c.setTelefone(tfTelefoneCorretor.getText());
					corretorController.inserirCorretor(c);
				} 
			} catch(ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO"
						, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
        });
		
		btnAtualizarCorretor .setLayoutX(214);
		btnAtualizarCorretor.setLayoutY(161);
		btnAtualizarCorretor.setOnAction((event) -> {
			String cmd = event.getSource().toString();
			System.out.println(cmd); 
			CorretorController corretorController = 
					new CorretorController(tfidCorretor,tfNomeCorretor,tfRegiaoCorretor,tfTelefoneCorretor,taListaCorretor);
			
			if ((cmd.contains("Atualizar")) && (tfidCorretor.getText().isEmpty() 
					|| tfNomeCorretor.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha o campo",
						"ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				if (cmd.contains("Atualizar")) {
					Corretor c = new Corretor();
					c.setCreci(tfidCorretor.getText());
					c.setNome(tfNomeCorretor.getText());
					c.setRegiao(tfRegiaoCorretor.getText());
					c.setTelefone(tfTelefoneCorretor.getText());
					corretorController.atualizarCorretor(c);
				} 
			} catch(ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO"
						, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
        });
		
		btnBuscarCorretor .setLayoutX(454);
		btnBuscarCorretor.setLayoutY(23);
		btnBuscarCorretor.setOnAction((event) -> {
			String cmd = event.getSource().toString();
			System.out.println(cmd); 
			CorretorController corretorController = 
					new CorretorController(tfidCorretor,tfNomeCorretor,tfRegiaoCorretor,tfTelefoneCorretor,taListaCorretor);
			try {
				if (cmd.contains("Buscar")) {
					Corretor c = new Corretor();
					c.setCreci(tfidCorretor.getText());
					corretorController.buscarCorretor(c);
				} 
			} catch(ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO"
						, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		});	
		
		btnExcluirCorretor.setLayoutX(346);
		btnExcluirCorretor.setLayoutY(161);
		btnExcluirCorretor.setOnAction((event) -> {
			String cmd = event.getSource().toString();
			System.out.println(cmd); 
			CorretorController corretorController = 
					new CorretorController(tfidCorretor,tfNomeCorretor,tfRegiaoCorretor,tfTelefoneCorretor,taListaCorretor);
			try {
				if (cmd.contains("Excluir")) {
					Corretor c = new Corretor();
					c.setCreci(tfidCorretor.getText());
					corretorController.excluirCorretor(c);
				} 
			} catch(ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO"
						, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
        });
			
		
		btnListarCorretor.setLayoutX(479);
		btnListarCorretor.setLayoutY(161);
		btnListarCorretor.setOnAction((event) -> {
			String cmd = event.getSource().toString();
			System.out.println(cmd); 
			CorretorController corretorController = 
					new CorretorController(tfidCorretor,tfNomeCorretor,tfRegiaoCorretor,tfTelefoneCorretor,taListaCorretor);
			try {
				if (cmd.contains("Listar")) {
					corretorController.buscarCorretores();
;				} else {
					Corretor c = new Corretor();
					c.setCreci(tfidCorretor.getText());
					c.setNome(tfNomeCorretor.getText());
					c.setRegiao(tfRegiaoCorretor.getText());
					c.setTelefone(tfTelefoneCorretor.getText());
				}
			} catch(ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO"
						, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		});	
		
		taListaCorretor.setLayoutX(26);
		taListaCorretor.setLayoutY(200);
		taListaCorretor.setPrefHeight(180);
		taListaCorretor.setPrefWidth(553);
		
		Label labelId = new Label("Creci do Corretor");
        labelId.setLayoutX(166);
        labelId.setLayoutY(27);
		pane.getChildren().add(labelId);
		
		Label labelNome = new Label("Nome do Corretor");
        labelNome.setLayoutX(166);
        labelNome.setLayoutY(57);
        labelNome.setPrefHeight(9);
        labelNome.setPrefWidth(98);
        pane.getChildren().add(labelNome);
        
		Label labelRegiao = new Label("Regiao de Atuacao");
		labelRegiao.setLayoutX(166);
		labelRegiao.setLayoutY(87);
		pane.getChildren().add(labelRegiao);
		
		Label labelTelefone = new Label("Telefone");
		labelTelefone.setLayoutX(166);
		labelTelefone.setLayoutY(115);
		pane.getChildren().add(labelTelefone);
		
		
		
		ScrollPane scr = new ScrollPane();
		scr.setLayoutX(26);
		scr.setLayoutY(200);
		pane.getChildren().add(scr);
		
				
		pane.getChildren().addAll(tfidCorretor,tfNomeCorretor,tfRegiaoCorretor,tfTelefoneCorretor,btnAtualizarCorretor,
				btnBuscarCorretor,btnExcluirCorretor,btnInserirCorretor,btnListarCorretor,taListaCorretor);
		 
		 Scene scene = new Scene(pane,600,400);
		 primaryStage.setTitle("Cadastro de Corretor");
		 primaryStage.setScene(scene);
		 primaryStage.show();
		 		 
	}
	
}




