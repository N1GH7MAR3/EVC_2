package com.example.tikiapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class HomeActivity extends AppCompatActivity {
    Button snackbar_btn,alert_btn;
    androidx.constraintlayout.widget.ConstraintLayout ConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        snackbar_btn = findViewById(R.id.btn_snackbar);
        alert_btn=findViewById(R.id.btn_alert_dialog);

        alert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder alert=new MaterialAlertDialogBuilder(HomeActivity.this);
                alert.setTitle("Alert Dialog");
                alert.setCancelable(false);
                alert.setMessage("¿Estas seguro de reportar el producto?" +
                        "(Al reportar el producto puede afectar la disponibilidad del mismo)");
                alert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        snackbar_btn.setText("No Disponible");
                        snackbar_btn.setClickable(false);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        snackbar_btn.setText("Agregar al carrito");
                        snackbar_btn.setClickable(true);
                    }
                });
                alert.show();

            }
        });

        snackbar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar=Snackbar.make(v,"Producto agregado correctamente :)",Snackbar.LENGTH_INDEFINITE);
                snackbar.setDuration(10000);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                snackbar.show();
            }
        });
    }

}