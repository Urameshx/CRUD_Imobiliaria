package controller;

import java.sql.SQLException;

import model.Imovel;

public interface IImovelController {
	public void inserirImovel(Imovel i) throws ClassNotFoundException, SQLException;
	public void atualizarImovel(Imovel i) throws ClassNotFoundException, SQLException;
	public void excluirImovel(Imovel i) throws ClassNotFoundException, SQLException;
	public void buscarImovel(Imovel i) throws ClassNotFoundException, SQLException;
	public void buscarImoveis() throws ClassNotFoundException, SQLException;
}
