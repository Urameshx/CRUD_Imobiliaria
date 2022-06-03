package model;

public class Imovel {
	private int codigo;
	private String endereco;
	private String bairro;
	private String cep;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	@Override
	public String toString() {
		return "Imovel [codigo=" + codigo + ", endereco=" + endereco + ", bairro=" + bairro + ", cep=" + cep + "]";
	}
	
}
