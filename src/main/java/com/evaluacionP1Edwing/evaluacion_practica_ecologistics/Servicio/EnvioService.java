package com.evaluacionP1Edwing.evaluacion_practica_ecologistics.Servicio;
import com.evaluacionP1Edwing.evaluacion_practica_ecologistics.Modelo.Envio;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EnvioService {
    private final Map<String, Envio> store = new ConcurrentHashMap<>();

    public List<Envio> findAll() { return new ArrayList<>(store.values()); }
    public Optional<Envio> findById(String id) { return Optional.ofNullable(store.get(id)); }

    public Envio save(Envio e) {
        if (e.getId() == null || e.getId().isBlank()) {
            e.setId(UUID.randomUUID().toString());
        }
        store.put(e.getId(), e);
        return e;
    }

    public void saveAll(Collection<Envio> envios) {
        for (Envio e : envios) save(e);
    }

    public int size() { return store.size(); }
}
