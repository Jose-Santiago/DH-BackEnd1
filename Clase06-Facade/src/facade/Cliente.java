package facade;

public class Cliente {
    public static void main(String[] args) {
        ServicioTurismo busquedaVueloHotel = new ServicioTurismo();
        busquedaVueloHotel.busquedas("29/07/2024","15/08/2024","México","Chile");
    }
}
