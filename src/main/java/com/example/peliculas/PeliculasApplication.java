package com.example.peliculas;

import com.example.peliculas.entity.PeliculaEntity;
import com.example.peliculas.repository.PeliculaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeliculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeliculasApplication.class, args);
	}

	@Bean
	CommandLineRunner cargarDatos(PeliculaRepository repository) {
		return args -> {

			if (repository.count() == 0) {

				PeliculaEntity p1 = new PeliculaEntity();
				p1.setTitulo("Carrie");
				p1.setDirector("Kimberly Peirce");
				p1.setAnioLanzamiento(2013);
				p1.setGenero("Terror");
				p1.setSinopsis("Una adolescente con poderes telequinéticos busca vengarse de quienes la maltratan.");

				PeliculaEntity p2 = new PeliculaEntity();
				p2.setTitulo("IT");
				p2.setDirector("Andy Muschietti");
				p2.setAnioLanzamiento(2017);
				p2.setGenero("Terror");
				p2.setSinopsis("Un grupo de niños enfrenta a una entidad maligna que toma la forma de un payaso.");

				PeliculaEntity p3 = new PeliculaEntity();
				p3.setTitulo("La La Land");
				p3.setDirector("Damien Chazelle");
				p3.setAnioLanzamiento(2016);
				p3.setGenero("Musical");
				p3.setSinopsis("Una actriz y un músico luchan por alcanzar sus sueños en Los Ángeles.");

				PeliculaEntity p4 = new PeliculaEntity();
				p4.setTitulo("Las Ventajas de Ser Invisible");
				p4.setDirector("Stephen Chbosky");
				p4.setAnioLanzamiento(2012);
				p4.setGenero("Drama");
				p4.setSinopsis("Un estudiante introvertido descubre la amistad y el crecimiento personal.");

				repository.save(p1);
				repository.save(p2);
				repository.save(p3);
				repository.save(p4);
			}
		};
	}
}