import java.util.ArrayList;

public class Repositorio <T> {//LA T ES ESENCIAL PONERLA AQUI
     private ArrayList <T> elementos;

     public Repositorio() {elementos = new ArrayList<>();} //esta linea y la an terior es para crear la array y poder almacenar cosas

    public void agregar (T elemento){//agregar elemento a la lista
         elementos.add(elemento);
    }

    public boolean eliminar(T elemento){
         //recorremos toda la array para ver si 'elemento' esta y luego si dentro de elementos esta i y es igual a elemento se elimina
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).equals(elemento)){
                elementos.remove(i);
                return true;
            }

        }
        return false;
    }

    public T buscarPorIndice(int i){
        if(i<0||i>=elementos.size()){//si el indice es negativo Y es mayor a la csantidad de elemento q hay es null
            return null;
        }else{// si no devuelve el indice
            return elementos.get(i);
        }
    }

    public int totalElementos(){//numero de elementos
         return elementos.size();
    }

    public void mostrarTodos(){
        for ( T elemento: elementos ) {
            System.out.println(elemento.toString());
        }
    }
}
