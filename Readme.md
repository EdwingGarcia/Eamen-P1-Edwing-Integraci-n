# EcoLogistics – Entrega de Evaluación

Prototipo en **Spring Boot (Java 17)** que cumple el contrato:
- Lectura de **CSV** (File Transfer)
- **Transformación a JSON**
- **API REST** (GET/POST)
- **OpenAPI/Swagger**
- **Ejecución reproducible**
- **Colección Postman/Newman**

## Requisitos
- Java 17
- Maven 3.9+
- (Opcional) Docker

## Ejecutar (script)
```bash
./run.sh
# En Windows: run.bat
```
o manualmente:
```bash
mvn clean spring-boot:run
```

## Endpoints
- `GET /envios`
- `GET /envios/{id}`
- `POST /envios`

## Swagger / OpenAPI
- Swagger UI: `http://localhost:8081/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8081/v3/api-docs`
- Archivo de contrato estático: `openapi.yaml` (raíz del repo)

## Pruebas con Postman / Newman
- Importa `PruebasEndpointsColeccion.json` en Postman 
> Asegúrate de tener la app corriendo antes de ejecutar la colección.


## Datos de ejemplo
- `src/main/resources/envios.csv` se carga automáticamente al iniciar y populará la memoria.
- Ejemplos iniciales incluyen IDs `001`, `002`, `003`.

## Stack declarado
- Lenguaje: **Java 17**
- Framework: **Spring Boot 3.5.7**
- Build: **Maven 3.9+**
- Doc: **springdoc-openapi 2.5.0**
