package main;

import java.util.*;
import java.util.stream.Collectors;

abstract class SistemaCatalogo {
    // El "Puente": Referencia a uno o varios proveedores 
    protected List<IProveedor> proveedores = new ArrayList<>();

    public void añadirProveedor(IProveedor p) {
        proveedores.add(p);
    }

    // Método de búsqueda (a): Ordenado por precio de menor a mayor 
    public List<Producto> buscarPorPrecio() {
        return proveedores.stream()
            .flatMap(p -> p.obtenerCatalogo().stream())
            .filter(p -> p.stock > 0) // Solo en stock 
            .sorted(Comparator.comparingDouble(p -> p.precio))
            .collect(Collectors.toList());
    }

    // Método de búsqueda (b): Ordenado por unidades y agregando duplicados 
    public List<Producto> buscarStockPorUnidades() {
        Map<String, Producto> mapaAgregado = new HashMap<>();

        for (IProveedor prov : proveedores) {
            for (Producto p : prov.obtenerCatalogo()) {
                if (p.stock > 0) {
                    if (mapaAgregado.containsKey(p.nombre)) {
                        // Agregamos las unidades del mismo producto de diferentes empresas 
                        Producto existente = mapaAgregado.get(p.nombre);
                        existente.stock += p.stock;
                    } else {
                        // Creamos una copia para no alterar el catálogo original del proveedor
                        mapaAgregado.put(p.nombre, new Producto(p.nombre, p.precio, p.stock));
                    }
                }
            }
        }

        return mapaAgregado.values().stream()
            .sorted((p1, p2) -> Integer.compare(p2.stock, p1.stock)) // De mayor a menor 
            .collect(Collectors.toList());
    }
}

// Abstracciones refinadas para tipos específicos de muebles 
class CatalogoSofas extends SistemaCatalogo {
    public void buscarPorPlazas(int n) {
        System.out.println("Filtrando sofás de " + n + " plazas..."); // Criterio específico 
    }
}

class CatalogoMesas extends SistemaCatalogo {
    public void buscarPorDimensiones(String d) {
        System.out.println("Filtrando mesas con dimensiones: " + d); // Criterio específico 
    }
}