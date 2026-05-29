import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GestorClinica {
    private Map<String, Mascota> mascotas;
    private Set<String> especies;

    public GestorClinica(){
        this.mascotas = new HashMap<>();//hacemos que mascotas sea un HashMap
        this.especies = new HashSet<>();
    }

    public void registrarMascotas(Mascota m){
        mascotas.put(m.getNombre(),m);//añadimos el nombre de la mascota Q YA ESTA CREADA
        especies.add(m.getEspecie());
    }
    public Mascota buscarPorNombre(String nombre){
        return mascotas.get(nombre);//busca el nombre si esta devuelve el nombre, si no pues es null
    }

    void mostrarEspecies(){
        System.out.println("Especies registradas: " + especies);
        // como el HashSet NO permite repeticiones pues que se imprima todo y ya
    }

    void MostrarTodasLasMascotas(){
        for (Map.Entry<String, Mascota> e : mascotas.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
