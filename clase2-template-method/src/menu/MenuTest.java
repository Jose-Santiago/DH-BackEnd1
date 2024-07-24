package menu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MenuTest {
    Empleado juan = new Empleado("Juan");

    @Test
    public void testMenuClasico(){
        //DADO
        TemplateMenu menuClasico = new MenuClasico(10);
        TemplateMenu menuVegeta = new MenuVegetariano(10,2,5);
        //CUANDO
        juan.agregarMenu(menuClasico);

        //ENTONCES
        assertEquals("El Menu a Armar es: Solo ingredientes clasicos, sin ingredintes extras y sin juguetes El Precio del menu es: 10.0",juan.prepararMenu(menuClasico));

        //assertEquals("",juan.prepararMenu(menuVegeta));
    }

    @Test
    public void testMenuInfantil(){
        //DADO
        TemplateMenu menuInfante = new MenuInfantil(10, 3);
        //CUANDO
        juan.agregarMenu(menuInfante);
        //ENTONCES
        assertEquals("El Menu a Armar es: Los mismos ingredientes que menu clasico, más 3 juguetes. El Precio del menu es: 19.0", juan.prepararMenu(menuInfante));
    }

    @Test
    public void testMenuVegetariano(){
        //DADO
        TemplateMenu menuVegeta = new MenuVegetariano(10,2,5);
        //CUANDO
        juan.agregarMenu(menuVegeta);
        //ENTONCES
        assertEquals("El Menu a Armar es: Mismos ingredientes de menu Clasico, mas: 2 especias importe: 0.2 mas: 5 Salsas vegetarianas importe: 10 El Precio del menu es: 20.2", juan.prepararMenu(menuVegeta));
    }
}