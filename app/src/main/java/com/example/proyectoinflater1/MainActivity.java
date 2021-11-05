package com.example.proyectoinflater1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llAnadir;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llAnadir=findViewById(R.id.llElementos);
        layoutInflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void onClickAnadir(View v){
        RelativeLayout rlElemento= (RelativeLayout) layoutInflater.inflate(R.layout.item_elemento,null);
        ImageView ivIzquierda = rlElemento.findViewById(R.id.ivIzquierda);
        ImageView ivCentro = rlElemento.findViewById(R.id.ivCentro);
        ImageView ivDerecha = rlElemento.findViewById(R.id.ivDerecha);

        ivIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Se pulsó izquierda",Toast.LENGTH_SHORT).show();
                view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.girar));
            }
        });
        ivCentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Se pulsó el centro",Toast.LENGTH_SHORT).show();
            }
        });
        ivDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Se pulsó derecha",Toast.LENGTH_SHORT).show();
            }
        });


        int[] imagenes ={R.drawable.ic_android,R.drawable.ic_persona,R.drawable.ic_sol};
        Random r= new Random();

            ivIzquierda.setImageResource(imagenes[r.nextInt(imagenes.length)]);
            ivCentro.setImageResource(imagenes[r.nextInt(imagenes.length)]);
            ivDerecha.setImageResource(imagenes[r.nextInt(imagenes.length)]);

        llAnadir.addView(rlElemento,0);

    }
}