package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Producto;
import model.Proveedor;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCodigo;
	JComboBox<String> cboCategorias;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JComboBox<String> cboProveedores;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);
		
		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);
		
		cboProveedores = new JComboBox();
		cboProveedores.setBounds(308, 102, 102, 22);
		contentPane.add(cboProveedores);
		
		llenaCombo();
	}

	void llenaCombo() {

		 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion");
		 
		
		 EntityManager em= fabrica.createEntityManager();
		 
		
		 String jpql = "select u from Categoria u";
		 List<Categoria> lstCategorias = em.createQuery(jpql, Categoria.class).getResultList();
		 
		 // Imprimir el listado usando un "for"
		 for (Categoria c: lstCategorias) {
			 cboCategorias.addItem(c.getDescripcion());
		 }
	
		
		 String jpql2 = "select p from Proveedor p ";
		 List<Proveedor> lstProveedores = em.createQuery(jpql2, Proveedor.class).getResultList();
		 
		 cboProveedores.addItem("Seleccione...");
		 for (Proveedor p : lstProveedores) {
			 cboProveedores.addItem(p.getNombre_rs());
		 em.close();
		 } 
	}
	
	
	
	void listado() {
		
			 
			
				 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion");
				 
		
				 EntityManager em= fabrica.createEntityManager();
				 
			
				 String jpql = "select p from Producto p";
				 List<Producto> lstProductos = em.createQuery(jpql
						 , Producto.class).getResultList();
				 
				
				 for (Producto p: lstProductos) {
					 
					 imprimir("Codigo............: " + p.getId_prod());
					 imprimir("Nombre Productoo..: " + p.getDes_prod());
					 imprimir("Stock.............: " + p.getStk_prod());
					 imprimir("Precio............: " + p.getPre_prod());
					 imprimir("Nro Categoria.....: " + p.getObjCategoria().getIdcategoria());
					 imprimir ("Nombre Cateogria..: " + p.getObjCategoria().getDescripcion());
					 imprimir ("Nombre Proveedor..: " + p.getObjProveedor().getNombre_rs());
					 imprimir("----------------------------------");
				 }
				 
				 em.close();
			} 
		
	void imprimir(String texto) {
		txtSalida.append(texto + "\n");
	}
	
	void registrar() {
		 
		 EntityManagerFactory fabrica = 
				 Persistence.createEntityManagerFactory("jpa_sesion");

		 EntityManager em= fabrica.createEntityManager();
		 
	
		 
		 Producto po = new Producto ();
		 po.setId_prod(txtCodigo.getText());
		 po.setDes_prod(txtDescripcion.getText());
		 po.setStk_prod(Integer.parseInt(txtStock.getText()));
		 po.setPre_prod(Double.parseDouble(txtPrecio.getText()));
		 po.setIdcategoria(cboCategorias.getSelectedIndex());
		 po.setEst_prod(1);
		 po.setIdproveedor(cboProveedores.getSelectedIndex());
		
		 try {
		 em.getTransaction().begin();
		 em.persist(po);
		 em.getTransaction().commit();
		 JOptionPane.showMessageDialog(this,"Registro Ok!!!");
		 } catch (Exception e) {
			 System.out.println("Error:" + e.getCause().getMessage());
		 }
		 em.close();

	}
}