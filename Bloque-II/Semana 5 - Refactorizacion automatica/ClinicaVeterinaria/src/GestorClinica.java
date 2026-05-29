import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GestorClinica {
    private Map<String, Mascota> mascotas;
    private Set<String> especies;

    public GestorClinica(){
        this.mascotas = new HashMap<>();
        this.especies = new HashSet<>();
    }

    public void registrarMascotas(Mascota m){
        mascotas.put(m.getNombre(),m);
        especies.add(m.getEspecie());
    }
    public Mascota buscarPorNombre(String nombre){
        return mascotas.get(nombre);
    }

    void mostrarEspecies(){
        System.out.println("Especies registradas: " + especies);
    }
    
    
    // Refactor Semana 1: usar letra Mayúscula al inicio de declaracion. 
    //void MostrarTodasLasMascotas(){
    void mostrarTodasLasMascotas(){
        for (Map.Entry<String, Mascota> e : mascotas.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
