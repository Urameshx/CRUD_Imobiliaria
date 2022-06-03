package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Corretor;


public class CorretorDAO implements ICorretorDAO {
	private final static String JDBC_CLASS = "org.mariadb.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mariadb://localhost:3306/imob";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASS = "123456"; //"alunofatec";
    private Connection conn;
    
    public CorretorDAO() {
        try {
            Class.forName(JDBC_CLASS);
            System.out.println("Biblioteca importada");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            System.out.println("Conectado com o banco de dados");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	
    @Override
	public void insereCorretor(Corretor c) throws SQLException {
		String sql = "INSERT INTO corretor (creci, nome, regiao, telefone)";
		sql += "VALUES (?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, c.getCreci());
		stmt.setString(2, c.getNome());
		stmt.setString(3, c.getRegiao());
		stmt.setString(4,c.getTelefone());
		stmt.executeUpdate();
		stmt.close();
	}
	
	@Override
	public void atualizaCorretor(Corretor c) throws SQLException {
		String sql = "UPDATE corretor SET nome = ?, regiao = ?, telefone = ? WHERE creci = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getRegiao());
		stmt.setString(3, c.getTelefone());
		stmt.setString(4, c.getCreci());
		stmt.executeUpdate();
		stmt.close();
	}
	@Override
	public void excluiCorretor(Corretor c) throws SQLException {
		String sql = "DELETE FROM `imob`.`corretor` WHERE creci = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, c.getCreci());
		stmt.executeUpdate();
		stmt.close();
	}
	@Override
	public Corretor buscarCorretor(Corretor c) throws SQLException {
		String sql = "SELECT creci, nome, regiao, telefone FROM corretor WHERE creci = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, c.getCreci());
		
		int cont = 0;
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			c.setCreci(rs.getString("creci"));
			c.setNome(rs.getString("nome"));
			c.setRegiao(rs.getString("regiao"));
			c.setTelefone(rs.getString("telefone"));
			cont++;
		}
		
		if (cont == 0) {
			c = new Corretor();
		}
		
		rs.close();
		stmt.close();
		return c;
	}
	@Override
	public List<Corretor> buscarCorretores() throws SQLException {
		String sql = "SELECT creci, nome, regiao,telefone FROM corretor";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		int cont = 0;
		ResultSet rs = stmt.executeQuery();
		
		List<Corretor> listaCorretores = new ArrayList<Corretor>();
		
		while (rs.next()) {
			Corretor c = new Corretor();
			c.setCreci(rs.getString("creci"));
			c.setNome(rs.getString("nome"));
			c.setRegiao(rs.getString("regiao"));
			c.setTelefone(rs.getString("telefone"));
			
			listaCorretores.add(c);
		}
		
		rs.close();
		stmt.close();
		
		return listaCorretores;
	}
}


