/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estudojdbc.estudojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author peter
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        System.out.println("--------- Menu ---------");
        System.out.println("1 - List movies");
        System.out.println("2 - Create new movie");
        System.out.println("3 - Update a movie");
        System.out.println("4 - Delete a movie");
        System.out.println("--------- Menu ---------");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Opção inválida.");
        }

        SetupDatabase banco = new SetupDatabase();
        banco.start();
    }

}
