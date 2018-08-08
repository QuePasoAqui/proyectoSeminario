package com.example.od652.proyectoseminario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button jugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        jugar=(Button)findViewById(R.id.btnJugar);
        jugar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent nuevoForm=new Intent(MainActivity.this,jugar.class);
                startActivity(nuevoForm);
            }


        });
    }
}
