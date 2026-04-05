/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main;

import java.io.IOException;
import java.util.List;

/**
 * Interfaz que define las operaciones personalizadas solicitadas por el cliente.
 */
public interface IMaquetadorAvanzado {
    
    // 1) Unir dos ficheros de texto [cite: 61]
    void unirFicheros(String f1, String f2, String dest) throws IOException;
    
    // 2) Combinar párrafos intercalados de ambos ficheros [cite: 62, 63]
    void combinarFicheros(String f1, String f2, String dest, List<int[]> rangos) throws IOException;
    
    // 3) Separar un fichero en varios puntos de corte [cite: 64]
    void separarEnVarios(String origen, List<Integer> cortes) throws IOException;
}
