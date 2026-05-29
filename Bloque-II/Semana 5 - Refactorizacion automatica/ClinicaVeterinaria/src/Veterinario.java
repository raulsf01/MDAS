public class Veterinario extends Empleado implements Informable, Comparable<Veterinario>{
    // Refactor semana 1: nombre de variable extraño
    //private String especalidad;
    private String especialidad;

    public Veterinario(String nombre, double salarioBase, String especalidad) {
        super(nombre, salarioBase);
        this.especialidad = especalidad;
    }

    @Override
    double calcularSalario() {
        return getSalarioBase()+500;
    }


    @Override
    public String toString() {
        return "Veterinario{" +
                "especalidad='" + especialidad + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", salarioBase=" + getSalarioBase() +
                '}';
    }

    @Override
    public String generarInforme() {
        return "Nombre: "+getNombre()+
                ", especialidad: "+ especialidad+
                ", salario: "+ String.format("%.2f", calcularSalario());
    }

    @Override//compara los salarios
    public int compareTo(Veterinario o) {
        return Double.compare(this.calcularSalario(), o.calcularSalario());
    }
}
