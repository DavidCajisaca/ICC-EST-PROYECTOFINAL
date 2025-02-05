 UNIVERSIDAD POLITECNICA SALECIANA
Docente:
Ing. Pablo Torres
Integrantes:
Dennis Cajisaca, Christian Astudillo
Carrera:
Ingeniería en ciencias de la computación


1.	Descripción del problema 
Este proyecto tiene como objetivo crear una aplicación que ayude a hallar la ruta más breve dentro de un laberinto determinado por el usuario. El usuario tiene la posibilidad de ajustar el tamaño del laberinto, establecer celdas que pueden ser transitadas y no transitadas, así como elegir un punto de inicio y destino. Se utilizan varios algoritmos de búsqueda para medir su eficacia y eficiencia.

2.	Propuesta de solución 
Programación Dinámica
Es una técnica de optimización utilizada para resolver problemas dividiéndolos en subproblemas más pequeños y resolviendo cada uno solo una vez para mejorar la eficiencia computacional.
Algoritmo BFS 
Es un algoritmo de búsqueda en grafos que explora todos los nodos vecinos en el mismo nivel antes de pasar a los siguientes niveles, garantizando encontrar el camino más corto en grafos no ponderados.
Algoritmo DFS 
Es una estrategia de búsqueda que explora lo más profundo posible en un grafo antes de retroceder. Aunque es eficiente en algunos casos, no siempre encuentra el camino más corto.
2.2. Descripción de la Solución
Se ha desarrollado una aplicación en Java con una interfaz gráfica que permite:
•	Configurar el tamaño del laberinto.
•	Seleccionar celdas transitables y no transitables.
•	Definir un punto de inicio y destino.
•	Ejecutar la búsqueda del camino más corto usando BFS.
•	Reiniciar la configuración del laberinto.
2.3. Herramientas y Lenguajes Utilizados
•	Lenguaje de Programación: Java
•	Bibliotecas: Swing para la interfaz gráfica
•	Entorno de Desarrollo: VSC


3.	Capturas de la implementación final de la UI
![image](https://github.com/user-attachments/assets/ec322a3a-91b6-4863-b8ae-029dce379d55)

![image](https://github.com/user-attachments/assets/0706a7d8-4ab5-4593-9e78-011d498b7f02)


4.	Conclusiones 
Se concluye que BFS es el algoritmo más adecuado para encontrar el camino más corto en un laberinto debido a su estrategia de exploración por niveles. DFS, aunque funcional, no garantiza encontrar la ruta óptima en ciertos casos.

5.	Consideraciones 
•	Se podría optimizar la interfaz para permitir configuraciones más avanzadas.
•	Se podría implementar en juegos de laberintos y rompecabezas.
•	Se podría implementar en sistemas de navegación y planificación de rutas.
•	Se podría implementar en problemas de inteligencia artificial y robots autónomos.

