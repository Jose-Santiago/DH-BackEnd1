package calidad;

public class ControlCalidadEnvase extends ControlCalidad{
    private ControlCalidad sigControlCalidad;

    @Override
    public void validarCalidad(Producto producto) {
        String envaseProducto = producto.getEnvasado();
        if((envaseProducto.equalsIgnoreCase("sano")) || (envaseProducto.equalsIgnoreCase("casi sano"))){
            System.out.println("El Producto paso la prueba de calidad de Envasado" + "\n" + "!!!!Producto Aceptado!!!!");
            if(sigControlCalidad != null)sigControlCalidad.validarCalidad(producto);

        }else {
            System.out.println("Producto Rechazado, no paso la Prueba de Calidad en Envasado!!! "+ "\n" +"El lote se encuantra Mal!!!");
        }
    }

    @Override
    public void setSigControlCalidad(ControlCalidad sigControlCalidad) {
        this.sigControlCalidad = sigControlCalidad;
    }
}
