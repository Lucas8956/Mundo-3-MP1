package cadastropoo;

import cadastropoo.model.*;

//Parte 1
/*
public class Principal {

	public static void main(String[] args) {
		PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
		repo1.inserir(new PessoaFisica(1, "Ana", "111.111.111-11", 25));
		repo1.inserir(new PessoaFisica(2, "Carlos", "222.222.222-22", 52));
		try {
			repo1.persistir("arquivoTestePessoaFisica");
		} catch (Exception e) {
			System.out.println("Não foi possível salvar arquivo.");
		}
		PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
		try {
			repo2.recuperar("arquivoTestePessoaFisica");
			for(PessoaFisica pessoa : repo2.obterTodos()) {
				pessoa.exibir();
			}
		} catch (Exception e) {
			System.out.println("Arquivo não encontrado.");
		}
		PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
		repo3.inserir(new PessoaJuridica(3, "XPTO Sales", "333.333.333.333-33"));
		repo3.inserir(new PessoaJuridica(4, "XPTO Solutions", "444.444.444.444-44"));
		try {
			repo3.persistir("arquivoTestePessoaJuridica");
		} catch (Exception e) {
			System.out.println("Não foi possível salvar arquivo.");
		}
		PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
		try {
			repo4.recuperar("arquivoTestePessoaJuridica");
			for(PessoaJuridica pessoa : repo4.obterTodos()) {
				pessoa.exibir();
			}
		} catch (Exception e) {
			System.out.println("Arquivo não encontrado.");
		}
	}
}
*/

//Parte 2
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		boolean ligado = true;
		Scanner teclado = new Scanner(System.in);
		PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
		PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
		
		while(ligado) {
			//Display menu
			System.out.println("====================================================================");
			System.out.println("1 - Incluir Pessoa");
			System.out.println("2 - Alterar Pessoa");
			System.out.println("3 - Excluir Pessoa");
			System.out.println("4 - Buscar pelo Id");
			System.out.println("5 - Exibir Todos");
			System.out.println("6 - Persistir Dados");
			System.out.println("7 - Recuperar Dados");
			System.out.println("0 - Finalizar Programa");
			System.out.println("====================================================================");
			
			//Seguindo instruções
			int instrucao1 = -1;
			String tipo = "?";
			
			try {
				instrucao1 = Integer.parseInt(teclado.next());
				} 
			catch (Exception e) {
					System.out.println("Entrada inválida.");
				}
			if(instrucao1 > 0 & instrucao1 < 8) {
				while(true) {
					System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
					tipo = teclado.next();
					if(tipo.equals("F") | tipo.equals("j")) {
						break;
					}
					else {
						System.out.println("Não entendi, por favor tente novamente.");
					}
				}
			}
			
			switch(instrucao1) {
			case 1:
				while(true) {
					System.out.println("Digite o ID da pessoa: ");
					try {
						int id = Integer.parseInt(teclado.next());
						System.out.println("Insira os dados... ");
						System.out.println("Nome: ");
						String nome = teclado.next();
						if(tipo.equals("F")) {
							System.out.println("CPF: ");
							String cpf = teclado.next();
							System.out.println("Idade: ");
							int idade = Integer.parseInt(teclado.next());
							repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
							break;
						}
						else {
							System.out.println("CNPJ: ");
							String cnpj = teclado.next();
							repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
							break;
						}
					}
					catch (Exception e) {
						System.out.println("Entrada inválida, por favor tente novamente.");
					}
				}
				break;
				
			case 2:
				while(true) {
					System.out.println("Digite o ID da pessoa: ");
					try {
						int id = Integer.parseInt(teclado.next());
						System.out.println("Insira os novos dados... ");
						System.out.println("Nome: ");
						String nome = teclado.next();
						if(tipo.equals("F")) {
							System.out.println("CPF: ");
							String cpf = teclado.next();
							System.out.println("Idade: ");
							int idade = Integer.parseInt(teclado.next());
							repoFisica.alterar(id, new PessoaFisica(id, nome, cpf, idade));
							break;
						}
						else {
							System.out.println("CNPJ: ");
							String cnpj = teclado.next();
							repoJuridica.alterar(id, new PessoaJuridica(id, nome, cnpj));
							break;
						}
					}
					catch (Exception e) {
						System.out.println("Entrada inválida, por favor tente novamente.");
					}
				}
				break;
				
			case 3:
				while(true) {
					System.out.println("Digite o ID da pessoa: ");
					try {
						int id = Integer.parseInt(teclado.next());
						if(tipo.equals("F")) {
							repoFisica.excluir(id);
							break;
						}
						else {
							repoJuridica.excluir(id);
							break;
						}
					}
					catch (Exception e) {
						System.out.println("Entrada inválida, por favor tente novamente.");
					}
				}
				break;
				
			case 4:
				while(true) {
					System.out.println("Digite o ID da pessoa: ");
					try {
						int id = Integer.parseInt(teclado.next());
						if(tipo.equals("F")) {
							repoFisica.obter(id).exibir();
							break;
						}
						else {
							repoJuridica.obter(id).exibir();
							break;
						}
					}
					catch (Exception e) {
						System.out.println("Entrada inválida, por favor tente novamente.");
					}
				}
				break;
				
			case 5:
				if(tipo.equals("F")) {
					for(PessoaFisica pessoa : repoFisica.obterTodos()) {
						pessoa.exibir();
					}
				}
				else {
					for(PessoaJuridica pessoa : repoJuridica.obterTodos()) {
						pessoa.exibir();
					}
				}
				break;
				
			case 6:
				System.out.println("Digite o nome do arquivo: ");
				String prefixo6 = teclado.next();
				try {
					if(tipo.equals("F")) {
						repoFisica.persistir(prefixo6 + ".fisica.bin");
					}
					else {
						repoJuridica.persistir(prefixo6 + ".juridica.bin");
					}
				}
				catch (Exception e) {
					System.out.println("Não foi possível salvar arquivo.");
				}
				break;
				
			case 7:
				System.out.println("Digite o nome do arquivo: ");
				String prefixo7 = teclado.next();
				try {
					if(tipo.equals("F")) {
						repoFisica.recuperar(prefixo7 + ".fisica.bin");
					}
					else {
						repoJuridica.recuperar(prefixo7 + ".juridica.bin");
					}
				}
				catch (Exception e) {
					System.out.println("Não foi possível encontrar o arquivo.");
				}
				break;
				
			case 0:
				ligado = false;
				System.out.println("Fechando programa.");
				break;
				
			default:
				System.out.println("Por favor tente novamente.");
				break;
			}
		}
		teclado.close();
	}
}