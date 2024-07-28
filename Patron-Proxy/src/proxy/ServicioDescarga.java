package proxy;

public class ServicioDescarga implements ServicioSpotifyPago{
    @Override
    public String descargarCancion(Usuario usuario) {
        System.out.println(".....Verificando Datos de Usuario.....");
        System.out.println("Cancion Descargada con Exito!!!");
        System.out.println("Datos del Usuario, ID: "+usuario.getId() + "----Tipo Usuario: "+usuario.getTipo().name());
        return "Descarga realizada con exito";
    }
}
