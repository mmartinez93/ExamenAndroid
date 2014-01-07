package com.example.examenandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class Pantalla2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pantalla2);
		
        //Localizar los controles
        TextView continente = (TextView)findViewById(R.id.continente);
        TextView precio = (TextView)findViewById(R.id.precio);
        TextView box = (TextView)findViewById(R.id.box);
        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();
        //Construimos el mensaje a mostrar
        
        continente.setText("Has selccionado:  " + bundle.getString("CIUDAD"));
        
        //NO FUNCIONA EL SPINNER
        
        /*
        //Calculos para ver precio
         int precioTotal = 0;
        int numero = Integer.parseInt(numeroUsuario);
        
        if(numero < 5){ //sumamos 1 por kg
        	 for(int i = 0; i < numero; i++) {
        		 precioTotal++;
        	 }
         }
        
        if(numero < 10 && numero > 5){ //sumamos 1.5 por kg
       	 for(int i = 0; i < numero; i++) {
       		 precioTotal+= 1.5;
       	 }
        }
        
        if(numero > 10){ //sumamos 2 por kg
          	 for(int i = 0; i < numero; i++) {
          		 precioTotal+= 2;
          	 }
        if(continente == "Zona A"){
        	precioTotal+=30;
        }  	
        if(continente == "Zona B"){
        	precioTotal+=20;
        }  	 
        if(continente == "Zona B"){
        	precioTotal+=10;
        }  	  
        if(urgente == true){
        	precioTotal+= precioTotal*0.30;
        }
          }*/
	
 }
	

}
