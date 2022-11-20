package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RemoverEditoras {

    public static void main(String[] args) {

        //TODO - Implemente a remoção de editoras pelo id
        //TODO - Implemente a alteração dos dados das editoras pelo id

        try {
            System.out.println("Abrindo conexão");
            Scanner scanner = new Scanner(System.in);

            Connection conexao = ConnectionFactory.createConnection();
            System.out.println("Digte o ID da editora que pretende remover: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM Editora WHERE id = " + id;

            PreparedStatement comando = conexao . prepareStatement ( sql );

            System . out . println ( " Executando comando ... " );
            comando . execute () ;
            System . out . println ( " Fechando conexão ... " );
            conexao . close () ;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
