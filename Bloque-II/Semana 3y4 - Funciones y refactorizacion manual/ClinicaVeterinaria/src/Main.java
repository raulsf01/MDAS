// Refactor Semana 3 y 4: división modular para eliminar la Función generica en el Main.

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcionSeleccionada;

        do {
            System.out.println("\n=======================================");
            System.out.println("   SISTEMA DE GESTIÓN CLINICA VETERINARIA  ");
            System.out.println("=======================================");
            System.out.println("1. Pruebas de Registro de Propietarios");
            System.out.println("2. Pruebas de Control de Mascotas");
            System.out.println("3. Pruebas de Contratos de Empleados y Salarios");
            System.out.println("4. Pruebas de Generación de Informes Polimórficos");
            System.out.println("5. Pruebas de Repositorio Genérico");
            System.out.println("6. Pruebas de Búsqueda en Gestor de Clínica");
            System.out.println("7. Pruebas de Comparación Genérica de Objetos");
            System.out.println("8. Pruebas de Procesamiento con Streams y Comparadores");
            System.out.println("0. Salir de la aplicación");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcionSeleccionada = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, introduzca un número válido.");
                teclado.next(); 
                opcionSeleccionada = -999;
                continue;
            }

            switch (opcionSeleccionada) {
                case 1 -> probarRegistroPropietarios();
                case 2 -> probarControlMascotas();
                case 3 -> probarContratosYSalariosEmpleados();
                case 4 -> probarGeneracionInformesPolimorficos();
                case 5 -> probarAlmacenamientoRepositorioGenerico();
                case 6 -> probarBusquedasGestorClinica();
                case 7 -> probarComparacionGenericaMayor();
                case 8 -> probarFiltradoYEstadisticasConStreams();
                case 0 -> System.out.println("Saliendo del programa de pruebas...");
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcionSeleccionada != 0);
        
        teclado.close();
    }

    // =========================================================================
    // MÉTODOS REFACTORIZADOS 
    // =========================================================================

    private static void probarRegistroPropietarios() {
        System.out.println("\n--- PRUEBA: REGISTRO DE PROPIETARIOS ---");
        Propietario propietario1 = new Propietario("12345678", "Ana Garcia", "612345678");
        Propietario propietario2 = new Propietario(propietario1);
        propietario2.setTelefono("999888777");
        
        System.out.println("propietario1-> " + propietario1);
        System.out.println("propietario2-> " + propietario2);
    }

    private static void probarControlMascotas() {
        System.out.println("\n--- PRUEBA: CONTROL DE MASCOTAS ---");
        Propietario propietario1 = new Propietario("12345678", "Ana Garcia", "612345678");
        Propietario propietario2 = new Propietario(propietario1);
        propietario2.setTelefono("999888777");

        Mascota mascota1 = new Mascota("Rex", "Perro", 3, propietario1);
        Mascota mascota2 = new Mascota("Lucky", "Perro", 12, propietario2);
        Mascota mascota3 = new Mascota("Felix", "gato", 1, propietario1);
        
        System.out.println(mascota1);
        System.out.println(mascota2);
        System.out.println(mascota3);

        System.out.println("Total mascotas registradas -> " + Mascota.getTotalMascotas());
    }

    private static void probarContratosYSalariosEmpleados() {
        System.out.println("\n--- PRUEBA: CONTRATOS Y SALARIOS DE EMPLEADOS ---");
        Empleado veterinario1 = new Veterinario("Pepito", 1800, "Cirujano");
        Empleado auxiliar1 = new Auxiliar("Josefina", 1400, "mañana");
        Empleado auxiliar2 = new Auxiliar("Lucia", 1400, "noche");

        Empleado[] listaEmpleados = {veterinario1, auxiliar1, auxiliar2};
        
        for (Empleado currentWorker : listaEmpleados) {
            System.out.println(currentWorker.toString());
        }
    }

    private static void probarGeneracionInformesPolimorficos() {
        System.out.println("\n--- PRUEBA: GENERACIÓN DE INFORMES POLIMÓRFICOS ---");
        Propietario propietario1 = new Propietario("12345678", "Ana Garcia", "612345678");
        Propietario propietario2 = new Propietario(propietario1);
        
        Empleado veterinario1 = new Veterinario("Pepito", 1800, "Cirujano");
        Mascota mascota1 = new Mascota("Rex", "Perro", 3, propietario1);
        Mascota mascota2 = new Mascota("Lucky", "Perro", 12, propietario2);

        List<Informable> listaEntidadesInformables = new ArrayList<>();
        listaEntidadesInformables.add((Informable) veterinario1);
        listaEntidadesInformables.add(mascota1);
        listaEntidadesInformables.add(mascota2);

        for (Informable currentInform : listaEntidadesInformables) {
            System.out.println(currentInform.generarInforme());
        }
    }

    private static void probarAlmacenamientoRepositorioGenerico() {
        System.out.println("\n--- PRUEBA: ALMACENAMIENTO EN REPOSITORIO GENÉRICO ---");
        Propietario propietario1 = new Propietario("12345678", "Ana Garcia", "612345678");
        Propietario propietario2 = new Propietario(propietario1);
        
        Mascota mascota1 = new Mascota("Rex", "Perro", 3, propietario1);
        Mascota mascota2 = new Mascota("Lucky", "Perro", 12, propietario2);
        Mascota mascota3 = new Mascota("Felix", "gato", 1, propietario1);

        Repositorio<Mascota> repoMascotas = new Repositorio<>();
        repoMascotas.agregar(mascota1);
        repoMascotas.agregar(mascota2);
        repoMascotas.agregar(mascota3);

        System.out.println("Total elementos: " + repoMascotas.totalElementos());
        System.out.println("Buscar índice 1: " + repoMascotas.buscarPorIndice(1));
        System.out.println("Buscar índice 99 (inválido): " + repoMascotas.buscarPorIndice(99));
        System.out.println("Eliminar Rex: " + repoMascotas.eliminar(mascota1));
        System.out.println("Tras eliminar, total: " + repoMascotas.totalElementos());
        System.out.println("Todos los elementos:");
        repoMascotas.mostrarTodos();
    }

    private static void probarBusquedasGestorClinica() {
        System.out.println("\n--- PRUEBA: BÚSQUEDAS EN EL GESTOR DE LA CLÍNICA ---");
        Propietario propietario1 = new Propietario("12345678", "Ana Garcia", "612345678");
        Propietario propietario4 = new Propietario("11111111C", "Maria Ruiz", "600111222");
        Propietario propietario5 = new Propietario("22222222D", "Jose Morales", "600333444");

        Mascota mascota1 = new Mascota("Rex", "Perro", 3, propietario1);
        Mascota mascota4 = new Mascota("Nala", "Gato", 2, propietario4);
        Mascota mascota5 = new Mascota("Rocky", "Perro", 5, propietario5);
        Mascota mascota6 = new Mascota("Tweety", "Pájaro", 3, propietario4);
        Mascota mascota7 = new Mascota("Goldie", "Pez", 1, propietario5);

        GestorClinica gestor = new GestorClinica();
        gestor.registrarMascotas(mascota1);
        gestor.registrarMascotas(mascota4);
        gestor.registrarMascotas(mascota5);
        gestor.registrarMascotas(mascota6);
        gestor.registrarMascotas(mascota7); 
        gestor.registrarMascotas(new Mascota("Perla", "Pez", 2, propietario4)); 

        System.out.println("--- Especies distintas (sin duplicados) ---");
        gestor.mostrarEspecies();

        System.out.println("--- Buscar 'Nala' ---");
        Mascota encontrada = gestor.buscarPorNombre("Nala");
        System.out.println(encontrada != null ? encontrada : "No encontrada");

        System.out.println("--- Buscar 'Invisible' ---");
        Mascota noExiste = gestor.buscarPorNombre("Invisible");
        System.out.println(noExiste != null ? noExiste : "No encontrada");

        System.out.println("--- Todas las mascotas ---");
        gestor.mostrarTodasLasMascotas();
    }

    private static void probarComparacionGenericaMayor() {
        System.out.println("\n--- PRUEBA: COMPARACIÓN GENÉRICA DE OBJETOS ---");
        String cadena1 = "Manzana";
        String cadena2 = "Banana";
        mostrarMayor(cadena1, cadena2);

        Integer num1 = 42;
        Integer num2 = 27;
        mostrarMayor(num1, num2);

        Veterinario veterinario3 = new Veterinario("Pepito", 1800, "Cirujano");
        Veterinario veterinario4 = new Veterinario("Marta", 2000, "Dermatologo");
        mostrarMayor(veterinario3, veterinario4);
    }

    private static void probarFiltradoYEstadisticasConStreams() {
        System.out.println("\n--- PRUEBA: FILTRADO Y ESTADÍSTICAS CON STREAMS ---");
        Propietario propietario1 = new Propietario("12345678", "Ana Garcia", "612345678");
        Propietario propietario2 = new Propietario(propietario1);
        Propietario propietario4 = new Propietario("11111111C", "Maria Ruiz", "600111222");
        Propietario propietario5 = new Propietario("22222222D", "Jose Morales", "600333444");

        List<Mascota> catalogoMascotas = new ArrayList<>();
        catalogoMascotas.add(new Mascota("Rex", "Perro", 3, propietario1));
        catalogoMascotas.add(new Mascota("Misi", "Gato", 1, propietario2));
        catalogoMascotas.add(new Mascota("Tweety", "Loro", 5, propietario4));
        catalogoMascotas.add(new Mascota("Bella", "Gato", 2, propietario5));
        catalogoMascotas.add(new Mascota("Max", "Perro", 1, propietario2));
        catalogoMascotas.add(new Mascota("Coco", "Loro", 4, propietario5));

        // a) Ordenar por edad menor a mayor
        System.out.println("\na) Por edad (menor a mayor):");
        catalogoMascotas.sort(Comparator.comparing(Mascota::getEdad));
        catalogoMascotas.forEach(m -> System.out.println("  " + m));

        // e) Filtrar cachorros
        System.out.println("\ne) Cachorros (edad < 2):");
        List<Mascota> cachorrosFiltrados = catalogoMascotas.stream()
                .filter(Mascota::esCachorro)
                .collect(Collectors.toList());
        System.out.println("  Total cachorros: " + cachorrosFiltrados.size());
        cachorrosFiltrados.forEach(m -> System.out.println("  - " + m));

        // f) Nombres de mascotas
        System.out.println("\nf) Nombres de todas las mascotas:");
        List<String> listaNombres = catalogoMascotas.stream()
                .map(Mascota::getNombre)
                .collect(Collectors.toList());
        System.out.println("  " + listaNombres);

        // g) Perros ordenados por nombre
        System.out.println("\ng) Perros ordenados por nombre:");
        catalogoMascotas.stream()
                .filter(m -> m.getEspecie().equals("Perro"))
                .sorted(Comparator.comparing(Mascota::getNombre))
                .forEach(m -> System.out.println("  - " + m));

        // h) Edad media
        System.out.println("\nh) Edad media:");
        double edadMedia = catalogoMascotas.stream()
                .map(Mascota::getEdad)
                .reduce(0, Integer::sum) / (double) catalogoMascotas.size();
        System.out.println("  Media: " + String.format("%.2f", edadMedia) + " años");

        // i) Especies distintas
        System.out.println("\ni) Especies distintas:");
        Set<String> conjuntoEspeciesDistintas = catalogoMascotas.stream()
                .map(Mascota::getEspecie)
                .distinct()
                .collect(Collectors.toSet());
        System.out.println("  " + conjuntoEspeciesDistintas);
    }
    
    public static <T extends Comparable<T>> void mostrarMayor(T a, T b) {
        if (a.compareTo(b) > 0) {
            System.out.println(a + " es mayor que " + b);
        } else if (a.compareTo(b) < 0) {
            System.out.println(b + " es mayor que " + a);
        } else {
            System.out.println("Son iguales");
        }
    }
}