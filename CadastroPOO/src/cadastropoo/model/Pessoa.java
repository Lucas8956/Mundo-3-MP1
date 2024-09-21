package cadastropoo.model;

import java.io.Serializable;

public class Pessoa implements Serializable{
	//Atributos
	private int id;
	private String nome;
	
	//Construtores
	public Pessoa() {}
	
	public Pessoa(int id, String nome) {
		this.id  = id;
		this.nome = nome;
	}
	
	//getters e setters
	public void set_id(int id) {
		this.id = id;
		System.out.println("ID Atualizado.");
	}
	public int get_id() {
		return this.id;
	}
	public void set_nome(String nome) {
		this.nome = nome;
		System.out.println("Nome Atualizado.");
	}
	public String get_nome() {
		return this.nome;
	}
	
	//Métodos
	public void exibir() {
		System.out.println("ID: " + this.id);
		System.out.println("Nome: " + this.nome);
	}
}