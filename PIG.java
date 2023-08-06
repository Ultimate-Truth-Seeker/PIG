// Autor: Roberto Nájera. Contribuidor único.
// Programa para jugar a PIG entre dos jugadores
// Inspirado en el juego del canal GatherTogetherGames: https://www.youtube.com/watch?v=pJZsQ5528ZM&ab_channel=GatherTogetherGames
// Fecha de creación: 4 de agosto, 2023. Fecha de última modificación: 5 de agosto, 2023.
package PIG;
import java.util.Random; // Se importan paquetes para ciertas utilidades
import java.util.Scanner;
public class PIG {
    public static void main(String[] args) {
        die d1 = new die(); die d2 = new die(); // Se definen los objetos dado 1 y 2 para los dados
        player pl1 = new player(); // Se definen los objetos jugador 1 y 2 para los jugadores
        player pl2 = new player();
        Random r = new Random(); // Objeto random creado para simular una lanzada de dados
        int rondas = 1; // Número que representa las ronda actual en la que se está jugando
        Scanner s = new Scanner(System.in); // scanner para el ingreso de opción del jugador
        boolean b; // booleano que representará si el jugador tira los dados o no
        while (true){
            
            System.out.println("Ronda " + rondas);

            // Turno del jugador 1
            do {
                System.out.println("Turno jugador 1. ¿Desea tirar? (true o false)");
                b = s.nextBoolean(); // EL jugador ingresa true si tira los dados, falso si pasa su turno
                if (b){
                    d1.setFace(r.nextInt(1,7));// Tirada de dados, sale un número entre 1 y 6
                    d2.setFace(r.nextInt(1, 7));
                    System.out.println("Tirada de dados jugador 1: " + d1.getFace() + " "+ d2.getFace()); // Muestra el resultado
                    if (d1.getFace() == 1 || d2.getFace() == 1){
                        System.out.println("Fallaste, salió 1."); 
                        pl1.reset(); // Si sale un 1 se pierden los puntos acumulados
                        break; // Fin del turno
                    }
                    else{
                        pl1.addpoints(d1.getFace() + d2.getFace()); // Se añaden los puntos si no hay ningun 1
                        System.out.println("Has ganado "+(d1.getFace() + d2.getFace())+" puntos" );
                        if (pl1.getRound() >= 20){
                            System.out.println("Fin del turno. Ganaste en total: "+pl1.getRound());
                            break; // Fin del turno si se acumularon más de 20 puntos en la ronda
                        }
                        if (pl1.getRound() + pl1.getTotal() >= 100){
                            break; // Fin del turno automático si se detecta que ya se superaron los 100 puntos
                        }
                    }
                }
            } while (b); // Se vuelve a preguntar por tirada de dados hasta que el jugador pase su turno
            pl1.addTotal(); // Se añaden los puntos adquiridos en el turno al total

            if (pl1.getTotal() >= 100){
                System.out.println("Felicidades jugador 1, tienes más de 100 puntos");
                break; // Fin del juego y victoria para el jugador 1 si paso los 100 puntos
            }
            
            // Mismos pasos comentados para el jugador 2
            do {
                System.out.println("Turno jugador 2. ¿Desea tirar? (true o false)");
                b = s.nextBoolean();
                if (b){
                    d1.setFace(r.nextInt(1,7));
                    d2.setFace(r.nextInt(1, 7));
                    System.out.println("Tirada de dados jugador 1: " + d1.getFace() + " "+ d2.getFace());
                    if (d1.getFace() == 1 || d2.getFace() == 1){
                        System.out.println("Fallaste, salió 1.");
                        pl2.reset();
                        break;
                    }
                    else{
                        pl2.addpoints(d1.getFace() + d2.getFace());
                        System.out.println("Has ganado "+(d1.getFace() + d2.getFace())+" puntos" );
                        if (pl2.getRound() >= 20){
                            System.out.println("Fin del turno. Ganaste en total: "+pl2.getRound());
                            break;
                        }
                        if (pl2.getRound() + pl2.getTotal() >= 100){
                            break;
                        }
                    }
                }
            } while (b);
            pl2.addTotal();
            // Victoria del jugador 2
            if (pl2.getTotal() >= 100){
                System.out.println("Felicidades jugador 2, tienes más de 100 puntos");
                break;
            }
            
            // Si no hay victoria se muestra los puntos totales acumulados de cada jugador
            System.out.println("Fin de la ronda. Jugador 1: " + pl1.getTotal() + " Jugador 2: " + pl2.getTotal());
            pl1.reset(); pl2.reset(); // Se reinicia la cuenta de puntos por turno
            rondas ++; // se marca la siguiente ronda
           
        }
        s.close(); // cierre del objeto scanner
    }
}