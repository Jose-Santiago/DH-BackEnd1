package menu;

public abstract class TemplateMenu {
    private double precioBase;

    public TemplateMenu(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }


    public abstract double calcularPrecio();
    public abstract String armarMenu();
}
