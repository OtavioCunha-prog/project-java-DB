package br.com.fecaf.controller;

import br.com.fecaf.model.Cliente;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public void executarMenu() {
        boolean exit = false;
        ClienteController clienteController = new ClienteController();

        while (!exit) {
            System.out.println("/--------------------------------/");
            System.out.println("/-             Menu             -/");
            System.out.println("/--------------------------------/");
            System.out.println("/ 1 - Consultar Clientes        -/");
            System.out.println("/ 2 - Cadastrar Cliente         -/");
            System.out.println("/ 3 - Deletar Clientes          -/");
            System.out.println("/ 4 - Pesquisar Cliente         -/");
            System.out.println("/ 5 - Sair                      -/");
            System.out.println("/--------------------------------/");

            int userOption = scanner.nextInt();
            scanner.nextLine();

            switch (userOption) {
                case 1:
                    System.out.println("/- Lista Clientes -/");
                    clienteController.listarClientes();
                    break;
                case 2:
                    System.out.println("/- Cadastrar Cliente -/");
                    System.out.print("Informe o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe o telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Informe o email: ");
                    String email = scanner.nextLine();
                    System.out.println("Informe o CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.println("/----------------------/");

                    boolean validaCadastro = clienteController.cadastrarCliente(nome, telefone, email, cpf);

                    if (validaCadastro) {
                        System.out.println("Cliente Cadastrado com Sucesso!");
                    } else {
                        System.out.println("Falhou com Sucesso!");
                    }
                    break;
                case 3:
                    clienteController.listarClientes();
                    System.out.print("Informe o id que deseja deletar: ");
                    int idDelete = scanner.nextInt();
                    scanner.nextLine();

                    boolean validaDelete = clienteController.deletarCliente(idDelete);

                    if (validaDelete) {
                        System.out.println("Cliente deletado com Sucesso!");
                    } else {
                        System.out.println("Erro ao excluir cliente!");
                    }
                    break;
                case 4:
                    System.out.print("Informe o id do cliente: ");
                    int idPesquisa = scanner.nextInt();
                    scanner.nextLine();
                    Cliente cliente = clienteController.pesquisarCliente(idPesquisa);

                    if (cliente != null) {
                        System.out.println("ID: " + cliente.getId());
                        System.out.println("Nome: " + cliente.getName());
                        System.out.println("Telefone: " + cliente.getPhone());
                        System.out.println("Email: " + cliente.getEmail());
                        System.out.println("CPF: " + cliente.getCpf());
                        System.out.println("/------------------------------/");
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;
                case 5:
                    System.out.println("Saindo ...");
                    exit = true;
                    break;
                default:
                    System.out.println("Escolha uma opção válida!");
            }
        }
    }
}
