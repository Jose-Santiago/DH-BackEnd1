package menu;

public class MenuClasico extends TemplateMenu{
    public MenuClasico(double precioBase) {
        super(precioBase);
    }

    @Override
    public double calcularPrecio() {
        return super.getPrecioBase();
    }

    @Override
    public String armarMenu() {
        return "Solo ingredientes clasicos, sin ingredintes extras y sin juguetes";
    }
}
