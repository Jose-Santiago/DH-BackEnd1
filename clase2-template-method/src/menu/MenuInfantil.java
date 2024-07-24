package menu;

public class MenuInfantil extends TemplateMenu{
    private Integer numeroJuguetes;

    public MenuInfantil(double precioBase, Integer numJuguetes) {
        super(precioBase);
        this.numeroJuguetes = numJuguetes;
    }

    public Integer getNumeroJuguetes() {
        return numeroJuguetes;
    }

    public void setNumeroJuguetes(Integer numeroJuguetes) {
        this.numeroJuguetes = numeroJuguetes;
    }

    @Override
    public double calcularPrecio() {
        double extraJuguetes= 3 * numeroJuguetes;

        return (super.getPrecioBase() + extraJuguetes);
    }

    @Override
    public String armarMenu() {
        return "Los mismos ingredientes que menu clasico, más " + numeroJuguetes + " juguetes.";
    }
}
