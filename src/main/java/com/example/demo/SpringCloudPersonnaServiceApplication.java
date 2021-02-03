package com.example.demo;


import com.example.demo.data.Personna;
import com.example.demo.data.PersonnaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudPersonnaServiceApplication  implements CommandLineRunner {

    @Autowired
    PersonnaRepo personnaRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPersonnaServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception
    {

        personnaRepo.save( new Personna(1,"azizi","azizi.zzkaria@gmail.com"));
        personnaRepo.save( new Personna(2,"hamiba","hamiba@gmail.com"));
        personnaRepo.save( new Personna(3,"noura","noura@gmail.com"));
        personnaRepo.save( new Personna(4,"salam","salam@gmail.com"));
        personnaRepo.save( new Personna(5,"hind","hind@gmail.com"));


    }
}
