package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;


//GUI 
public class Demo08 {
	// Objetivo: Listado de todos los usuarios 
	// mostrando ademas el tipo de usuario
	
	 public static void main(String[] args) {
		 
		//1. obtener la conexion --> Llamar a la unidad de persistencia
		 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion");
		 
		 // 2. Crear manejador de entidades segun la conexion 
		 EntityManager em= fabrica.createEntityManager();
		 
		
		 String jpql = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
		 List<Usuario> lstUsuarios =
				 em.createQuery(jpql,  Usuario.class).
				 setParameter("xusr", "admin@ciberfarma.com").
				 setParameter("xcla", "super").
				 getResultList();
		 
		 for (Usuario u: lstUsuarios) {
			 
			 System.out.println("Codigo...: " + u.getCod_usua());
			 System.out.println("Codigo...: " + u.getNom_usua() + " " + u.getApe_usua());
			 System.out.println("Tipo.....: " + u.getObjTipo().getDescripcion());
			 System.out.println("----------------------------------");
		 }
		 
		 em.close();
	} 
}
