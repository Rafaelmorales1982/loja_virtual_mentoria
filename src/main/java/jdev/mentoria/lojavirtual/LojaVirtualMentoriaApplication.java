package jdev.mentoria.lojavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
/*
 @EntityScan é uma ferramenta essencial para configurar o Spring Data JPA e mapear as entidades corretamente 
 no seu projeto, garantindo que as tabelas sejam criadas e que você possa realizar operações no banco de dados.
  */


@EntityScan(basePackages = "jdev.mentoria.lojavirtual.model")
public class LojaVirtualMentoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualMentoriaApplication.class, args);
	}

}
