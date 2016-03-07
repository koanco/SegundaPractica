package johannpolania.com.tercerprograma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TestFigura extends AppCompatActivity {
    private EditText dato1;
   private EditText dato2;
    private TextView resultado;
    private RadioGroup grupo;
    private int opcion;
    private Button boton;


    public TestFigura()
    {
        opcion=0;

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figuras);
       dato1=(EditText)findViewById(R.id.dato);
        dato2=(EditText)findViewById(R.id.dato2);
        resultado=(TextView)findViewById(R.id.resultado);
        grupo=(RadioGroup)(findViewById(R.id.grupo));
         boton=(Button)(findViewById(R.id.calcular));

        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {case R.id.rCirculo:
                    dato1.setVisibility(View.VISIBLE);
                    dato2.setVisibility(View.INVISIBLE);
                    dato1.setHint("Radio");
                    resultado.setVisibility(View.INVISIBLE);
                    boton.setVisibility(View.VISIBLE);
                    opcion=1;
                    dato1.setText("");
                    dato2.setText("");
                     break;
                    case R.id.rTriangulo:
                        dato1.setHint("Base");
                        dato1.setVisibility(View.VISIBLE);
                        dato2.setVisibility(View.VISIBLE);
                        dato2.setHint("Altura");
                        resultado.setVisibility(View.INVISIBLE);
                        boton.setVisibility(View.VISIBLE);
                        opcion=2;
                        dato1.setText("");
                        dato2.setText("");
                        break;
                    case R.id.rCuadrado:
                        dato1.setVisibility(View.VISIBLE);
                        dato1.setHint("lado");
                        dato2.setVisibility(View.INVISIBLE);
                        dato1.setText("");
                        dato2.setText("");
                        opcion=3;
                        resultado.setVisibility(View.INVISIBLE);
                        boton.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rRectangulo:
                        dato1.setVisibility(View.VISIBLE);
                        dato1.setHint("base");
                        dato1.setText("");
                        dato2.setVisibility(View.VISIBLE);
                        dato2.setText("");
                        dato2.setHint("Altura");
                        resultado.setVisibility(View.INVISIBLE);
                        boton.setVisibility(View.VISIBLE);
                        opcion=4;
                        break;



                }

            }
        });
        boton.setOnClickListener(new View.OnClickListener() {
            Figura figura;
            boolean estado=false;
            public void onClick(View v) {

                if(opcion>=1 && opcion<=4) {
                    switch (opcion) {
                        case 1:
                            if(!(dato1.getText().toString().equals("")))
                            {figura = new Circulo(Double.parseDouble(dato1.getText().toString()));
                                estado=true;
                            }
                            break;
                        case 2:
                            if(!(dato1.getText().toString().equals("") || dato2.getText().toString().equals("")) )
                            {figura = new Triangulo(Double.parseDouble(dato1.getText().toString()), Double.parseDouble(dato2.getText().toString()));
                                estado=true;
                            }

                            break;
                        case 3:
                            if(!(dato1.getText().toString().equals("")))
                            {figura = new Rectangulo(Double.parseDouble(dato1.getText().toString()), Double.parseDouble(dato1.getText().toString()));
                                estado=true;
                            }

                            break;
                        case 4:
                            if(!(dato1.getText().toString().equals("") || dato2.getText().toString().equals("")) )
                            {figura = new Rectangulo(Double.parseDouble(dato1.getText().toString()), Double.parseDouble(dato2.getText().toString()));
                                estado=true;
                            }

                            break;

                    }
                    if(estado==true) {
                        resultado.setText(figura.calcularArea());
                        resultado.setVisibility(View.VISIBLE);
                        opcion = 0;
                    }
                    else
                    {
                        resultado.setText("Faltan campos por diligenciar de la figura geométrica");
                        resultado.setVisibility(View.VISIBLE);
                        opcion = 0;

                    }
                }
                else
                {resultado.setText("Ingrese primero una opción de figura");
                    resultado.setVisibility(View.VISIBLE);

                }

            }
        });

    }
}
