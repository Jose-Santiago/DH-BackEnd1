package com.digitalhouse.ClinicaOdontologica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {

		// Especificar el archivo de configuración de Log4j 2
		//System.setProperty("log4j.configurationFile","classpath:log4j2.xml");
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
	}

	/*@PostConstruct		// funciona despues de que la aplicacion fue creada y permite inicialiar cosas
	public void inicializarBD(){
		BDH2.sqlCrearTabla();
	}*/

	//despues de configurar devtools el postconstructor dejo de funcionar, pero el CommandLiner se ejecuta despues de que la app ha sido cargada
	//asegura que el codigo se ejecute cada vez que la aplicacion arranca por el devtools

    // @Bean
    // public CommandLineRunner inicializar(){
    // 	return args -> {
    // 		BDH2.sqlCrearTabla();
    // 	};
    // }

}
