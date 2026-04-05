package main;

import java.util.*;

public class OficinaTurismoBarcelona {
    public List<Actividad> buscarPorFecha(String fecha) {
        return Arrays.asList(new Actividad("Sagrada Familia", fecha));
    }
}
