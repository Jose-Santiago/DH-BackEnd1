package calidad;

public abstract class ControlCalidad {
    private ControlCalidad sigControlCalidad;

    public void setSigControlCalidad(ControlCalidad controlCalidad) {
        this.sigControlCalidad = controlCalidad;
    }

    abstract void validarCalidad(Producto producto);
}
