package figuras;

public class Figuras {
    private String tipo;
    private double valorLadoRadio;

    public Figuras(String tipo) {
        this.tipo = tipo;
    }

    public double getValorLadoRadio() {
        return valorLadoRadio;
    }

    public void setValorLadoRadio(double valorLadoRadio) {
        if(valorLadoRadio > 0){
            this.valorLadoRadio = valorLadoRadio;
        }else {
            System.out.println("El valor del Radio o Lado debe ser mayor que Cero");
            this.valorLadoRadio = 0;
        }
    }

    public String calcularArea(double valorLadoRadio) {
        String respuesta = "";
        double area = 0;
        if(valorLadoRadio > 0){
            if (tipo.equals("cuadrado"))area = valorLadoRadio * valorLadoRadio;
            if (tipo.equals("circulo")) area = (Math.PI * (valorLadoRadio * valorLadoRadio));
            respuesta = "El área del " + tipo + " es de " + area + " unidades";
        }else {
            respuesta = "El valor del Radio o Lado debe ser mayor que Cero";
        }
        return respuesta;
    }
}
