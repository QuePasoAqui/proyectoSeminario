package com.example.od652.proyectoseminario;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class jugar extends AppCompatActivity{
    private String[] nombre_pokemon={"charmander","bulbasaur","squirtle"};
    private String[] sombra_pokemon={"s_charmander","s_bulbasaur","s_squirtle"};
    private int intentos=3;
    private Button aceptar;
    private TextView mensaje_intentos, mensaje_cuenta;
    private EditText usuario_pokemon;
    private ImageView mi_imagen;
    private int numero_generado=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jugar);
        aceptar=(Button)findViewById(R.id.btnAceptar);
        mensaje_intentos=(TextView)findViewById(R.id.lblIntentos);
        mensaje_cuenta=(TextView)findViewById(R.id.lblCuenta);
        usuario_pokemon=(EditText)findViewById(R.id.txtIDPokemon);
        mi_imagen=(ImageView)findViewById(R.id.imageView2);
        numero_generado=generarAleatorio();
        establecer_sombra(numero_generado);
        mensaje_intentos.setText("Tiene " + intentos + " intentos");
        aceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String nombre = usuario_pokemon.getText().toString().toLowerCase();
                if(nombre.equals(nombre_pokemon[numero_generado]))
                {
                    establecer_pokemon(numero_generado);
                    esperar();
                }
                else{
                    Toast.makeText(getApplicationContext(),"No es el pokemon", Toast.LENGTH_SHORT).show();
                    intentos=intentos-1;
                    mensaje_intentos.setText("Tiene " + intentos + " intentos");
                }
                if(intentos==0)
                {
                    finish();
                }
            }
        });
    }
    private void establecer_sombra(int numero){
        int resId = getResources().getIdentifier(sombra_pokemon[numero_generado],"drawable", getPackageName());
        mi_imagen.setImageResource(resId);
    }
    private void establecer_pokemon(int numero){
        int resId = getResources().getIdentifier(nombre_pokemon[numero_generado],"drawable", getPackageName());
        mi_imagen.setImageResource(resId);
    }
    private int generarAleatorio(){
        return (int)(Math.random()*nombre_pokemon.length);
    }
    public void esperar(){
        new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long l) {

                mensaje_cuenta.setText("Generando en " + (l/1000));
            }

            @Override
            public void onFinish() {
                numero_generado=generarAleatorio();
                establecer_sombra(numero_generado);
                mensaje_cuenta.setText("");
                usuario_pokemon.setText("");
            }
        }.start();
    }
}


