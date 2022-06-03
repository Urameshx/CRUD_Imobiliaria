package controller;

import java.sql.SQLException;

import model.Corretor;

public interface ICorretorController {
	public void inserirCorretor(Corretor c) throws ClassNotFoundException, SQLException;
	public void atualizarCorretor(Corretor c) throws ClassNotFoundException, SQLException;
	public void excluirCorretor(Corretor c) throws ClassNotFoundException, SQLException;
	public void buscarCorretor(Corretor c) throws ClassNotFoundException, SQLException;
	public void buscarCorretores() throws ClassNotFoundException, SQLException;
}
