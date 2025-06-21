package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.model.Datos;
import com.aluracursos.desafio.model.DatosLibros;
import com.aluracursos.desafio.service.ConsumoAPI;
import com.aluracursos.desafio.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);

    public void muestraElMenu(){
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        //Top 10 Libros más descargados
        System.out.println("Top 10 Libros más descargados");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numerDeDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

        //Busqueda de libros pro nombre
        System.out.println("Ingrese el nombre del libro que desea buscar");
        var tituloLibro = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()){
            System.out.println("Libro Encontrado");
            System.out.println(libroBuscado.get());
        } else {
            System.out.println("Libro No Encontrado");
        }

        //Busqueda de libros entre fechas específicas
        System.out.println("Ingresa el año de inicio que desea buscar (por ejemplo 1800) ");
        var yearStart = teclado.nextInt();
        System.out.println("Ingresa el año de fin que desea buscar (por ejemplo 1899) ");
        var yearEnd = teclado.nextInt();
        teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE + "?author_year_start=" + yearStart + "&author_year_end=" + yearEnd);
        var yearsBusqueda = conversor.obtenerDatos(json, Datos.class);
        if (yearsBusqueda.resultados().isEmpty()) {
            System.out.println("No se encontraron libros con autores vivos entre los años " + yearStart + " y " + yearEnd + ".");
        } else {
            System.out.println("\nLibros encontrados con autores vivos entre los años " + yearStart + " y " + yearEnd + ":");
            yearsBusqueda.resultados().stream()
                    .map(DatosLibros::titulo)
                    .forEach(System.out::println);
        }

        //Trabajando con estadisticas
        DoubleSummaryStatistics est = datos.resultados().stream()
                .filter(d -> d.numerDeDescargas() > 0)
                .collect(Collectors.summarizingDouble(DatosLibros::numerDeDescargas));
        System.out.println("Cantidad media de descargas: " + est.getAverage());
        System.out.println("Cantidad máxima de descargas: " + est.getMax());
        System.out.println("Cantidad minima de descargas: " +est.getMin());
        System.out.println("Cantidad de registros evaluados para calcular las estadisticas: " + est.getCount());
    }
}
