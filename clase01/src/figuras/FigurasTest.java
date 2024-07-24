package figuras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigurasTest {

    @Test
    public void pruebaCirculo() {
        Figuras circulo = new Figuras("circulo");
        circulo.setValorLadoRadio(1);
        assertEquals("El área del circulo es de 3.141592653589793 unidades",circulo.calcularArea(circulo.getValorLadoRadio()));
    }

    @Test
    public void pruebaCuadrado() {
        Figuras cuadrado = new Figuras("cuadrado");
        cuadrado.setValorLadoRadio(0);
        assertEquals("El valor del Radio o Lado debe ser mayor que Cero",cuadrado.calcularArea(cuadrado.getValorLadoRadio()));
    }
}