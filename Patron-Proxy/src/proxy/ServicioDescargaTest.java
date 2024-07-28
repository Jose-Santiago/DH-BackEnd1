package proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioDescargaTest {
    @Test
    public void usuarioPremium(){
        //DADO
        TipoUsuario tipoUsr1 = TipoUsuario.Premium;
        Usuario usu1 = new Usuario("125",tipoUsr1);
        ServicioDescargaProxy descarga = new ServicioDescargaProxy();
        String resEspe = "Descarga realizada con exito";
        //CUANDO
        String resActual = descarga.descargarCancion(usu1);
        //ENTONCES
        assertEquals(resActual,resEspe);
    }

    @Test
    public void usuarioNoPremium(){
        //DADO
        TipoUsuario tipoUsr2 = TipoUsuario.Free;
        Usuario usu2 = new Usuario("020",tipoUsr2);
        ServicioDescargaProxy descarga = new ServicioDescargaProxy();
        String resEspe = "Usuario no Premium, debe suscribirse para poder Descargar canciones";
        //CUANDO
        String resActual = descarga.descargarCancion(usu2);
        System.out.println(resActual);
        //ENTONCES
        assertEquals(resActual,resEspe);
    }



}