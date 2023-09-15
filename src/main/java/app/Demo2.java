package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;


//GUI 
public class Demo2 {
	//Realizar actualizacion de datos 
	
 public static void main(String[] args) {
	//1. obtener la conexion --> Llamar a la unidad de persistencia
	 
	 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion");
	 
	 // 2. Crear manejador de entidades segund la conexion 
	 EntityManager em= fabrica.createEntityManager();
	 
	 //proceso 
	 // update tb_usuario set campo = ?,?,where
	 
	 Usuario u = new Usuario(003, "Zoila", "Baca", "@zoilav", "12345", "2000/01/14", 1, 1, null);
	 
	 // Al registrar,eliminar,actualizar se usara transact begin y comit 
	 
	 em.getTransaction().begin();
	 em.merge(u);
	 em.getTransaction().commit();
	 System.out.println("Actualizacion Ok");
	 
	 em.close();
} 
}
