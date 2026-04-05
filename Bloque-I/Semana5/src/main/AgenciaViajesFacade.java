package main;
import java.util.*;

public class AgenciaViajesFacade {
    private SistemaTransporte transporte = new SistemaTransporte();
    private SistemaAlojamiento alojamiento = new SistemaAlojamiento();
    private OficinaTurismoMadrid turismoMadrid = new OficinaTurismoMadrid();
    private OficinaTurismoBarcelona turismoBarcelona = new OficinaTurismoBarcelona();

    /**
     * Método simplificado que coordina todos los subsistemas[cite: 192, 193].
     */
    public void buscarViajeCompleto(String fInicio, String fFin, String origen, String destino) {
        System.out.println("--- BUSCANDO VIAJE GRUPAL PARA " + destino.toUpperCase() + " ---");

        // 1. Invoca al servicio de transporte [cite: 196]
        List<Transporte> vuelos = transporte.buscarVuelos(origen, destino, fInicio);
        vuelos.forEach(v -> System.out.println("  > " + v));

        // 2. Invoca al servicio de alojamiento [cite: 196]
        List<Alojamiento> hoteles = alojamiento.buscarHoteles(destino, fInicio, fFin);
        hoteles.forEach(h -> System.out.println("  > " + h));

        // 3. Localiza e invoca a la oficina de turismo correspondiente [cite: 197]
        System.out.println("  > Actividades culturales:");
        if (destino.equalsIgnoreCase("Madrid")) {
            turismoMadrid.buscarPorTipoEvento("Cultura", fInicio).forEach(a -> System.out.println("    - " + a));
        } else if (destino.equalsIgnoreCase("Barcelona")) {
            turismoBarcelona.buscarPorFecha(fInicio).forEach(a -> System.out.println("    - " + a));
        }
        
        System.out.println("--------------------------------------------------\n");
    }
}