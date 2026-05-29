import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static void main(String[] args) {

        System.out.println();
        System.out.println("EJERCICIO 1");
        Propietario p1 = new Propietario("12345678", "Ana Garcia", "612345678");
        Propietario p2 = new Propietario(p1);
        p2.setTelefono("999888777");

        System.out.println("p1-> "+ p1);
        System.out.println("p2-> "+ p2);

        //EJERCICIO 2 MASCOTAS
        System.out.println();
        System.out.println("EJERCICIO 2");
        Mascota m1 = new Mascota("Rex", "Perro",3,p1);
        Mascota m2 = new Mascota("Lucky", "Perro", 12, p2);
        Mascota m3 = new Mascota("Felix", "gato", 1, p1);

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        m3.setEdad(-3);//intentar cambiar la edad a negativa

        System.out.println("Intentamos cambiar la edad a -3-> "+m3);//vemos q no cambia

        System.out.println("Total mascotas-> "+Mascota.getTotalMascotas());

        //EJERCICIO 3
        System.out.println();
        System.out.println("EJERCICIO 3");

        //Empleado[] empleados = new Empleado[3];//creamos array
        Empleado v1 = new Veterinario("Pepito",1800, "Cirujano");
        Empleado a1 = new Auxiliar("Josefina", 1400, "mañana");
        Empleado a2 = new Auxiliar("Lucia", 1400, "noche");

        Empleado[] empleados = {v1,a1,a2}; //metemos a una array cosas ya creadas

        for ( Empleado i : empleados){
            System.out.println(i.toString());
        }

        //EJERCICIO 4
        System.out.println();
        System.out.println("EJERCICIO 4");
        List<Informable> informables = new ArrayList<>();
        informables.add((Informable) v1);//pone eso pq infromable esta en veterinatio y yo he creado emp,eado = veterinario no veterinario=veterinario
        informables.add(m1);
        informables.add(m2);

        for (Informable i : informables){
            System.out.println(i.generarInforme());
        }

        // EJERCICIO 5 - Repositorio genérico

        System.out.println("\n=== EJERCICIO 5 ===");
        Repositorio<Mascota> repoMascotas = new Repositorio<>();
        repoMascotas.agregar(m1);
        repoMascotas.agregar(m2);
        repoMascotas.agregar(m3);

        System.out.println("Total elementos: " + repoMascotas.totalElementos());
        System.out.println("Buscar índice 1: " + repoMascotas.buscarPorIndice(1));
        System.out.println("Buscar índice 99 (inválido): " + repoMascotas.buscarPorIndice(99));
        System.out.println("Eliminar Rex: " + repoMascotas.eliminar(m1));
        System.out.println("Tras eliminar, total: " + repoMascotas.totalElementos());
        System.out.println("Todos los elementos:");
        repoMascotas.mostrarTodos();

        // EJERCICIO 6 - GestorClinica
        // ─────────────────────────────────────────────
        System.out.println("\n=== EJERCICIO 6 ===");
        GestorClinica gestor = new GestorClinica();
        Propietario p4 = new Propietario("11111111C", "Maria Ruiz",   "600111222");
        Propietario p5 = new Propietario("22222222D", "Jose Morales", "600333444");

        Mascota m4 = new Mascota("Nala",   "Gato",     2, p4);
        Mascota m5 = new Mascota("Rocky",  "Perro",    5, p5);
        Mascota m6 = new Mascota("Tweety", "Pájaro",   3, p4);
        Mascota m7 = new Mascota("Goldie", "Pez",      1, p5);

        gestor.registrarMascotas(m1);
        gestor.registrarMascotas(m4);
        gestor.registrarMascotas(m5);
        gestor.registrarMascotas(m6);
        gestor.registrarMascotas(m7); // repite especie "Pez" si añadimos otra
        gestor.registrarMascotas(new Mascota("Perla", "Pez", 2, p4)); // especie repetida

        System.out.println("--- Especies distintas (sin duplicados) ---");
        gestor.mostrarEspecies();

        System.out.println("--- Buscar 'Nala' ---");
        Mascota encontrada = gestor.buscarPorNombre("Nala");
        System.out.println(encontrada != null ? encontrada : "No encontrada");

        System.out.println("--- Buscar 'Invisible' ---");
        Mascota noExiste = gestor.buscarPorNombre("Invisible");
        System.out.println(noExiste != null ? noExiste : "No encontrada");

        System.out.println("--- Todas las mascotas ---");
        gestor.MostrarTodasLasMascotas();

        //Ejercicio 7

        //llama a mostrarMayor con dos Strings, con dos Integers y con dos
        //objetos Veterinario. Muestra el resultado de cada llamada.
        String s1 = "Manzana";
        String s2 = "Banana";
        mostrarMayor(s1, s2);

        // Integers
        Integer n1 = 42;
        Integer n2 = 27;
        mostrarMayor(n1, n2);

        Veterinario v3 = new Veterinario("Pepito", 1800, "Cirujano");
        Veterinario v4 = new Veterinario("Marta",  2000, "Dermatologo");
        mostrarMayor(v3, v4 );

        System.out.println("\n=== EJERCICIO 8 ===");

        // Lista con al menos 6 mascotas de distintas especies, edades y propietarios
        // Reutilizamos algunas y añadimos nuevas
        System.out.println("--- EJERCICIO 8: STREAMS Y COMPARATORS ---");
        List<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Rex", "Perro", 3, p1));
        mascotas.add(new Mascota("Misi", "Gato", 1, p2));
        mascotas.add(new Mascota("Tweety", "Loro", 5, p4));
        mascotas.add(new Mascota("Bella", "Gato", 2, p5));
        mascotas.add(new Mascota("Max", "Perro", 1, p2));
        mascotas.add(new Mascota("Coco", "Loro", 4, p5));

        // a) Ordenar por edad menor a mayor
        System.out.println("\na) Por edad (menor a mayor):");
        mascotas.sort(Comparator.comparing(Mascota::getEdad));
        mascotas.forEach(m -> System.out.println("  " + m));

        // b) Ordenar por nombre inverso
        System.out.println("\nb) Por nombre (Z-A):");
        mascotas.sort(Comparator.comparing(Mascota::getNombre).reversed());
        mascotas.forEach(m -> System.out.println("  " + m));

        // c) Por especie, luego edad descendente
        System.out.println("\nc) Por especie + edad desc:");
        mascotas.sort(Comparator.comparing(Mascota::getEspecie)
                .thenComparing(Comparator.comparing(Mascota::getEdad).reversed()));
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
