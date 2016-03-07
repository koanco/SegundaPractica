package johannpolania.com.tercerprograma;

/**
 * Created by koanco on 6/03/2016.
 */
public class Rectangulo extends Figura {
    private double base;
    private double altura;

    public  Rectangulo(double base, double altura)
    {
        this.base=base;
        this.altura=altura;

    }

    public String calcularArea()
    {String resultado=String.valueOf(base*altura);
        return resultado;

    }


}
