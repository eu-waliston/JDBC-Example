package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ListaEditores {
    public static void main(String[] args) {

        try {
            System.out.println("Abrindo conexão...");
            Connection conexao = ConnectionFactory.createConnection();

            String sql = "SELECT * FROM Editora";

            PreparedStatement comando = conexao.prepareStatement(sql);

            System.out.println("Executando comando....");
            ResultSet resultado = comando.executeQuery();

            System.out.println("Resultados encontrados: \n");

            while(resultado.next()) {
                System.out.printf("%d : %s - %s\n",
                resultado.getInt("id"),
                resultado.getString("nome"),
                resultado.getString("email"));
            }

            System.out.println("\nFEchando conexão...");
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
