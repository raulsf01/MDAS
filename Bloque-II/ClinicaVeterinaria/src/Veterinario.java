public class Veterinario extends Empleado implements Informable, Comparable<Veterinario>{

    private String especalidad;

    public Veterinario(String nombre, double salarioBase, String especalidad) {
        super(nombre, salarioBase);
        this.especalidad = especalidad;
    }

    @Override
    double calcularSalario() {
        return salarioBase+500;
    }


    @Override
    public String toString() {
        return "Veterinario{" +
                "especalidad='" + especalidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", salarioBase=" + salarioBase +
                '}';
    }

    @Override
    public String generarInforme() {
        return "Nombre: "+nombre+
                ", especialidad: "+ especalidad+
                ", salario: "+ String.format("%.2f", calcularSalario());//salario con 2 decimales
    }

    @Override//compara los salarios
    public int compareTo(Veterinario o) {
        return Double.compare(this.calcularSalario(), o.calcularSalario());
    }
}
