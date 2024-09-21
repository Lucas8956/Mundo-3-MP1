package cadastropoo.model;

import java.util.ArrayList;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class PessoaFisicaRepo {
	//Atributos
	private ArrayList<PessoaFisica> lista;
	
	//Construtor
	public PessoaFisicaRepo() {
		this.lista = new ArrayList<PessoaFisica>();
	}
	
	//Métodos
	public void inserir(PessoaFisica pessoa) {
		lista.add(pessoa);
		//System.out.println("Pessoa Adicionada");
	}
	
	public void alterar(int id, PessoaFisica pessoa) {
		int quantidade = this.lista.size();
		this.excluir(id);
		if(this.lista.size() == quantidade - 1) {
			this.inserir(pessoa);
			System.out.println("Pessoa Alterada");
		}
	}
	
	public void excluir(int id) {
		boolean operacao = false;
		for(int i = 0; i < this.lista.size(); i++) {
			if(this.lista.get(i).get_id() == id) {
				this.lista.remove(i);
				operacao = true;
				System.out.println("Pessoa Removida");
				break;
			}
		}
		if(!operacao) {
			System.out.println("Pessoa não encontrada");
		}
	}
	
	public PessoaFisica obter(int id) {
		for(PessoaFisica pessoa : this.lista) {
			if(pessoa.get_id() == id) {
				return pessoa;
			}
		}
		return new PessoaFisica();
	}
	
	public ArrayList<PessoaFisica> obterTodos(){
		return this.lista;
	}
	
	public void persistir(String arquivo_nome) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo_nome));
		out.writeObject(this.lista);
		out.close();
		System.out.println("Dados de Pessoas Físicas Armazenados");
	}
	
	public void recuperar(String arquivo_nome) throws IOException, ClassNotFoundException{
		ObjectInputStream in =  new ObjectInputStream(new FileInputStream(arquivo_nome));
		this.lista = (ArrayList<PessoaFisica>)in.readObject();
		in.close();
		System.out.println("Dados de Pessoas Físicas Recuperados");
	}
}