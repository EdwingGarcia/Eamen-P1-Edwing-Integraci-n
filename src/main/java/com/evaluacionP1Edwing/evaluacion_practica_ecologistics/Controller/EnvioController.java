package com.evaluacionP1Edwing.evaluacion_practica_ecologistics.Controller;
import com.evaluacionP1Edwing.evaluacion_practica_ecologistics.Modelo.Envio;
import com.evaluacionP1Edwing.evaluacion_practica_ecologistics.Servicio.EnvioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/envios")
@Tag(name = "Envios", description = "API para gestionar envíos")
public class EnvioController {

    private static final Logger log = LoggerFactory.getLogger(EnvioController.class);
    private final EnvioService servicio;

    public EnvioController(EnvioService servicio) { this.servicio = servicio; }

    @GetMapping
    @Operation(summary = "Listar envíos")
    public List<Envio> getAll() {
        log.info("GET /envios - total actuales: {}", servicio.size());
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener envío por ID")
    public ResponseEntity<Envio> getById(@PathVariable String id) {
        return servicio.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear/registrar un nuevo envío")
    public ResponseEntity<Envio> create(@RequestBody Envio nuevo) {
        Envio guardado = servicio.save(nuevo);
        log.info("POST /envios - creado {}", guardado.getId());
        return ResponseEntity.created(URI.create("/envios/" + guardado.getId()))
                .body(guardado);
    }
}
