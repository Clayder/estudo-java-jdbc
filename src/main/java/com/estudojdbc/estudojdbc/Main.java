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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author peter
 */
public class Main {

    private static Connection CONNECTION = null;
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
        CONNECTION = new ConnectionFactory().getConnection();
        int choice = scanner.nextInt();
        MovieDAO dao = new MovieDAO();

        switch (choice) {
            case 1:
                System.out.println("1 - List movies");
                ArrayList<Movie> data = (ArrayList<Movie>) dao.findAll();
                for (Movie movie : data) {
                    System.out.println("Id: " + movie.getId());
                    System.out.println("Name: " + movie.getName());
                }
                break;
            case 2:
                System.out.println("2 - Enter name");
                String name = scanner.next();
                dao.insert(new Movie(name));
                break;
            case 3:
                System.out.println("Enter movie id: ");
                Integer id = scanner.nextInt();
                
                Movie movieExists = dao.findById(id);
                
                if(movieExists != null){
                    System.out.println("Enter nwe movie name: ");
                    String movieName = scanner.next();
                    Movie movieNew = new Movie(movieExists.getId(), movieName);
                    dao.update(movieExists, movieNew);
                }else{
                    System.out.println("Does not exists");
                }

                break;
            case 4:
                System.out.println("Enter movie id: ");
                Integer idDelete = scanner.nextInt();
                
                Movie movieDelete = dao.findById(idDelete);
                
                if(movieDelete != null){
                    dao.remove(movieDelete);
                }else{
                    System.out.println("Does not exists");
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }

    }

}
