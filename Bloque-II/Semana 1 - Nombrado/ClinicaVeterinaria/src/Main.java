import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {   // Refactor Semana 1: metodo no estaba declarado publico, por tanto, ilegible para otro compilador al exportar
                
        System.out.println();
        System.out.println("EJERCICIO 1");
        Propietario propietario1 = new Propietario("12345678", "Ana Garcia", "612345678");
        Propietario propietario2 = new Propietario(propietario1);
        propietario2.setTelefono("999888777");
        
        // Refactor semana 1: variables repetitivas sin significado
        System.out.println("propietario1-> "+ propietario1);
        System.out.println("propietario2-> "+ propietario2);

        //EJERCICIO 2 MASCOTAS
        System.out.println();
        System.out.println("EJERCICIO 2");
        Mascota mascota1 = new Mascota("Rex", "Perro",3,propietario1);
        Mascota mascota2 = new Mascota("Lucky", "Perro", 12, propietario2);
        Mascota mascota3 = new Mascota("Felix", "gato", 1, propietario1);
        
        // Refactor semana 1: variables repetitivas sin significado
        System.out.println(mascota1);
        System.out.println(mascota2);
        System.out.println(mascota3);

        mascota3.setEdad(-3);//intentar cambiar la edad a negativa

        System.out.println("Intentamos cambiar la edad a -3-> "+mascota3);//vemos q no cambia

        System.out.println("Total mascotas-> "+Mascota.getTotalMascotas());

        //EJERCICIO 3
        System.out.println();
        System.out.println("EJERCICIO 3");

        //Empleado[] empleados = new Empleado[3];//creamos array
        Empleado veterinario1 = new Veterinario("Pepito",1800, "Cirujano");
        Empleado auxiliar1 = new Auxiliar("Josefina", 1400, "mañana");
        Empleado auxiliar2 = new Auxiliar("Lucia", 1400, "noche");

        // Refactor semana 1: de nuevo nombres sin significado
        Empleado[] empleados = {veterinario1,auxiliar1,auxiliar2}; //metemos a una array cosas ya creadas
        
        // Refactor Semana 1: usar i para refereirse a un empleado. 
        //for ( Empleado i : empleados){
        for (Empleado currentWorker : empleados) {
            System.out.println(currentWorker.toString());
        }

        //EJERCICIO 4
        System.out.println();
        System.out.println("EJERCICIO 4");
        List<Informable> informables = new ArrayList<>();
        informables.add((Informable) veterinario1);//pone eso pq infromable esta en veterinatio y yo he creado emp,eado = veterinario no veterinario=veterinario
        informables.add(mascota1);
        informables.add(mascota2);

        // Refactor Semana 1: usar i para refereirse a un empleado. 
        //for (Informable i : informables){
        for (Informable currentInform : informables){
            System.out.println(currentInform.generarInforme());
        }

        // EJERCICIO 5 - Repositorio genérico

        System.out.println("\n=== EJERCICIO 5 ===");
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

        // EJERCICIO 6 - GestorClinica
        // ─────────────────────────────────────────────
        System.out.println("\n=== EJERCICIO 6 ===");
        GestorClinica gestor = new GestorClinica();
        Propietario propietario4 = new Propietario("11111111C", "Maria Ruiz",   "600111222");
        Propietario propietario5 = new Propietario("22222222D", "Jose Morales", "600333444");

        Mascota mascota4 = new Mascota("Nala",   "Gato",     2, propietario4);
        Mascota mascota5 = new Mascota("Rocky",  "Perro",    5, propietario5);
        Mascota mascota6 = new Mascota("Tweety", "Pájaro",   3, propietario4);
        Mascota mascota7 = new Mascota("Goldie", "Pez",      1, propietario5);

        gestor.registrarMascotas(mascota1);
        gestor.registrarMascotas(mascota4);
        gestor.registrarMascotas(mascota5);
        gestor.registrarMascotas(mascota6);
        gestor.registrarMascotas(mascota7); // repite especie "Pez" si añadimos otra
        gestor.registrarMascotas(new Mascota("Perla", "Pez", 2, propietario4)); // especie repetida

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

        //Ejercicio 7

        //llama a mostrarMayor con dos Strings, con dos Integers y con dos
        //objetos Veterinario. Muestra el resultado de cada llamada.
        String cadena1 = "Manzana";
        String cadena2 = "Banana";
        mostrarMayor(cadena1, cadena2);

        // Integers
        Integer num1 = 42;
        Integer num2 = 27;
        mostrarMayor(num1, num2);

        Veterinario veterinario3 = new Veterinario("Pepito", 1800, "Cirujano");
        Veterinario veterinario4 = new Veterinario("Marta",  2000, "Dermatologo");
        mostrarMayor(veterinario3, veterinario4 );

        System.out.println("\n=== EJERCICIO 8 ===");

        // Lista con al menos 6 mascotas de distintas especies, edades y propietarios
        // Reutilizamos algunas y añadimos nuevas
        System.out.println("--- EJERCICIO 8: STREAMS Y COMPARATORS ---");
        List<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Rex", "Perro", 3, propietario1));
        mascotas.add(new Mascota("Misi", "Gato", 1, propietario2));
        mascotas.add(new Mascota("Tweety", "Loro", 5, propietario4));
        mascotas.add(new Mascota("Bella", "Gato", 2, propietario5));
        mascotas.add(new Mascota("Max", "Perro", 1, propietario2));
        mascotas.add(new Mascota("Coco", "Loro", 4, propietario5));

        // a) Ordenar por edad menor a mayor
        System.out.println("\na) Por edad (menor a mayor):");
        mascotas.sort(Comparator.comparing(Mascota::getEdad));
        mascotas.forEach(m -> System.out.println("  " + m));

        // e) Filtrar cachorros
        System.out.println("\ne) Cachorros (edad < 2):");
        List<Mascota> cachorros = mascotas.stream()
                .filter(Mascota::esCachorro)
                .collect(Collectors.toList());
        System.out.println("  Total cachorros: " + cachorros.size());
        cachorros.forEach(m -> System.out.println("  - " + m));

        // f) Nombres de mascotas
        System.out.println("\nf) Nombres de todas las mascotas:");
        List<String> nombres = mascotas.stream()
                .map(Mascota::getNombre)
                .collect(Collectors.toList());
        System.out.println("  " + nombres);

        // g) Perros ordenados por nombre
        System.out.println("\ng) Perros ordenados por nombre:");
        mascotas.stream()
                .filter(m -> m.getEspecie().equals("Perro"))
                .sorted(Comparator.comparing(Mascota::getNombre))
                .forEach(m -> System.out.println("  - " + m));

        // h) Edad media
        System.out.println("\nh) Edad media:");
        double edadMedia = mascotas.stream()
                .map(Mascota::getEdad)
                .reduce(0, Integer::sum) / (double) mascotas.size();
        System.out.println("  Media: " + String.format("%.2f", edadMedia) + " años");

        // i) Especies distintas
        System.out.println("\ni) Especies distintas:");
        Set<String> especiesDistintas = mascotas.stream()
                .map(Mascota::getEspecie)
                .distinct()
                .collect(Collectors.toSet());
        System.out.println("  " + especiesDistintas);
    }
    
    public static <T extends Comparable<T>> void mostrarMayor(T a, T b) {
        if (a.compareTo(b) > 0) {
            System.out.println(a + " es mayor que "+b);
        } else if (a.compareTo(b) < 0) {
            System.out.println(b + " es mayor que "+a);
        } else {
            System.out.println("Son iguales");
        }
    }
}
