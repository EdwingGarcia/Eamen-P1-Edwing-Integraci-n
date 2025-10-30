package com.evaluacionP1Edwing.evaluacion_practica_ecologistics;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.evaluacionP1Edwing.evaluacion_practica_ecologistics"
		}
)
public class EvaluacionPracticaEcologisticsApplication {
	public static void main(String[] args) {
		SpringApplication.run(EvaluacionPracticaEcologisticsApplication.class, args);
	}
}