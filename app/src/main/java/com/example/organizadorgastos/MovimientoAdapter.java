package com.example.organizadorgastos;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MovimientoAdapter extends ArrayAdapter<Movimiento> {

    public MovimientoAdapter(Context context, List<Movimiento> movimientos) {
        super(context, 0, movimientos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_movimiento, parent, false);
        }

        Movimiento m = getItem(position);

        ImageView imgIcono = convertView.findViewById(R.id.imgIcono);
        TextView lblConcepto = convertView.findViewById(R.id.lblConcepto);
        TextView lblTipo = convertView.findViewById(R.id.lblTipo);

        TextView lblMonto = convertView.findViewById(R.id.lblMonto);

        imgIcono.setImageResource(m.getIcono());
        lblConcepto.setText(m.getConcepto());
        lblTipo.setText(m.getTipo());

        String signo = m.esIngreso() ? "+" : "-";
        lblMonto.setText(String.format(Locale.US, "%s$%,.2f", signo, m.getMonto()));
        lblMonto.setTextColor(Color.parseColor(m.esIngreso() ? "#2E7D32" : "#B71C1C"));

        return convertView;
    }
}