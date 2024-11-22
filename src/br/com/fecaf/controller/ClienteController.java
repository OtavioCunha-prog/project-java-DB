package br.com.fecaf.controller;

import br.com.fecaf.model.Cliente;
import br.com.fecaf.model.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteController {


    public void listarClientes() {

        Conexao conexao = new Conexao();

        Connection objConnection = conexao.getConnection();

        try {
            Statement statement = objConnection.createStatement();

            String queryConsulta = "Select * from tbl_clients";

            ResultSet resultSet = statement.executeQuery(queryConsulta);


            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String nome = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String cpf = resultSet.getString("cpf");


                System.out.println(id);
                System.out.println(nome);
                System.out.println(phone);
                System.out.println(email);
                System.out.println(cpf);
                System.out.println("/-----------------------------------/");

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Boolean deletarCliente(int id) {
        Conexao conexao = new Conexao();

        Connection objConnection = conexao.getConnection();

        try {

            Statement statement = objConnection.createStatement();
            String queryDelete = "Delete from tbl_clients where id = " + id;
            statement.executeUpdate(queryDelete);

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }


    public Boolean cadastrarCliente(String name, String phone, String email, String cpf) {

        Conexao conexao = new Conexao();
        Connection objConnection = conexao.getConnection();

        try {

            Statement statement = objConnection.createStatement();

            String queryCreate = "Insert into tbl_clients (name, phone, email, cpf) values ('" +
                    name + "','" + phone + "','" + email + "','" + cpf + "')";

            statement.executeUpdate(queryCreate);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

        public Cliente pesquisarCliente(int id) {
            Conexao conexao = new Conexao();
            Connection objConnection = conexao.getConnection();

            try {
                Statement statement = objConnection.createStatement();
                String queryPesquisa = "Select * from tbl_clients where id = " + id;
                ResultSet resultSet = statement.executeQuery(queryPesquisa);

                if (resultSet.next()) {
                    int clienteId = resultSet.getInt("id");
                    String nome = resultSet.getString("name");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    String cpf = resultSet.getString("cpf");

                    return new Cliente(clienteId, nome, phone, email, cpf);
                } else {
                    System.out.println("Cliente não encontrado!");
                    return null;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }