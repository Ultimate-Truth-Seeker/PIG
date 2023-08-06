package PIG;// clase jugador
public class player {
    private int total = 0;// Puntos totales acumulados en la partida
    private int totalround = 0;// puntos totales acumulados en el turno
    public player(){
        // constructor para objetos jugador
    }
    public void addpoints(int points) {
        totalround += points; // Se añaden puntos al total obtenido en el turno
    }
    public void addTotal(){
        total += totalround; // Se añaden al total de la partida los obtenidos en la ronda
    }
    public int getTotal(){
        return total; // Retorna el total de puntos en la partida
    }
    public int getRound(){
        return totalround; // Retorna el total de puntos en el turno
    }
    public void reset(){
        totalround = 0; // Reinicia la cuenta de puntos por turno
    }
}
