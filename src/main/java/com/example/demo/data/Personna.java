package com.example.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Personna {

    @Id @GeneratedValue
    private  long id;
    private String name;
    private  String email;

    public  Long getPersonnaId(){
        return id;
    }
}
