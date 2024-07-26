package calidad;

public class ControlCalidadPeso extends ControlCalidad{
    private ControlCalidad sigControlCalidad;

    @Override
    public void validarCalidad(Producto producto) {
        Integer pesoProducto = producto.getPeso();
        if((pesoProducto >= 1200) && (pesoProducto <= 1300)){
            System.out.println("El Producto paso la prueba de calidad de Peso");
            if(sigControlCalidad != null)sigControlCalidad.validarCalidad(producto);
        }else {
            System.out.println("Producto Rechazado, no paso la Prueba de Calidad en Peso!! "+ "\n" +"El lote se encuantra Mal!!!");
        }
    }

    @Override
    public void setSigControlCalidad(ControlCalidad sigControlCalidad) {
        this.sigControlCalidad = sigControlCalidad;
    }
}
