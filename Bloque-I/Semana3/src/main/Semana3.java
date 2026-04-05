package main;

public class Semana3 {
    public static void main(String[] args) {
        // 1. Creamos aparatos individuales 
        AparatoElectrico pc1 = new AparatoElectrico("PC Laboratorio", 0.3, 10);
        AparatoElectrico proyector = new AparatoElectrico("Proyector", 0.5, 5);
        AparatoElectrico vending = new AparatoElectrico("Máquina Vending", 1.2, 24); // Fuera de salas 

        // 2. Configuramos una Sala 
        Sala lab1 = new Sala("Laboratorio de Software");
        lab1.añadir(pc1);
        lab1.añadir(proyector);

        // 3. Configuramos un Edificio y añadimos la sala y aparatos externos 
        Edificio politecnica = new Edificio("Escuela Politécnica");
        politecnica.añadir(lab1);
        politecnica.añadir(vending); // Aparato en el edificio pero fuera de la sala 

        // 4. Configuramos el Campus 
        Campus campusCordoba = new Campus("Campus Rabanales");
        campusCordoba.añadir(politecnica);

        // 5. Mostramos resultados del consumo global estimado 
        System.out.println("--- Informe de Gasto Energético ---");
        System.out.printf("Gasto %s: %.2f€%n", lab1.getNombre(), lab1.calcularGasto());
        System.out.printf("Gasto %s (incluye máquinas pasillo): %.2f€%n", 
                          politecnica.getNombre(), politecnica.calcularGasto());
        System.out.printf("GASTO TOTAL %s: %.2f€%n", 
                          campusCordoba.getNombre(), campusCordoba.calcularGasto());
    }
}