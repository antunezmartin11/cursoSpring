package com.sistema.examens;

import com.sistema.examens.entidades.*;
import com.sistema.examens.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaExamenBackendApplication implements CommandLineRunner {

    @Autowired
    private UsuarioServicio usuarioServicio;

    public static void main(String[] args) {
        SpringApplication.run(SistemaExamenBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
