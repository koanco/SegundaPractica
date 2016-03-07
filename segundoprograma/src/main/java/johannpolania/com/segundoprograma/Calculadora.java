package johannpolania.com.segundoprograma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {
    private EditText primero;
    private EditText segundo;
    private TextView resul;
    private RadioGroup grupo;
    private RadioButton opcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        primero=(EditText)findViewById(R.id.primerNumero);
        segundo=(EditText)findViewById(R.id.segundoNumero);
        resul=(TextView)findViewById(R.id.resultado);
        Button botoncillo=(Button)findViewById(R.id.boton);
        grupo=(RadioGroup)findViewById(R.id.rOperacion);
        botoncillo.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View v) {
                int opc=0;
                String cadena1="",cadena2="",cadena3="";
                cadena1=String.valueOf(primero);
                cadena2=String.valueOf(segundo);
                double resultado=0;
                if(isDouble(cadena1) && isDouble(cadena2)) {
                    double numero1 = Double.parseDouble(primero.getText().toString());
                    double numero2 = Double.parseDouble(segundo.getText().toString());
                    opc = grupo.getCheckedRadioButtonId();
                    opcion = (RadioButton) findViewById(opc);


                    switch (grupo.getCheckedRadioButtonId()) {
                        case R.id.rSuma:
                            System.out.println("Se calculará la suma");
                            resultado = numero1 + numero2;
                            cadena3 = String.valueOf(resultado);
                            resul.setText(cadena3);
                            break;

                        case R.id.rResta:
                            System.out.println("Se calculará la resta");
                            resultado = numero1 - numero2;
                            cadena3 = String.valueOf(resultado);
                            resul.setText(cadena3);
                            break;

                        case R.id.rProducto:
                            System.out.println("Se calculará la suma");
                            resultado = numero1 * numero2;
                            cadena3 = String.valueOf(resultado);
                            resul.setText(cadena3);
                            break;
                        case R.id.rDivision:
                            if (numero2 != 0) {

                                resultado = numero1 / numero2;
                                cadena3 = String.valueOf(resultado);
                                resul.setText(cadena3);
                            } else {
                                resul.setText("División por cero, indefinido");

                            }

                            break;


                    }
                }
                else
                {
                    resul.setText("datos no son numéricos");
                }
            }
        });


    }
    private static boolean isDouble(String numero)
    { try {
        Double.parseDouble(numero);
          return  true;
       }
    catch (NumberFormatException ex)
    {
        return false;

    }



    }

}
