package PIG; // clase dado
public class die {
    private int face; // valor de la cara actual del dado
    public die(){
        // Constructor
    }
    public int getFace(){
        return face; // retorna el valor actual de la cara
    }
    public void setFace(int face){
        this.face = face; // cambia el valor de la cara a cierto número
    }

}
