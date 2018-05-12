
package com.estudojdbc.estudojdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author peter
 */
public class MovieDAO {
    private Connection connection = null;
    
    public MovieDAO() throws SQLException{
        connection = new ConnectionFactory().getConnection();
    }
    
    public List<Movie> findAll(){
        return null;
    }
    
    public void insert(Movie movie){
        
    }
    
    public void update(Movie movieOld, Movie movieNew){
        
    }
    
    public void remove(Movie movie){
        
    }
}
