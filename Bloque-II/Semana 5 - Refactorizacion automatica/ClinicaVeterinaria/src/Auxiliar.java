public class Auxiliar extends Empleado{
    private String turno;// "mañana", "tarde" o "noche"

    public Auxiliar(String nombre, double salarioBase, String turno) {
        super(nombre, salarioBase);
        this.turno = turno;
    }

    @Override
    double calcularSalario() {
        return calcularPlusNocturnidad();
    }

    // Refactor Semana 5: Aplicada refactorización automática mediante la herramienta del IDE (Refactor -> Introduce -> Method)
    private double calcularPlusNocturnidad() {
        if (turno.equalsIgnoreCase("noche")){
            return getSalarioBase()* 1.20;
        }else {
            return getSalarioBase();
        }
    }

    @Override
    public String toString() {
        return "Auxiliar+" +
                "nombre='" + getNombre() + '\'' +
                ", turno='" + turno + '\'' +
                ", salario=" + getSalarioBase() +
                '}';
    }
}
