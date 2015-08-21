package javabeans;

import java.sql.Date;

public class VentasBean {

	private int id_venta;
	private int id_linea;
	private String fecha;
	private String descripcion;
	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public int getId_linea() {
		return id_linea;
	}
	public void setId_linea(int id_linea) {
		this.id_linea = id_linea;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public VentasBean()
	{
		
	}
	public VentasBean(int id_venta, int id_linea, String fecha, String descripcion) {
		this.id_venta = id_venta;
		this.id_linea = id_linea;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}
	
	
}
