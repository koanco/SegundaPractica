package johannpolania.com.tercerprograma;

/**
 * Created by koanco on 6/03/2016.
 */
public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio)
    {
        this.radio=radio;

    }

    public String calcularArea()
    {
        String resultado=String.valueOf((Math.PI)*Math.pow(radio,2));
        return resultado;

    }


}
