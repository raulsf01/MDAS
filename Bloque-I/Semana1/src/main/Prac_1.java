import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Prac_1 {

    static class Plato {
        String nombre;
        float precio;

        public Plato(String nombre, float precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
    }

    static abstract class Menu {
        protected List<Plato> platos = new ArrayList<>();
        protected float impuestoAdicional = 0.02f;

        public void asignarPlato(Plato plato) {
            if (platos.size() < 3) {
                platos.add(plato);
            } else {
                System.out.println("Error: Máximo 3 platos.");
            }
        }

        public List<Plato> obtener_platos() {
            return platos;
        }

        public float calcularPrecio(boolean conImpuesto) {
            float total = 0;
            for (Plato p : platos) {
                total += p.precio;
            }
            if (conImpuesto) {
                total += total * impuestoAdicional;
            }
            return total;
        }
    }

    static class Semanal extends Menu {}
    static class Temporada extends Menu {}

    // Movido a static para que el main lo reconozca
    static abstract class FactoriaAbstracta {
        public abstract Menu crearMenuSemanal();
        public abstract Menu crearMenuTemporal();
    }

    static class Restaurante extends FactoriaAbstracta {
        @Override
        public Menu crearMenuSemanal() { return new Semanal(); }
        @Override
        public Menu crearMenuTemporal() { return new Temporada(); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Usamos la factoría
        FactoriaAbstracta factoria = new Restaurante();
        Menu miMenu = factoria.crearMenuSemanal();
        
        // Agregamos platos de prueba
        miMenu.asignarPlato(new Plato("Sopa Castellana", 12.5f));
        miMenu.asignarPlato(new Plato("Filete de Ternera", 25.0f));
        
        List<Plato> listaDePlatos = miMenu.obtener_platos();
        int opc = 0;
        
        do {
            System.out.println("\n--- Resumen del Menú ---");
            for (int i = 0; i < listaDePlatos.size(); i++) {
                System.out.println("Plato " + (i+1) + ": " + listaDePlatos.get(i).nombre + " ($" + listaDePlatos.get(i).precio + ")");
            }

            System.out.println("\nElija una opción:");
            System.out.println("1 - Calcular para LLEVAR (+2%)");
            System.out.println("2 - Calcular para RESTAURANTE");
            System.out.println("3 - Salir");
            
            if (sc.hasNextInt()) {
                opc = sc.nextInt();
                
                if (opc == 1) {
                    float total = miMenu.calcularPrecio(true);
                    System.out.println(">> TOTAL A PAGAR (Llevar): $" + total);
                } else if (opc == 2) {
                    float total = miMenu.calcularPrecio(false);
                    System.out.println(">> TOTAL A PAGAR (Local): $" + total);
                }
            } else {
                sc.next(); // Limpiar entrada inválida
            }

        } while (opc != 3);
        
        System.out.println("¡Buen provecho!");
        sc.close();
    }
}