package calidad;

public class AnalistaCalidad {
    public static void main(String[] args) {
        Producto mermelada = new Producto("Mermelada Fresa",1200,1250,"casi sano");
        Producto cafeMolido =new Producto("Cafe Negro", 1001,130,"SANO");
        Producto mezcal = new Producto("Mezcal",0,1300,"sano");


        //ControlCalidad inicial = new ControlCalidadLote();
        ControlCalidad calidadLote = new ControlCalidadLote();
        ControlCalidad calidadPeso = new ControlCalidadPeso();
        ControlCalidad calidadEnvase = new ControlCalidadEnvase();

        //inicial.setSigControlCalidad(calidadLote);
        calidadLote.setSigControlCalidad(calidadPeso);
        calidadPeso.setSigControlCalidad(calidadEnvase);

        System.out.println("-----producto a Evaluar: " + mermelada.getNombre() + "------");
        calidadLote.validarCalidad(mermelada);
        System.out.println("--------Fin Control de Calidad--------");
        //inicial.validarCalidad(mermelada);

        System.out.println("-----producto a Evaluar: " + cafeMolido.getNombre() + "------");
        calidadLote.validarCalidad(cafeMolido);
        System.out.println("--------Fin Control de Calidad--------");

        System.out.println("-----producto a Evaluar: " + mezcal.getNombre() + "------");
        calidadLote.validarCalidad(mezcal);
        System.out.println("--------Fin Control de Calidad--------");

    }
}
