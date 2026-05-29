public class Auxiliar extends Empleado{
    private String turno;// "mañana", "tarde" o "noche"

    public Auxiliar(String nombre, double salarioBase, String turno) {
        super(nombre, salarioBase);
        this.turno = turno;
    }

    @Override
    double calcularSalario() {
        if (turno.equalsIgnoreCase("noche")){
            return salarioBase* 1.20;
        }else {
        return salarioBase;
        }
    }

    @Override
    public String toString() {
        return "Auxiliar+" +
                "nombre='" + nombre + '\'' +
                ", turno='" + turno + '\'' +
                ", salario=" + salarioBase +
                '}';
    }
}
