package br.com.fecaf.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private String servidor, banco, user, password;
    public Connection conexao;

    public Conexao () {
        this.servidor = "localhost";
        this.banco = "db_agency";
        this.user = "aluno";
        this.password = "toor";
    }

    public boolean connectDrive() {

        try {

            this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/" + this.banco,
                    this.user, this.password);

            return true;

        } catch (Exception e) {
            System.out.println(e);

            return false;
        }
    }

    public Connection getConnection() {
        boolean validaConexao = connectDrive();

        if (validaConexao) {
            return this.conexao;
        }
        return null;
    }
}

