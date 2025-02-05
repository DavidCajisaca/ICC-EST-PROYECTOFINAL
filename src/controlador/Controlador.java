package controlador;

import java.awt.Color;
import java.util.*;
import modelo.*;
import vista.*;

public class Controlador {
    private Laberinto laberinto;
    private Algoritmos algoritmos;
    private VentanaLaberinto ventana;

    public Controlador() {
        laberinto = new Laberinto(6, 6); // Tamaño inicial del laberinto
        algoritmos = new Algoritmos(laberinto);
        ventana = new VentanaLaberinto();
        configurarEventos();
    }

    private void configurarEventos() {
        ventana.getBtnBFS().addActionListener(e -> ejecutarBFS());
        ventana.getBtnDFS().addActionListener(e -> ejecutarDFS());
        ventana.getBtnNormal().addActionListener(e -> ejecutarNormal());
        ventana.getBtnCache().addActionListener(e -> ejecutarCache());
        ventana.getBtnReset().addActionListener(e -> ventana.resetLaberinto());
    }

    private void ejecutarBFS() {
        prepararLaberinto();
        Celda inicio = laberinto.getCelda(0, 0);  // Usamos la celda real del laberinto
        Celda destino = laberinto.getCelda(5, 5);  // Usamos la celda real del laberinto
        List<Celda> ruta = algoritmos.bfs(inicio, destino);
        mostrarRuta(ruta);
    }
    private List<Celda> obtenerVecinos(Celda actual) {
        List<Celda> vecinos = new ArrayList<>();
        int x = actual.getX();
        int y = actual.getY();
    
        // Agregar vecinos adyacentes si son transitables
        if (x > 0 && laberinto.getCelda(x - 1, y).esTransitable()) 
            vecinos.add(laberinto.getCelda(x - 1, y)); // Arriba
        if (x < laberinto.getFilas() - 1 && laberinto.getCelda(x + 1, y).esTransitable()) 
            vecinos.add(laberinto.getCelda(x + 1, y)); // Abajo
        if (y > 0 && laberinto.getCelda(x, y - 1).esTransitable()) 
            vecinos.add(laberinto.getCelda(x, y - 1)); // Izquierda
        if (y < laberinto.getColumnas() - 1 && laberinto.getCelda(x, y + 1).esTransitable()) 
            vecinos.add(laberinto.getCelda(x, y + 1)); // Derecha
    
        return vecinos;
    }
    
    private void ejecutarDFS() {
        prepararLaberinto();
        Celda inicio = laberinto.getCelda(0, 0);  // Usamos la celda real del laberinto
        Celda destino = laberinto.getCelda(5, 5);  // Usamos la celda real del laberinto
        List<Celda> ruta = algoritmos.dfs(inicio, destino);
        mostrarRuta(ruta);
    }

    private void ejecutarNormal() {
        prepararLaberinto();
        // Implementar lógica del algoritmo normal (recursión simple)
        System.out.println("Ejecutando Algoritmo Normal...");

        Celda inicio = laberinto.getCelda(0, 0);  // Definimos la celda de inicio
        Celda destino = laberinto.getCelda(5, 5);  // Definimos la celda de destino

        // Usamos una búsqueda recursiva simple para encontrar el camino
        List<Celda> ruta = buscarRecursivo(inicio, destino, new HashSet<>());
        mostrarRuta(ruta);
    }

    private List<Celda> buscarRecursivo(Celda actual, Celda destino, Set<String> visitados) {
        // Si ya hemos llegado al destino, devolvemos el camino
        if (actual.getX() == destino.getX() && actual.getY() == destino.getY()) {
            List<Celda> camino = new ArrayList<>();
            camino.add(actual);
            return camino;
        }

        visitados.add(actual.getX() + "," + actual.getY());

        // Comprobamos los vecinos
        for (Celda vecino : obtenerVecinos(actual)) {
            String key = vecino.getX() + "," + vecino.getY();
            if (!visitados.contains(key)) {
                List<Celda> caminoRecursivo = buscarRecursivo(vecino, destino, visitados);
                if (!caminoRecursivo.isEmpty()) {
                    caminoRecursivo.add(0, actual);  // Agregamos la celda actual al inicio del camino
                    return caminoRecursivo;  // Si encontramos un camino, lo devolvemos
                }
            }
        }

        return new ArrayList<>();  // Si no encontramos un camino, devolvemos una lista vacía
    }

    private void ejecutarCache() {
        prepararLaberinto();
        // Implementar lógica del algoritmo con cache
        System.out.println("Ejecutando Algoritmo con Cache...");

        Celda inicio = laberinto.getCelda(0, 0);  // Definimos la celda de inicio
        Celda destino = laberinto.getCelda(5, 5);  // Definimos la celda de destino

        // Usamos un algoritmo con cache (por ejemplo, BFS con cache)
        List<Celda> ruta = algoritmos.bfsConCache(inicio, destino);  // Llamamos al método bfsConCache
        mostrarRuta(ruta);
    }

    private void prepararLaberinto() {
        // Rellenamos el laberinto según lo que se ve en la interfaz gráfica
        for (int i = 0; i < laberinto.getFilas(); i++) {
            for (int j = 0; j < laberinto.getColumnas(); j++) {
                boolean esTransitable = ventana.getBotones()[i][j].getBackground() == Color.WHITE;
                laberinto.setCelda(i, j, esTransitable);
            }
        }
    }

    private void mostrarRuta(List<Celda> ruta) {
        // Resaltamos las celdas de la ruta
        for (Celda celda : ruta) {
            ventana.getBotones()[celda.getX()][celda.getY()].setBackground(Color.RED);
        }
    }

    public void iniciar() {
        ventana.setVisible(true);
    }
}
