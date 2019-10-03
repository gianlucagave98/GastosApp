package com.ggave.gastosapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.ggave.gastosapp.R;
import com.ggave.gastosapp.repositories.OperationsRepositoy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewOperationActivity extends AppCompatActivity {
    private EditText monto;
    private Spinner cuenta;
    private RadioButton r1,r2;
    private Button registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);
     monto = findViewById(R.id.monto_input);
     cuenta = findViewById(R.id.tipo);
     r1 = findViewById(R.id.ingreso);
     r2 = findViewById(R.id.egreso);
     registro = findViewById(R.id.registrar_button);

     registro.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
                add();
         }
     });

    }

    public void add(){
        Double mon = Double.parseDouble(monto.getText().toString());
        String cuen = cuenta.getSelectedItem().toString();
        String tipo;
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        String date = df.format((Calendar.getInstance().getTime()));
        if(r1.isChecked()){
            tipo = "Ingreso";
        }else{
            tipo = "Egreso";
        }
        OperationsRepositoy.agregar(date, mon, cuen, tipo);
        Intent intent = new Intent(NewOperationActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
