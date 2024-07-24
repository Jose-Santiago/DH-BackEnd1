package menu;

public class MenuVegetariano extends TemplateMenu{
    private Integer numeroEspecias;
    private Integer numeroSalsas;

    public MenuVegetariano(double precioBase, Integer numEspecias, Integer numSalsas) {
        super(precioBase);
        this.numeroSalsas = numSalsas;
        this.numeroEspecias = numEspecias;
    }

    public void setNumeroEspecias(Integer numeroEspecias) {
        this.numeroEspecias = numeroEspecias;
    }

    public void setNumeroSalsas(Integer numeroSalsas) {
        this.numeroSalsas = numeroSalsas;
    }

    @Override
    public double calcularPrecio() {
        double importeEspecias = (super.getPrecioBase() * (numeroEspecias/100.0));
        double importeSalsas = (2 * numeroSalsas);
        return (super.getPrecioBase() + importeSalsas + importeEspecias);
    }

    @Override
    public String armarMenu() {
        String resp = "Mismos ingredientes de menu Clasico, " +
                "mas: " + numeroEspecias + " especias importe: " +
                (super.getPrecioBase() * (numeroEspecias / 100.0)) +
                " mas: " + numeroSalsas + " Salsas vegetarianas importe: " +
                (2 * numeroSalsas);
        return resp;
    }

}
