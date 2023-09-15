package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;


//GUI 
public class Demo9 {
	// Objetivo: Listado de todos los usuarios 
	// mostrando ademas el tipo de usuario
	
	 public static void main(String[] args) {
		String usuario =JOptionPane.showInputDialog("Ingrese Usuario");
		String clave =JOptionPane.showInputDialog("Ingrese Clave");
		 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion");
		 
		  
		 EntityManager em= fabrica.createEntityManager();
		 
		
		 String jpql = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
		 try {
			Usuario u =
					 em.createQuery(jpql,  Usuario.class).
					 setParameter("xusr", "admin@ciberfarma.com").
					 setParameter("xcla", "super").
					 getSingleResult();
			 
			
			 
				 FrmManteProd v = new FrmManteProd();
				 v.setVisible(true);
				 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario o clave incorrecto");
		}
		 
		 
		 em.close();
	} 
}
