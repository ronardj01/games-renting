package com.mycompany.renting;

/**
 *
 * @author ronar
 */
public class Renting {

    public static void main(String[] args) {

        // CADENAS FORMATEADAS PARA EL NOMBRE DE LA COMPAÑIA Y LOS ENCABEZADOS
        String companyName = String.format("\n%50s\n", "*** O V E R L O R D ***"); // JAJAJAJAJAJ
        String bienvenida = String.format("%70s\n", "Bienvenido a su Tienda favorita de Alquiler de Video Juegos");
        String encabezadoVistaConsola = String.format("%-30s %-14s Estanteria\n", "Juegos", "Unidades");
        String encabezadoCodigoJuego = String.format("\n%65s", "Favor introducir el código del video juego: over-234p");
        
        System.out.println(companyName);
        System.out.println(bienvenida);
        System.out.println(encabezadoVistaConsola);
        System.out.println(encabezadoCodigoJuego);
    }
}
