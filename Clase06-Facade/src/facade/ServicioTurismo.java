package facade;

public class ServicioTurismo implements IServicioTurismo{
    private APIVuelo vuelo;
    private APIHotel hotel;

    public ServicioTurismo() {
        vuelo = new APIVuelo();
        hotel = new APIHotel();

    }

    @Override
    public void busquedas(String salida, String regreso, String origen, String destino) {
        vuelo.busquedaVuelos(salida,regreso,origen,destino);
        hotel.busquedaHoteles(salida, regreso, destino);
    }
}
