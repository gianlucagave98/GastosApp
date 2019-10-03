package com.ggave.gastosapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ggave.gastosapp.R;
import com.ggave.gastosapp.adapter.OperationsAdapter;
import com.ggave.gastosapp.repositories.OperationsRepositoy;

public class DetailActivity extends AppCompatActivity {
    TextView monto, detalle;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detalle = findViewById(R.id.saldo_text);
        monto = findViewById(R.id.montoTotal_text);

        recyclerView = findViewById(R.id.Operations_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String valor = getIntent().getExtras().getString("valor");
        OperationsAdapter adapter = new OperationsAdapter();
        adapter.setOperations(OperationsRepositoy.getOperation(valor));
        monto.setText(String.valueOf(OperationsRepositoy.total(valor)));
        detalle.setText("Saldo Actual "+valor);
        recyclerView.setAdapter(adapter);
    }
}
