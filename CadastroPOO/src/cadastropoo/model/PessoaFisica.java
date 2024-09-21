package cadastropoo.model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable{
	//Atributos
	private String cpf;
	private int idade;
	
	//Construtores
	public PessoaFisica() {}
	
	public PessoaFisica(int id, String nome, String cpf, int idade) {
		super(id, nome);
		this.cpf = cpf;
		this.idade = idade;
	}
	
	//getters e setters
	public void set_cpf(String cpf) {
		this.cpf = cpf;
		System.out.println("CPF Atualizado.");
	}
	public String get_cpf() {
		return this.cpf;
	}
	public void set_idade(int idade) {
		this.idade = idade;
		System.out.println("Idade Atualizado.");
	}
	public int get_idade() {
		return this.idade;
	}
	
	//Métodos
	public void exibir() {
		super.exibir();
		System.out.println("CPF: " + this.cpf);
		System.out.println("Idade: " + this.idade);
	}
}