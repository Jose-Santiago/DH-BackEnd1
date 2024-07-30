package facade;

public class APIHotel {
    private String entrada, salida;
    private String ciudad;

    public APIHotel() {

    }

    public void busquedaHoteles(String entrada, String salida, String ciudad){
        System.out.println("Estos son los resultados de la Busqueda de Hoteles con los datos:");
        System.out.println("Fecha Entrada: " + entrada);
        System.out.println("Fecha Salida: " + salida);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("*******************************************");
    }
}
