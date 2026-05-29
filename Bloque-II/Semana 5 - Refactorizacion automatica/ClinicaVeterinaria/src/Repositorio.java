import java.util.ArrayList;

public class Repositorio <T> {
     private ArrayList <T> elementos;

     public Repositorio() {elementos = new ArrayList<>();} 

    public void agregar (T elemento){
         elementos.add(elemento);
    }

    public boolean eliminar(T elemento){
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).equals(elemento)){
                elementos.remove(i);
                return true;
            }

        }
        return false;
    }
    
    // Refactor Semana 1: regla 6 y 8, unica letra o muy corta
    //public T buscarPorIndice(int i){  
    public T buscarPorIndice(int index){     
        if(index < 0|| index >= elementos.size()){
            return null;
        }else{
            return elementos.get(index);
        }
    }

    public int totalElementos(){
         return elementos.size();
    }

    public void mostrarTodos(){
        for ( T elemento: elementos ) {
            System.out.println(elemento.toString());
        }
    }
}
