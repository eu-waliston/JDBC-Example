package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ListarLivros {

    public static void main(String[] args) {

        try {
            //titulo preco id
            System.out.println("Abrindo conexão...");

            Connection conexao = ConnectionFactory.createConnection();

            String sql = "SELECT * FROM Livro";

            PreparedStatement comando = conexao.prepareStatement(sql);

            System.out.println("Exectando comando...");
            ResultSet resultado = comando.executeQuery();

            System.out.println("Resultados encontrados:\n");
            while(resultado.next()){
                System.out.printf("%d : %s - R$%s\n",
                resultado.getInt("id"),
                resultado.getString("titulo"),
                resultado.getInt("preco"));
            }

            System.out.println("\nFechando conexão...");
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
