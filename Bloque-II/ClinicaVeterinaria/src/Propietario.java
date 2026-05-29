import java.util.Objects;

public class Propietario {
    private String DNI;
    private String nombre;
    private String telefono;

    public Propietario(String DNI, String nombre, String telefono) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Propietario(Propietario otro) { //copia profunda
        this.DNI = otro.DNI;
        this.nombre = otro.nombre;
        this.telefono = otro.telefono;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) { //solo asigna valor si la cadena tiene 9
        if (telefono.length()==9){
            this.telefono = telefono;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Propietario that)) return false;
        return Objects.equals(DNI, that.DNI);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(DNI);
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }


}


