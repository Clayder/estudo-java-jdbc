
package com.estudojdbc.estudojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peter
 */
public class MovieDAO {
    private Connection connection = null;
    private final String TABELA = "movie";
    private PreparedStatement statement = null;
            
    
    public MovieDAO() throws SQLException{
        connection = new ConnectionFactory().getConnection();
    }
    
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public List<Movie> findAll() throws SQLException{
        String query = "SELECT * FROM " + TABELA;
        List<Movie> movies= new ArrayList<>();
        statement = connection.prepareStatement(query);
        ResultSet res = statement.executeQuery();
        
        while(res.next()){
            movies.add(new Movie(res.getInt("id"), res.getString("name")));
        }
        
        return movies;
    }
    
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public Movie findById(Integer id) throws SQLException{
        String query = "SELECT * FROM " + TABELA + " WHERE (id) = ?" ;
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet res = statement.executeQuery();
        
        Movie movie = null;
        
        while(res.next()){
            movie = new Movie(res.getInt("id"), res.getString("name"));
        }
        return movie;
    }
    
    /**
     * 
     * @param movie
     * @throws SQLException 
     */
    public void insert(Movie movie) throws SQLException{
        String query = "INSERT INTO "+ TABELA + " (name) VALUE (?)";
        
        statement = connection.prepareStatement(query);
        statement.setString(1, movie.getName());
        statement.execute();
    }
    
    /**
     * 
     * @param movieOld
     * @param movieNew
     * @throws SQLException 
     */
    public void update(Movie movieOld, Movie movieNew) throws SQLException{
        String query = "UPDATE " + TABELA + " SET name = ? WHERE id = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, movieNew.getName());
        statement.setInt(2, movieNew.getId());
        statement.execute();
    }
    
    /**
     * 
     * @param movie
     * @throws SQLException 
     */
    public void remove(Movie movie) throws SQLException{
        String query = "DELETE FROM " + TABELA + " WHERE id = ?";
        
        statement = connection.prepareStatement(query);
        statement.setInt(1, movie.getId());
        statement.execute();
    }
}
