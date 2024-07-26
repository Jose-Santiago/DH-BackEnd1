package calidad;

public class ControlCalidadLote extends ControlCalidad{
    private ControlCalidad sigControlCalidad;

    @Override
    public void validarCalidad(Producto producto) {
        Integer loteProducto = producto.getLote();
        if((loteProducto >= 1000) && (loteProducto <= 2000)){
            System.out.println("El Producto paso la prueba de calidad de Lote");
            if(sigControlCalidad != null)sigControlCalidad.validarCalidad(producto);
        }else {
            System.out.println("Producto Rechazado, no paso la Prueba de Calidad en Lote!!! "+ "\n" +"El lote se encuantra Mal!!!");
        }
    }

    @Override
    public void setSigControlCalidad(ControlCalidad sigControlCalidad) {
        this.sigControlCalidad = sigControlCalidad;
    }
}
