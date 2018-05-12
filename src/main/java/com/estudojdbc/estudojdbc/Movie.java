package com.estudojdbc.estudojdbc;

/**
 *
 * @author peter
 */
public class Movie {
    
    /**
     * @var Integer
     */
    private Integer id;
    
    /**
     * @param String
     */
    private String name;
    
    Movie(){}
    
    /**
     * 
     * @param id
     * @param name 
     */
    Movie(Integer id, String name){
        this.name = name;
        this.id = id;
    }

    Movie(String name) {
        this.name = name;
    }

    /**
     * 
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return String 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
