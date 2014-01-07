package com.example.examenandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path.FillType;
import android.graphics.Path;
import android.view.Menu;
import android.view.View;

public class Dibujo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new EjemploView(this));
	}

	public class EjemploView extends View{
		public EjemploView (Context contexto){
			super (contexto);
		}
		@Override
		protected void onDraw (Canvas canvas){
			//Dibujamos aquí
			//Creamos un pincel con el que elegir color, trazo, estilo, etc.
			Paint pincel = new Paint();
			//Seleccionamos el color negro
			pincel.setColor(Color.BLACK);
			//Establecemos el grosor del pincel
			pincel.setStrokeWidth(10);
			//Establecemos el estilo del trazo
			pincel.setStyle(Style.STROKE);
			canvas.drawCircle(250, 250, 70, pincel);
			
			Path path = new Path();
			path.setFillType(FillType.EVEN_ODD);
			pincel.setColor(Color.BLACK);
			pincel.setStrokeWidth(10);
			path.moveTo(360, 300);
			path.lineTo(360, 200);
			path.lineTo(340, 200);
			path.lineTo(340, 270);
			path.lineTo(360, 300);
			path.close();
			canvas.drawPath(path, pincel);
			
			
					
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dibujo, menu);
		return true;
	}

}
