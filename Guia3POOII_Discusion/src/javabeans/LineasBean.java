package javabeans;

public class LineasBean {
private int id_linea;
private String linea;
public int getId_linea() {
	return id_linea;
}
public void setId_linea(int id_linea) {
	this.id_linea = id_linea;
}
public String getLinea() {
	return linea;
}
public void setLinea(String linea) {
	this.linea = linea;
}
public LineasBean()
{
	
}
public LineasBean(int id_linea, String linea) {
	this.id_linea = id_linea;
	this.linea = linea;
}
@Override
public String toString() {
	return this.linea;
}


}
