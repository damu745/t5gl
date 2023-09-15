package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;


//GUI 
public class Demo07 {
	// Objetivo: Listado de todos los usuarios 
	// mostrando ademas el tipo de usuario
	
	 public static void main(String[] args) {
		 
		//1. obtener la conexion --> Llamar a la unidad de persistencia
		 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion");
		 
		 // 2. Crear manejador de entidades segun la conexion 
		 EntityManager em= fabrica.createEntityManager();
		 
		 // Listado: select * from tb_usuarios --> List
		 // select (variable)(.nombre)   from (nombre de la public class) (variable)
		 String jpql = "select p from Producto p";
		 List<Producto> lstProductos = em.createQuery(jpql, Producto.class).getResultList();
		 
		 // Imprimir el listado usando un "for"
		 for (Producto p: lstProductos) {
			 
			 System.out.println("Codigo............: " + p.getId_prod());
			 System.out.println("Nombre Productoo..: " + p.getDes_prod());
			 System.out.println("Stock.............: " + p.getStk_prod());
			 System.out.println("Precio............: " + p.getPre_prod());
			 System.out.println("Nro Categoria.....: " + p.getObjCategoria().getIdcategoria());
			 System.out.println("Nombre Cateogria..: " + p.getObjCategoria().getDescripcion());
			 System.out.println("Nombre Proveedor..: " + p.getObjProveedor().getNombre_rs());
			 System.out.println("----------------------------------");
		 }
		 
		 em.close();
	} 
}
