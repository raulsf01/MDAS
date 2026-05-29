public class Mascota implements Informable{
    private String nombre;
    private String especie;
    private int edad;
    private Propietario propietario;
    private static int totalMascotas=0;//atributo privado estatico

    public Mascota(String nombre, String especie, int edad, Propietario propietario) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.propietario = propietario;
        totalMascotas++;//asi cada vez que se genere una mascota se suma 1
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public static int getTotalMascotas() {// Metodo estático getTotalMascotas() que devuelva el valor del contador.
        return totalMascotas;
    }

    public void setEdad(int edad) {
        if (edad>=0){
            this.edad = edad;
        }
    }

    public boolean esCachorro(){//Método esCachorro() que devuelva true si la edad es menor de 2.
        return edad<2;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad +
                ", propietario=" + propietario.getNombre() + //Usa solo el nombre del propietario, no su toString() completo.
                '}';
    }

    @Override
    public String generarInforme() {
        return "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                "es cachorro= "+esCachorro() +
                ", propietario=" + propietario.getNombre()//Usa solo el nombre del propietario, no su toString() completo
                ;
    }
}
