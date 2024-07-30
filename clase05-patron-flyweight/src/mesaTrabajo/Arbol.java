package mesaTrabajo;

public class Arbol {
    private Integer alto;
    private Integer ancho;
    private String color, tipo;
    public static Integer contador = 0;

    public Arbol(String tipo) {
        this.tipo = tipo;
        contador++;
    }

    public Integer getAlto() {
        return alto;
    }

    public Integer getAncho() {
        return ancho;
    }

    public String getColor() {
        return color;
    }

    public String getTipo() {
        return tipo;
    }

    public static Integer getContador() {
        return contador;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
