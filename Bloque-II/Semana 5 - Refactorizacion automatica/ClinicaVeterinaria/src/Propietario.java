import java.util.Objects;

public class Propietario {
    private String dni; // Refactor Semana 5: Aplicada refactorización automática mediante la herramienta del IDE (Refactor -> Rename) para actualizar de forma segura el identificador en todo el proyecto.
    private String nombre;
    private String telefono;

    public Propietario(String DNI, String nombre, String telefono) {
        this.dni = DNI;
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
        this.dni = propietarioOriginal.dni;
        this.nombre = propietarioOriginal.nombre;
        this.telefono = propietarioOriginal.telefono;
    }

    public String getDNI() {
        return dni;
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
        return Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "DNI='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }


}


