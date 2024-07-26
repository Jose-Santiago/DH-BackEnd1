package calidad;

public class Producto {
    private String nombre, envasado;
    private Integer lote, peso;

    public Producto(String nombre,Integer lote, Integer peso, String envasado) {
        this.nombre = nombre;
        this.envasado = envasado;
        this.lote = lote;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnvasado() {
        return envasado;
    }

    public void setEnvasado(String envasado) {
        this.envasado = envasado;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public Integer getPeso() {
        return peso;
    }
}
