package com.rachana.EcomProductService;

import com.rachana.EcomProductService.service.Inisialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomProductServiceApplication   {

//    @Autowired
//	private Inisialize inisialize;
//


	public static void main(String[] args)
	{
		SpringApplication.run(EcomProductServiceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		inisialize.initialize();
//	}
}
