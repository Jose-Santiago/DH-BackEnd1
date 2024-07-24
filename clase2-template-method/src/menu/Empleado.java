package menu;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    List<TemplateMenu> paqueteDeMenus;

    public Empleado(String nombre) {
        this.nombre = nombre;
        paqueteDeMenus = new ArrayList<>();
    }
    public void agregarMenu(TemplateMenu menu){
        this.paqueteDeMenus.add(menu);
    }
    public String prepararMenu(TemplateMenu menu){
        return "El Menu a Armar es: " + menu.armarMenu() +
        " El Precio del menu es: " + menu.calcularPrecio();
    }
    public double calcularPrecioPaquete(){
        double total = 0;
        for(TemplateMenu menu: paqueteDeMenus){
            total += menu.calcularPrecio();
        }
        System.out.println("El Costo Final del Paquete de Menus es: "+ total);
        return total;
    }

}
