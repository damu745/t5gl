package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;


//GUI 
public class Demo {
	//Realizar registro de un nuevo usuario
	
 public static void main(String[] args) {
	//1. obtener la conexion --> Llamar a la unidad de persistencia
	 
	 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion");
	 
	 // 2. Crear manejador de entidades segund la conexion 
	 EntityManager em= fabrica.createEntityManager();
	 
	 //proceso 
	 // insert into tb_usuario values (?,?)
	 
	 Usuario u = new Usuario(001, "Martin", "Vacan", "mvaca", "123007", "1990/04/02", 1, 1, null);
	 
	 // Al registrar,eliminar,actualizar se usara transact
	 
	 em.getTransaction().begin();
	 em.persist(u);
	 em.getTransaction().commit();
	 System.out.println("Registro Ok");
	 
	 em.close();
} 
}
