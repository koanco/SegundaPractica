package johannpolania.com.cuartoprograma;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {
private EditText login;
    private EditText password;
    private EditText password2;
    private EditText correo;
    private RadioGroup grupo;
    private TextView fecha;
    private TextView resultado;
    private Spinner ciudades;
    private String tCiudad;
    private String genero;
    private ArrayList<String> hobbies;
    private Button boton;

       public Registro()
    {  tCiudad="Bogota";
       hobbies=new ArrayList<String>();
        genero="";

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        final String [] datos=new String[]{"Bogota","Medellin","Armenia","Pereira","Quibdó","Neiva","Cartagena","Santa Marta","Ibagué","Cucuta","Bucaramanga","Cali"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datos);
        login=(EditText)findViewById(R.id.login);
        password=(EditText)findViewById(R.id.password);
        password2=(EditText)findViewById(R.id.password2);
        correo=(EditText)findViewById(R.id.email);
        grupo=(RadioGroup)findViewById(R.id.grupo);
        fecha=(TextView)findViewById(R.id.fecha);
        ciudades=(Spinner)findViewById(R.id.ciudades);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ciudades.setAdapter(adaptador);
        boton=(Button)findViewById(R.id.ingresar);
        resultado=(TextView)findViewById(R.id.resultado);




        ciudades.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        tCiudad=parent.getItemAtPosition(position).toString();
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        tCiudad="";
                    }
                });
        boton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                switch(grupo.getCheckedRadioButtonId())
                {case R.id.masculino:
                    genero="Masculino";
                    break;
                    case R.id.femenino:
                        genero="Femenino";
                        break;
                }

                if(login.getText().toString().equals("") || password.getText().toString().equals("") || password2.getText().toString().equals("") || correo.getText().toString().equals("")
                        || tCiudad.equals("") || genero.equals("") || revisarHobbies().equals("") || fecha.getText().toString().equals(""))

                {
                    resultado.setText("Faltan datos por diligencia");

                }
                else

                if(password.getText().toString().equals(password2.getText().toString()))
                {


                    resultado.setText("Login: "+login.getText().toString()+"\n"+"Password: "+password.getText().toString()+
                    "\n"+"Correo: "+correo.getText().toString()+"\n"+"Ciudad de origen :"+tCiudad+"\n"+"Sexo : "+genero+"\n"+"Hobbies: "+revisarHobbies()+"\n"
                    +"Fecha de nacimiento: "+fecha.getText().toString()+"\n"
                    );

                }
                else
                {
                    resultado.setText("Contraseñas no coinciden");
                }




            }
        });
}

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

    public String revisarHobbies()
    {
        String hobbiesFinal="";
        if(((CheckBox)(findViewById(R.id.c1))).isChecked())
        {
            hobbies.add(0,"Escuchar musica\n");

        }
        else
        {
            hobbies.add(0,"");

        }

        if(((CheckBox)(findViewById(R.id.c2))).isChecked())
        {
            hobbies.add(1,"Leer\n");

        }
        else
        {
            hobbies.add(1, "");

        }


        if(((CheckBox)(findViewById(R.id.c3))).isChecked())
        {
            hobbies.add(2,"Nadar\n");

        }
        else
        {
            hobbies.add(2, "");

        }

        if(((CheckBox)(findViewById(R.id.c4))).isChecked())
        {
            hobbies.add(3,"Beber\n");

        }
        else
        {
            hobbies.add(3, "");

        }
        for(int i=0;i<4;i++)
        {
            hobbiesFinal+=hobbies.get(i);


        }


return hobbiesFinal;

    }
}
