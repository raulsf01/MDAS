package main;

import java.util.*;

public class OficinaTurismoMadrid {
    public List<Actividad> buscarPorTipoEvento(String tipo, String fecha) {
        return Arrays.asList(new Actividad("Museo del Prado - " + tipo, fecha));
    }
}
