/*
En un puerto se alquilan amarres para barcos de distinto tipo. Para cada Alquiler se guarda: el
nombre, documento del cliente, la fecha de alquiler, fecha de devolución, la posición del
amarre y el barco que lo ocupará.
Un Barco se caracteriza por: su matrícula, su eslora en metros y año de fabricación.
Sin embargo, se pretende diferenciar la información de algunos tipos de barcos especiales:
• Número de mástiles para veleros.
• Potencia en CV para barcos a motor.
• Potencia en CV y número de camarotes para yates de lujo.
Un alquiler se calcula multiplicando el número de días de ocupación (calculado con la fecha de
alquiler y devolución), por un valor módulo de cada barco (obtenido simplemente
multiplicando por 10 los metros de eslora).
En los barcos de tipo especial el módulo de cada barco se calcula sacando el módulo normal y
sumándole el atributo particular de cada barco. En los veleros se suma el número de mástiles,
en los barcos a motor se le suma la potencia en CV y en los yates se suma la potencia en CV y
el número de camarotes.
Utilizando la herencia de forma apropiada, deberemos programar en Java, las clases y los
métodos necesarios que permitan al usuario elegir el barco que quiera alquilar y mostrarle el
precio final de su alquiler.
 */
package Servicio;

import Entidades.Alquiler;
import Entidades.Velero;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class AlquilerServicio {

    public Alquiler crearAlquiler(Scanner sc) {
        System.out.println("Ingrese su nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su DNI");
        Integer dni = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese la fecha de inicio de alquiler del barco (DD/MM/AAAA)");
        String inicio = sc.nextLine();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio = null;
        try {
            fechaInicio = format.parse(inicio);
        } catch (ParseException e) {
            System.out.println("no se tomo bien la fecha de inicio");
        }

        System.out.println("Ingrese la fecha de devolucion del barco (DD/MM/AAAA)");
        String devolucion = sc.nextLine();
        Date fechaDevolucion = null;
        try {
            fechaDevolucion = format.parse(devolucion);
        } catch (ParseException e) {
            System.out.println("no se tomo bien la fecha de devolucion");
        }

        LocalDate fecha1 = LocalDate.of(fechaInicio.getYear(), fechaInicio.getMonth(), fechaInicio.getDate());
        LocalDate fecha2 = LocalDate.of(fechaDevolucion.getYear(), fechaDevolucion.getMonth(), fechaDevolucion.getDate());

        long diferenciaDias = fecha1.until(fecha2, ChronoUnit.DAYS);
        //System.out.println("Diferencia de días: " + diferenciaDias);
    
        
        Velero velero = new Velero(5,2356,20,2023);
        

//        System.out.println("Que barco desea alquilar?");
//        System.out.println("1) Barco");
//        System.out.println("2) Barco a motor");
//        System.out.println("3) Velero");
//        System.out.println("4) Yate");
//        
        return new Alquiler(nombre, dni, fechaInicio, fechaDevolucion,velero);
    }
    
}
