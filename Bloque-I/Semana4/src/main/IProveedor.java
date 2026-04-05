package main;

import java.util.ArrayList;
import java.util.List;

// Clase de apoyo con las propiedades requeridas 
class Producto {
    String nombre;
    double precio;
    int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("%s (Precio: %.2f, Stock: %d)", nombre, precio, stock);
    }
}

// Interfaz de implementación (Capa de Proveedores) 
interface IProveedor {
    List<Producto> obtenerCatalogo(); // Cada proveedor tiene su propio catálogo 
}

// Implementaciones concretas: Simulan empresas suministradoras 
class EmpresaA implements IProveedor { // Vende solo sofás 
    @Override
    public List<Producto> obtenerCatalogo() {
        List<Producto> p = new ArrayList<>();
        p.add(new Producto("Sofá Cama", 450.0, 5));
        p.add(new Producto("Sofá Cuero", 800.0, 2));
        return p;
    }
}

class EmpresaB implements IProveedor { // Vende solo mesas 
    @Override
    public List<Producto> obtenerCatalogo() {
        List<Producto> p = new ArrayList<>();
        p.add(new Producto("Mesa Roble", 120.0, 10));
        p.add(new Producto("Mesa Cristal", 200.0, 0)); // Sin stock 
        return p;
    }
}

class EmpresaC implements IProveedor { // Vende mesas y sofás [cite: 161]
    @Override
    public List<Producto> obtenerCatalogo() {
        List<Producto> p = new ArrayList<>();
        p.add(new Producto("Mesa Roble", 115.0, 3)); // Producto repetido
        p.add(new Producto("Sofá Cama", 460.0, 4));
        return p;
    }
}