package com.example.main;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MainApplication {

	@Autowired
    private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@PostConstruct
    public void verifyDataSource() throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("✅ Connected to: " + conn.getMetaData().getURL());
        }
    }

}
