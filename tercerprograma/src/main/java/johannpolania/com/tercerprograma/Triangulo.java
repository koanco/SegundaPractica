package johannpolania.com.tercerprograma;

/**
 * Created by koanco on 6/03/2016.
 */
public class Triangulo extends Figura {
    private double base;
     private double altura;

    public Triangulo(double base, double altura)
    {
        this.base=base;
        this.altura=altura;

    }
    public String calcularArea()
    { String area="";
        area=String.valueOf(base*altura/2);
        return area;


    }


}
