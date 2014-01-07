package com.example.examenandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		//Importamos el botón para añadirle funcionalidad
		Button botonPrincipal = (Button)findViewById(R.id.botonPrincipal);
		//Añadimos el escuchador para el evento "click" (pulsar)
		botonPrincipal.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//Indicamos que de esta activity queremos ir a Opciones.java
				Intent intent = new Intent(Principal.this, Opciones.class);
				//Iniciamos la nueva actividad
				startActivity(intent);
			}
		});
	}
	//Esto es para crar el menú, en principio se puede eliminar si no se pide.


}
