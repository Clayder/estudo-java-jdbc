
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
    
    public List<Movie> findAll() throws SQLException{
        String query = "SELECT * FROM " + TABELA;
        List<Movie> movies= new ArrayList<>();
        statement = connection.prepareStatement(query);
        ResultSet res = statement.executeQuery();
        
        while(res.next()){
            Movie x = new Movie(1, "qwq");
            movies.add(new Movie(res.getInt("id"), res.getString("name")));
        }
        
        return null;
    }
    
    public void insert(Movie movie){
        
    }
    
    public void update(Movie movieOld, Movie movieNew){
        
    }
    
    public void remove(Movie movie){
        
    }
}
