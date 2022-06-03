package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Imovel;

public class ImovelDAO implements IImovelDAO {
	private final static String JDBC_CLASS = "org.mariadb.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mariadb://localhost:3306/imob";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASS = "123456"; //"alunofatec";
    private Connection c;
    
    public ImovelDAO() {
        try {
            Class.forName(JDBC_CLASS);
            System.out.println("Biblioteca importada");
            c = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            System.out.println("Conectado com o banco de dados");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	
    @Override
	public void insereImovel(Imovel i) throws SQLException {
		String sql = "INSERT INTO imovel (codigo, endereco, bairro, cep)";
		sql += "VALUES (?,?,?,?)";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, i.getCodigo());
		stmt.setString(2, i.getEndereco());
		stmt.setString(3, i.getBairro());
		stmt.setString(4, i.getCep());
		stmt.executeUpdate();
		stmt.close();
	}
	
	@Override
	public void atualizaImovel(Imovel i) throws SQLException {
		String sql = "UPDATE imovel SET endereco = ?, bairro = ?, cep = ? WHERE codigo = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, i.getEndereco());
		stmt.setString(2, i.getBairro());
		stmt.setString(3, i.getCep());
		stmt.setInt(4, i.getCodigo());
		stmt.executeUpdate();
		stmt.close();
	}
	@Override
	public void excluiImovel(Imovel i) throws SQLException {
		String sql = "DELETE FROM `imob`.`imovel` WHERE codigo = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, i.getCodigo());
		stmt.executeUpdate();
		stmt.close();
	}
	@Override
	public Imovel buscarImovel(Imovel i) throws SQLException {
		String sql = "SELECT codigo, endereco, bairro, cep FROM imovel WHERE codigo = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, i.getCodigo());
		
		int cont = 0;
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			i.setEndereco(rs.getString("endereco"));
			i.setBairro(rs.getString("bairro"));
			i.setCep(rs.getString("cep"));
			cont++;
		}
		
		if (cont == 0) {
			i = new Imovel();
		}
		
		rs.close();
		stmt.close();
		return i;
	}
	@Override
	public List<Imovel> buscarImoveis() throws SQLException {
		String sql = "SELECT codigo, endereco, bairro, cep FROM imovel";
		PreparedStatement stmt = c.prepareStatement(sql);
		
		int cont = 0;
		ResultSet rs = stmt.executeQuery();
		
		List<Imovel> listaImoveis = new ArrayList<Imovel>();
		
		while (rs.next()) {
			Imovel i = new Imovel();
			i.setCodigo(rs.getInt("codigo"));
			i.setEndereco(rs.getString("endereco"));
			i.setBairro(rs.getString("bairro"));
			i.setCep(rs.getString("cep"));
			
			listaImoveis.add(i);
		}
		
		rs.close();
		stmt.close();
		
		return listaImoveis;
	}
}


