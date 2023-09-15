package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;


//GUI 
public class Demo5 {
	// Objetivo: Listado de todos los usuarios 
	
	 public static void main(String[] args) {
		 
		//1. obtener la conexion --> Llamar a la unidad de persistencia
		 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion");
		 
		 // 2. Crear manejador de entidades segun la conexion 
		 EntityManager em= fabrica.createEntityManager();
		 
		 // Listado: select * from tb_usuarios --> List
		 // select (variable)(.nombre)   from (nombre de la public class) (variable)
		 String jpql = "select u from Usuario u";
		 List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).getResultList();
		 
		 // Imprimir el listado usando un "for"
		 for (Usuario u: lstUsuarios) {
			 
			 System.out.println("Codigo...: " + u.getCod_usua());
			 System.out.println("Codigo...: " + u.getNom_usua() + " " + u.getApe_usua());
			 System.out.println("Codigo...: " + u.getIdtipo());
			 System.out.println("----------------------------------");
		 }
		 
		 em.close();
	} 
}
