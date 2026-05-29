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
    
    // Refactor Semana 1: usar palabra confusa para refereirse a un objeto. 
    /*public Propietario(Propietario otro) { //copia profunda
        this.DNI = otro.DNI;
        this.nombre = otro.nombre;
        this.telefono = otro.telefono;
    }*/
    public Propietario(Propietario propietarioOriginal) { //copia profunda
        this.DNI = propietarioOriginal.DNI;
        this.nombre = propietarioOriginal.nombre;
        this.telefono = propietarioOriginal.telefono;
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

    public void setTelefono(String telefono) { 
        if (telefono.length()==9){
            this.telefono = telefono;
        }
    }

    @Override
    //Refactor semana 1: variables sin significado
    /*public boolean equals(Object o) {
        if (!(o instanceof Propietario that)) return false;
        return Objects.equals(DNI, that.DNI);
    }*/
    public boolean equals(Object propietario) {
        if (!(propietario instanceof Propietario that)) return false;
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


