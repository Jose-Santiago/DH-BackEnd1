package proxy;

public class ServicioDescargaProxy implements ServicioSpotifyPago{
    private ServicioDescarga servicioDescarga;

    public ServicioDescargaProxy() {
        servicioDescarga = new ServicioDescarga();
    }

    @Override
    public String descargarCancion(Usuario usuario) {
        System.out.println(".....Verificando Datos de Usuario.....");
        if(usuario.getTipo().name().equalsIgnoreCase("Premium")){
            return servicioDescarga.descargarCancion(usuario);
        }else{
            System.out.println("Datos del Usuario, ID: "+usuario.getId() + "----Tipo Usuario: "+usuario.getTipo().name());
            return "Usuario no Premium, debe suscribirse para poder Descargar canciones";
        }
    }
}
