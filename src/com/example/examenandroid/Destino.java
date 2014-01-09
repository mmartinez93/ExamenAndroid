package com.example.examenandroid;

public class Destino {
    private String zona;
    private String continente;
    private int precio;

    public Destino(String zona, String contienente, int precio){
            this.zona = zona;
            this.continente = contienente;
            this.precio = precio;
    }
    
    public String getZona(){
    	return zona;
    }
    public String getContinente(){
    	return continente;
    }
    public int getPrecio(){
    	return precio;
    }
}