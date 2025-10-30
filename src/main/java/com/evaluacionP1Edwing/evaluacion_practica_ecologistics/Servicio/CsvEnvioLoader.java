package com.evaluacionP1Edwing.evaluacion_practica_ecologistics.Servicio;

import com.evaluacionP1Edwing.evaluacion_practica_ecologistics.Modelo.Envio;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvEnvioLoader implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(CsvEnvioLoader.class);
    private final EnvioService servicio;

    @Value("classpath:envios.csv")
    private Resource csvResource;

    public CsvEnvioLoader(EnvioService servicio) {
        this.servicio = servicio;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!csvResource.exists()) {
            log.warn("No se encontró envios.csv en resources. Se iniciará sin datos.");
            return;
        }
        List<Envio> cargados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(csvResource.getInputStream(), StandardCharsets.UTF_8))) {

            CSVParser parser = CSVFormat.DEFAULT.builder()
                    .setHeader("id_envio","cliente","direccion","estado")
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(reader);

            for (CSVRecord r : parser) {
                String id = r.get("id_envio").trim();
                String cliente = r.get("cliente").trim();
                String direccion = r.get("direccion").trim();
                String estado = r.get("estado").trim();
                cargados.add(new Envio(id, cliente, direccion, estado));
            }
        }
        servicio.saveAll(cargados);
        log.info("Archivo cargado con {} registros.", cargados.size());
        log.info("Datos transformados a formato JSON (expuestos vía API).");
    }
}
