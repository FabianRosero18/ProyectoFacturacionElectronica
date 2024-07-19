/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.controller;
import com.mycompany.facturacionelectronica.database.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/* controlador de la entidad Factura, hace dos ingresos: 
1- la creacion de la factura con los primeros datos ingresados en formulario, al mismo tiempo que se ingresan los items
2- la modificacion de esta factura con los ultimos campos ingresados en formulario*/

public class CtrlFactura {
    
    private String fechaRealizacion;
    private String fechaVencimiento;
    private String ordenCompra;
    private String remision;
    private String idCliente;
    private Long idFactura;
    private String observaciones;
    private EntityManager em;
    private Factura f;
    private int sumatoria = 0;
    private int iva;
    private int retefuente;
    private int total;        

    //inicializacion de instancia de factura y del EntityManager
    public CtrlFactura() {
        this.f = new Factura();
        this.em = JpaUtil.getEntityManager();
    }

    
    
    //constructor que recibe los primeros datos para crear la factura por primera vez 
    public CtrlFactura(String fechaRealizacion, String fechaVencimiento, String ordenCompra, String remision, String idCliente) {
        this();
        this.fechaRealizacion=fechaRealizacion;
        this.fechaVencimiento=fechaVencimiento;
        this.ordenCompra = ordenCompra;
        this.remision = remision;
        this.idCliente = idCliente;
    }
    
    //constructor que recibe los datos finales, para modificar la factura ya creada con anterioridad
    public CtrlFactura(String idFactura, String observaciones) {
        this();
        this.idFactura = Long.valueOf(idFactura);
        this.observaciones = observaciones;
    }
    
    //insercion de los datos iniciales
    public void InsertDatosIniciales(){
        
        int id = Integer.parseInt(this.idCliente);
        
        Cliente cliente = em.find(Cliente.class, id);
       
            
        try {
            em.getTransaction().begin();
            f.setFechaRealizacion(fechaRealizacion);
            f.setFechaVencimiento(fechaVencimiento);
            f.setOrdenCompra(ordenCompra);
            f.setRemision(remision);
            f.setCliente(cliente);

           //aqui enviamos a la persistencia el objeto factura, con los datos que le enviamos, para proceder a crearla como referencia de entidad
           em.persist(f); 
            //aqui hacemos el commit, o lo que es igual, enviamos a la base de datos
           em.getTransaction().commit();
            }
            catch (Exception e) {
                
                em.getTransaction().rollback();
                e.printStackTrace();
            }   
  
    }
    //edicion insertando los datos finales y calculando los impuestos y el total
    public void insertDatosFinales(){
        
        
            //importante, si lleva clave foranea, se debe buscar el objeto y pasarlo al objeto de la entidad con el set
        Factura f = em.find(Factura.class, idFactura);
        
        //esta consulta se hace para verificar los items ingresados de esta factura, con su respectivo objeto
        //(ojo, se debe buscar por el objeto de la entidad, no por el nombre de la columna de la tabla, y buscar el objeto completo y pasarlo)
        Query query = em.createQuery("select i from Item i where i.factura=?1", Item.class);
        //ponemos el parametro del objeto de la factura en cuestion en el query
        query.setParameter(1, f);
        //nos devuelve una lista
        List<Item> item = query.getResultList();
        //recorremos la lista en un foreach y una funcion flecha
        item.forEach(i ->{
            System.out.println(i.getCantidad()+" x "+i.getValorUnidad());
             int auxiliar = i.getCantidad()*i.getValorUnidad();
             this.sumatoria = sumatoria + auxiliar;
        });
        
        this.iva = (int) (this.sumatoria * 0.19);
        this.retefuente = (int) (this.sumatoria * 0.025);
        this.total = (this.sumatoria + this.iva)- this.retefuente;
        
        //aqui buscamos la factura que vamos a modificar segun el id actual
        this.f = em.find(Factura.class, this.idFactura);
        
        //hacemos la modificacion de la factura con los nuevos datos
        try{
            
            em.getTransaction().begin();
            f.setObservaciones(observaciones);
            f.setIva(iva);
            f.setRetefuente(retefuente);
            f.setTotal(total);
            em.merge(f);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            
        } finally {
            em.close();
        }
    } 
    public long getIdFactura() {

        return this.f.getId();
    }
    
    public int getIva() {
        return iva;
    }

    public int getRetefuente() {
        return retefuente;
    }

    public int getTotal() {
        return total;
    }
    
    
}
