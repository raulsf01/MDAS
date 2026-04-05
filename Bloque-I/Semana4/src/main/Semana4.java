package main;

public class Semana4 {
    public static void main(String[] args) {
        IProveedor empA = new EmpresaA();
        IProveedor empB = new EmpresaB();
        IProveedor empC = new EmpresaC();

        // Configuración: Sofás (Empresas A y C) 
        SistemaCatalogo catSofas = new CatalogoSofas();
        catSofas.añadirProveedor(empA);
        catSofas.añadirProveedor(empC);

        // Configuración: Mesas (Empresas B y C) [cite: 162]
        SistemaCatalogo catMesas = new CatalogoMesas();
        catMesas.añadirProveedor(empB);
        catMesas.añadirProveedor(empC);

        System.out.println("--- MESAS: ORDEN PRECIO ---");
        catMesas.buscarPorPrecio().forEach(System.out::println);

        System.out.println("\n--- GENERAL (A+B+C): STOCK AGREGADO ---");
        SistemaCatalogo catGeneral = new CatalogoSofas(); 
        catGeneral.añadirProveedor(empA);
        catGeneral.añadirProveedor(empB);
        catGeneral.añadirProveedor(empC);
        
        // Llamada correcta al método 
        catGeneral.buscarStockPorUnidades().forEach(System.out::println);
    }
}