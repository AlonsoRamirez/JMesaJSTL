package modelo;
import java.sql.*;
import javabeans.*;

import java.util.*;

public class Operaciones {

    public Connection getConnection(){
        Connection cn=null;
        try{
             Class.forName("com.mysql.jdbc.Driver");

             // Se obtiene una conexión con la base de datos.
             cn = DriverManager.getConnection (
             "jdbc:mysql://localhost:3306/inventario","root", "");
        }
        catch(Exception e){e.printStackTrace();}

        return cn;
    }

    public ArrayList<VentasBean> obtenerMensajes(){
        Connection cn=null;
        ArrayList<VentasBean> mensaje=null;
        Statement st;
        ResultSet rs;
        try {
            cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from ventas";
            rs=st.executeQuery(tsql);
            mensaje=new ArrayList<VentasBean>();
            while (rs.next()) {
                VentasBean m=new VentasBean(rs.getInt("id_venta"), rs.getInt("id_linea"), rs.getString("fecha_venta"), rs.getString("descripcion"));
                mensaje.add(m);
            }
            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return(mensaje);

    }
    
  
   public void guardarVenta(VentasBean m){
        Connection cn;
        Statement st;
        ResultSet rs;
        try {
            cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="Insert into ventas (id_linea,fecha_venta,descripcion) values('";
            tsql+=m.getId_linea()+"','"+
                  m.getFecha()+"','"+
                  m.getDescripcion()+"')";
            st.execute(tsql);
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarVenta(String id){
        Connection cn;
        Statement st;
        ResultSet rs;
        try {
            cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="delete from ventas where id_venta='"+id+"'";
            st.execute(tsql);
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
}}

