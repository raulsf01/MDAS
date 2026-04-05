import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prac_1 {

    // --- PRODUCTOS ---
    
    static abstract class ArticuloConsumicion {
        String nombre;
        protected double precioBase;

        public ArticuloConsumicion(String nombre, double precioBase) {
            this.nombre = nombre;
            this.precioBase = precioBase;
        }

        public abstract double getPrecioFinal();
        public abstract String getDetalle();
    }

    // Producto concreto: Plato de Temporada 
    static class PlatoTemporada extends ArticuloConsumicion {
        private double recargo;

        public PlatoTemporada(String nombre, double precioBase, double recargo) {
            super(nombre, precioBase);
            this.recargo = recargo;
        }

        @Override
        public double getPrecioFinal() {
            return precioBase * (1 + recargo); // Aplica el 2% si corresponde
        }

        @Override
        public String getDetalle() {
            return "Plato de Temporada: " + nombre;
        }
    }

    // Producto complejo: Menú 
    static abstract class Menu extends ArticuloConsumicion {
        protected List<String> platosIncluidos = new ArrayList<>();
        protected String acompañamiento;
        protected double recargo;

        public Menu(String nombre, double precioBase, double recargo, String acompañamiento) {
            super(nombre, precioBase);
            this.recargo = recargo;
            this.acompañamiento = acompañamiento;
        }

        @Override
        public double getPrecioFinal() {
            return precioBase * (1 + recargo);
        }
    }

    static class MenuLocal extends Menu {
        public MenuLocal(String acompañamiento) {
            super("Menú Restaurante", 25.0, 0.0, acompañamiento);
            platosIncluidos.add("Entrante");
            platosIncluidos.add("Principal (" + acompañamiento + ")");
            platosIncluidos.add("Postre"); // Incluye postre 
        }

        @Override
        public String getDetalle() {
            return nombre + " [" + String.join(", ", platosIncluidos) + "]";
        }
    }

    static class MenuTakeAway extends Menu {
        public MenuTakeAway(String acompañamiento) {
            super("Menú para Llevar", 25.0, 0.02, acompañamiento); // Recargo 2% 
            platosIncluidos.add("Entrante");
            platosIncluidos.add("Principal (" + acompañamiento + ")");
            // No incluye postre 
        }

        @Override
        public String getDetalle() {
            return nombre + " (Sin Postre) [" + String.join(", ", platosIncluidos) + "]";
        }
    }

    // --- FACTORÍAS (Abstract Factory) ---

    static abstract class FactoriaPedidos {
        public abstract Menu crearMenu(int opcionAcompañamiento);
        public abstract PlatoTemporada crearPlatoTemporada(String nombre, double precio);
    }

    static class FactoriaLocal extends FactoriaPedidos {
        @Override
        public Menu crearMenu(int opcionAcompañamiento) {
            String acompañamiento = (opcionAcompañamiento == 1) ? "Ensalada" : "Patatas"; 
            return new MenuLocal(acompañamiento);
        }

        @Override
        public PlatoTemporada crearPlatoTemporada(String nombre, double precio) {
            return new PlatoTemporada(nombre, precio, 0.0);
        }
    }

    static class FactoriaTakeAway extends FactoriaPedidos {
        @Override
        public Menu crearMenu(int opcionAcompañamiento) {
            String acompañamiento = (opcionAcompañamiento == 1) ? "Ensalada" : "Patatas"; 
            return new MenuTakeAway(acompañamiento);
        }

        @Override
        public PlatoTemporada crearPlatoTemporada(String nombre, double precio) {
            return new PlatoTemporada(nombre, precio, 0.02); // Aplica recargo
        }
    }

    // --- PROGRAMA PRINCIPAL ---

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ArticuloConsumicion> carrito = new ArrayList<>();
        FactoriaPedidos factoria;

        System.out.println("--- SISTEMA DE PEDIDOS ---");
        System.out.println("Seleccione modo de consumo:");
        System.out.println("1. En Restaurante");
        System.out.println("2. Para Llevar (Recargo 2%)");
        
        int modo = sc.nextInt();
        factoria = (modo == 2) ? new FactoriaTakeAway() : new FactoriaLocal(); 

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n¿Qué desea añadir a su pedido?");
            System.out.println("1. Menú Completo");
            System.out.println("2. Plato de Temporada (Sugerencia: Solomillo)");
            System.out.println("3. Finalizar pedido y pagar");
            
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Elija acompañamiento (1. Ensalada / 2. Patatas):");
                    int acomp = sc.nextInt();
                    carrito.add(factoria.crearMenu(acomp));
                    System.out.println(">> Menú añadido.");
                    break;
                case 2:
                    carrito.add(factoria.crearPlatoTemporada("Solomillo Ibérico", 18.0));
                    System.out.println(">> Plato de temporada añadido.");
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        // Resumen Final
        System.out.println("\n===============================");
        System.out.println("       RESUMEN DEL PEDIDO      ");
        System.out.println("===============================");
        double total = 0;
        for (ArticuloConsumicion art : carrito) {
            System.out.printf("- %-45s | $%.2f%n", art.getDetalle(), art.getPrecioFinal());
            total += art.getPrecioFinal();
        }
        System.out.println("-------------------------------");
        System.out.printf("TOTAL A PAGAR: $%.2f%n", total);
        System.out.println("===============================");
        
        System.out.println("¡Gracias por su visita!");
        sc.close();
    }
}