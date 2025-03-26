# Mac Store API

API para la gestión de clientes, productos y órdenes en la tienda Mac.

## Requisitos Previos
- Java 17+
- Spring Boot
- Base de datos (H2)
- Postman (opcional)

## Iniciar la Aplicación
```sh
mvn spring-boot:run
```
Por defecto, la API estará disponible en `http://localhost:8080/`.

---

## Endpoints y Ejemplos de Uso

### Clientes

#### Obtener todos los clientes
- **Método:** `GET`
- **URL:** `/customers`

```sh
curl -X GET http://localhost:8080/customers
```

#### Crear un cliente
- **Método:** `POST`
- **URL:** `/customers`
- **Body (JSON):**
```json
{
  "name": "Juan Pérez",
  "email": "juan@example.com"
}
```

```sh
curl -X POST http://localhost:8080/customers \
     -H "Content-Type: application/json" \
     -d '{"name":"Juan Pérez","email":"juan@example.com"}'
```

---

### Productos

#### Obtener todos los productos
- **Método:** `GET`
- **URL:** `/products`

```sh
curl -X GET http://localhost:8080/products
```

#### Crear un producto
- **Método:** `POST`
- **URL:** `/products`
- **Body (JSON):**
```json
{
  "name": "iPhone 14",
  "price": 1200.00
}
```

```sh
curl -X POST http://localhost:8080/products \
     -H "Content-Type: application/json" \
     -d '{"name":"iPhone 14","price":1200.00}'
```

---

### Órdenes

#### Crear una orden
- **Método:** `POST`
- **URL:** `/orders`
- **Body (JSON):**
```json
{
  "customerId": 1,
  "products": [1, 2]
}
```

```sh
curl -X POST http://localhost:8080/orders \
     -H "Content-Type: application/json" \
     -d '{"customerId":1,"products":[1,2]}'
```