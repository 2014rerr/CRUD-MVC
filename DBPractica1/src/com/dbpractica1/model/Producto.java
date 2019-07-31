package com.dbpractica1.model;

public class Producto {
	
	private int id;
	private String nombre;
	private double precio;
	private int existencia;

	public Producto()
	{}
	
	public Producto(int id, String nombre, Double precio, int existencia)
	{
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.existencia=existencia;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return id;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getNombre()
	{
		return nombre;
	}
	
	public void setPrecio(Double precio)
	{
		this.precio = precio;
	}
	public Double getPrecio()
	{
		return precio;
	}
	
	public void setExistencia(int existencia)
	{
		this.existencia= existencia;
	}
	public int getExistencia()
	{
		return existencia;
	}
}
