package com.ggave.gastosapp.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ggave.gastosapp.R;
import com.ggave.gastosapp.models.Operation;
import com.ggave.gastosapp.repositories.OperationsRepositoy;

import static com.ggave.gastosapp.repositories.OperationsRepositoy.total;

public class MainActivity extends AppCompatActivity {

    ImageButton ahorro_button, credito_button, efectivo_button;
    TextView montoAhorro;
    TextView montoCredito;
    TextView montoEfectivo;
    ProgressBar progress;
    FloatingActionButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        montoAhorro = findViewById(R.id.montoAhorro_text);
        montoCredito = findViewById(R.id.montoCredito_text);
        montoEfectivo = findViewById(R.id.montoEfectivo_text);
        ahorro_button= findViewById(R.id.buscar_ahorro);
        credito_button = findViewById(R.id.buscar_credito);
        efectivo_button = findViewById(R.id.buscar_efectivo);
        progress = findViewById(R.id.progressbar1);

        Double num = OperationsRepositoy.total_global();
        progress.setProgress((int)Math.round(num));

        double totalAhorro = OperationsRepositoy.total("Ahorro");
        double totalCredito = OperationsRepositoy.total("Tarjeta de credito");
        double totalEfectivo = OperationsRepositoy.total("Efectivo");

        montoEfectivo.setText("S/."+String.valueOf(totalEfectivo));
        montoAhorro.setText("S/."+String.valueOf(totalAhorro));
        montoCredito.setText("S/."+String.valueOf(totalCredito));

        ahorro_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DetailActivity.class);
                i.putExtra("valor","Ahorro");
                startActivity(i);
            }
        });

        credito_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DetailActivity.class);
                i.putExtra("valor","Tarjeta de credito");
                startActivity(i);
            }
        });

        efectivo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DetailActivity.class);
                i.putExtra("valor","Efectivo");
                startActivity(i);
            }
        });

        add = findViewById(R.id.agregar);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_register();
            }
        });

    }

    public void call_register(){
        Intent intent = new Intent(this, NewOperationActivity.class);
        startActivity(intent);

    }
}
