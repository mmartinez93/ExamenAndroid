package com.example.examenandroid;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Opciones extends Activity {
	private Destino[] datos = new Destino[]{
			new Destino("", "Selecciona una opción: ", 0),
			new Destino("", "Asia ", 30),
			new Destino("", "Oceanía", 30),
			new Destino("", "America", 20),
			new Destino("", "Africa", 20),
			new Destino("", "Europa", 10)
	};
	
	class AdaptadorDestino extends ArrayAdapter<Destino> {
	    Activity context;
	        AdaptadorDestino(Activity context) {
	            super(context, R.layout.listaitem_destino, datos);
	            this.context = context;
	        }
	        public View getView(int position,View convertView,ViewGroup parent) {
	            LayoutInflater inflater = context.getLayoutInflater();
	            View item = inflater.inflate(R.layout.listaitem_destino, null);
	            TextView lblZona = (TextView)item.findViewById(R.id.zona);
	            TextView lblContinente = (TextView)item.findViewById(R.id.continente);
	            TextView lblPrecio= (TextView)item.findViewById(R.id.precio);
	            
	            lblZona.setText(datos[position].getZona());
	            lblContinente.setText(datos[position].getContinente());
	            lblPrecio.setText(datos[position].getPrecio());
	                return(item);
	      }
	}
	
	//DATOS
	String ciudadSeleccionada = "";
	boolean urgente = false;
	String numeroUsuario = "0";
	String box = "0";
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opciones);

		Spinner spinner = (Spinner)findViewById(R.id.spinnerOpciones);
		final String[] datos = new String[]{"Zona A", "Zona B", "Zona C"};
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
		spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
        //Toast para que salga un mensaje que indica la opción seleccionada, se puede elminar o modificiar
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            	ciudadSeleccionada = (String)adapterView.getItemAtPosition(position);
            }
        //En caso de no tener nada seleccionado, código aquí
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                // vacio       
            }
        });

		/*--- SPINNER ---*/
	
    /*    //Añadimos adaptador
		AdaptadorDestino adaptador = new AdaptadorDestino(this);
		 final android.widget.Spinner spinnerOpciones = (android.widget.Spinner)findViewById(R.id.spinnerOpciones);
			adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinnerOpciones.setAdapter(adaptador);
        
        spinnerOpciones.setOnItemSelectedListener(new OnItemSelectedListener() {
        //Toast para que salga un mensaje que indica la opción seleccionada, se puede elminar o modificiar
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            	ciudadSeleccionada = (String)adapterView.getItemAtPosition(position);
            	Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        //En caso de no tener nada seleccionado, código aquí
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                // vacio       
            }
        });
        /*--- FIN SPINNER ---*/
        
        /*--- RADIOBUTTON ---*/
        //Buscamos los elementos del radioGroup
        final RadioButton opcion1 = (RadioButton)findViewById(R.id.opcion1);
        final RadioButton opcion2 = (RadioButton)findViewById(R.id.opcion2);
        opcion1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(opcion1.isChecked()){
					urgente = false;
				}
				
			}
		});
        opcion2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(opcion2.isChecked()){
					urgente = true;
				}
				
			}
		});
   
        /*--- FIN RADIOBUTTON ---*/
        
        /*--- EDITTEXT ---*/
        //Buscamos el editText
        EditText editText = (EditText)findViewById(R.id.numeroUsuario);
        numeroUsuario = editText.getText().toString();
        
        /*--- FIN EDITTEXT ---*/
        
        /*--- CHECKBOX ---*/
        CheckBox box1 = (CheckBox)findViewById(R.id.box1);
        CheckBox box2 = (CheckBox)findViewById(R.id.box2);
        
        if(box1.isChecked()){
        	//
        }
        if(box2.isChecked()){
        	box+=1;
        }
        
        /*--- FIN CHECKBOX ---*/        

        /*--- BUTTONS ---*/
        Button comprar = (Button)findViewById(R.id.botonComprar);
        
        comprar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                //Creamos el Intent
                Intent intent =  new Intent(Opciones.this, Pantalla2.class);
                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("CIUDAD", ciudadSeleccionada);
                b.putString("NUMERO", numeroUsuario);
                b.putString("BOX", box);
                b.putBoolean("URGENTE", urgente);
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
			}
		});
        /*--- FIN BUTTONS ---*/
	
	}
	
		
//se puede eliminar si no se necesita un menú
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.opciones, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
		Intent i;
		switch (item.getItemId()) {	
			case R.id.acercaDe:
        		i = new Intent(this, AcercaDe.class );
                startActivity(i);
            return true;
            
			case R.id.dibujo:
				i = new Intent(this, Dibujo.class );
				startActivity(i);
				return true;
          
        default:
            return super.onOptionsItemSelected(item);
    }
    }
}
