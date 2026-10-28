package com.example.organizadorgastos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        // setContentView(R.layout.finanzas_registro);

        setContentView(R.layout.finanzas_historial);

        ListView lstMovimientos = findViewById(R.id.lstMovimientos);
        final TextView lblSeleccion = findViewById(R.id.lblSeleccion);

        final List<Movimiento> movimientos = new ArrayList<>();
        movimientos.add(new Movimiento("Renta", "Gasto Fijo", 5000, false, android.R.drawable.ic_menu_agenda));
        movimientos.add(new Movimiento("Pago de luz", "Gasto Fijo", 450, false, android.R.drawable.ic_menu_manage));
        movimientos.add(new Movimiento("Compra de despensa", "Gasto Variable", 1250, false, android.R.drawable.ic_menu_edit));
        movimientos.add(new Movimiento("Cine", "Gasto Variable", 180, false, android.R.drawable.ic_menu_camera));
        movimientos.add(new Movimiento("Viaje a Puebla", "Gasto Variable", 900, false, android.R.drawable.ic_menu_directions));
        movimientos.add(new Movimiento("Nómina quincenal", "Ingreso", 8000, true, android.R.drawable.ic_menu_add));
        movimientos.add(new Movimiento("Depósito bancario", "Ingreso", 1500, true, android.R.drawable.ic_menu_save));

        lstMovimientos.setAdapter(new MovimientoAdapter(this, movimientos));

        lstMovimientos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movimiento m = movimientos.get(position);
                String detalle = String.format(Locale.US, "%s (%s): $%,.2f",
                        m.getConcepto(), m.getTipo(), m.getMonto());
                lblSeleccion.setText("Seleccionado: " + detalle);
                Toast.makeText(MainActivity.this, detalle, Toast.LENGTH_SHORT).show();
            }
        });
    }
}