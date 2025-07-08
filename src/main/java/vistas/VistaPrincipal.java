package vistas;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.dto.Mascota;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class VistaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JLabel lblid;
	private JTextField txtid;
	private JLabel lblRaza;
	private JTextField txtRaza;
	private JLabel lblColor;
	private JTextField txtColor;
	private JLabel lblSexo;
	private JTextField txtSexo;
	private JLabel lblInfo;
	private JButton btnRegistrar, btnConsultar, btnActualizar, btnListaID, btnListaSexo, btnEliminar;
	private JTextArea textArea;
	
	private Coordinador coordinador;

	
	public VistaPrincipal() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(102, 0, 51));
		lblNombre.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNombre.setBounds(10, 92, 73, 35);
		contentPane.add(lblNombre);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(85, 92, 136, 30);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblid = new JLabel("ID");
		lblid.setForeground(new Color(102, 0, 51));
		lblid.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblid.setBounds(272, 92, 36, 35);
		contentPane.add(lblid);
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(315, 92, 136, 30);
		contentPane.add(txtid);
		
		lblRaza = new JLabel("Raza");
		lblRaza.setForeground(new Color(102, 0, 51));
		lblRaza.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblRaza.setBounds(10, 137, 73, 35);
		contentPane.add(lblRaza);
		
		txtRaza = new JTextField();
		txtRaza.setColumns(10);
		txtRaza.setBounds(57, 143, 101, 30);
		contentPane.add(txtRaza);
		
		lblColor = new JLabel("Color");
		lblColor.setForeground(new Color(102, 0, 51));
		lblColor.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblColor.setBounds(167, 137, 73, 35);
		contentPane.add(lblColor);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(219, 143, 109, 30);
		contentPane.add(txtColor);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(new Color(102, 0, 51));
		lblSexo.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSexo.setBounds(338, 137, 42, 35);
		contentPane.add(lblSexo);
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(390, 142, 84, 30);
		contentPane.add(txtSexo);
		
		lblInfo = new JLabel("Digite solo F o M");
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInfo.setBounds(356, 176, 95, 13);
		contentPane.add(lblInfo);
		
		 btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(new Color(202, 0, 101));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistrar.setBounds(21, 199, 101, 25);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		
		 btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(202, 0, 101));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultar.setBounds(132, 199, 101, 25);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(this);
		
		 btnActualizar = new JButton("Actualizar");
		btnActualizar.setForeground(new Color(202, 0, 101));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnActualizar.setBounds(251, 199, 101, 25);
		contentPane.add(btnActualizar);
		btnActualizar.addActionListener(this);
		
		 btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(202, 0, 101));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(362, 199, 101, 25);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		 btnListaID = new JButton("Consultar Lista (ID)");
		btnListaID.setForeground(new Color(202, 0, 101));
		btnListaID.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListaID.setBounds(21, 234, 208, 25);
		contentPane.add(btnListaID);
		btnListaID.addActionListener(this);
		
		 btnListaSexo = new JButton("Consultar Lista (sexo)");
		btnListaSexo.setForeground(new Color(202, 0, 101));
		btnListaSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListaSexo.setBounds(251, 234, 208, 25);
		contentPane.add(btnListaSexo);
		btnListaSexo.addActionListener(this);
		
		 textArea = new JTextArea();
		textArea.setBounds(21, 269, 442, 198);
		contentPane.add(textArea);
		
		JLabel lblimagen = new JLabel("");
		lblimagen.setBounds(0, 0, 494, 489);
		lblimagen.setIcon(new ImageIcon(getClass().getResource("/images/Gestorbg.png")));
		contentPane.add(lblimagen);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 127, 429, 2);
		contentPane.add(separator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRegistrar) {
			try {
				registrar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()== btnConsultar) {
			try {
				consultar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()== btnActualizar) {
			try {
				actualizar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()== btnListaID) {
			try {
				listaID();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()== btnListaSexo) {
			try {
				listaSexo();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()== btnEliminar) {
			eliminar();
		}
		
	}
	
	private void eliminar() {
		try {
			Long idMascota = Long.parseLong(txtid.getText().trim());
			Mascota mascota = new Mascota();
			mascota.setIdMascota(idMascota);

			String resp = coordinador.eliminar(mascota);
			JOptionPane.showMessageDialog(null, resp);
			limpiarDatos();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "id no valido");
		}
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador= coordinador;
	}

	private void registrar() throws SQLException {
		Long idMascota = Long.parseLong(txtid.getText().trim());
		String nombre = txtNombre.getText();
		String raza = txtRaza.getText();
		String color = txtColor.getText();
		String sexo = txtSexo.getText();
		
		//validation
		if (!coordinador.validarTextoMascota(sexo)) {
			JOptionPane.showMessageDialog(this, "El campo de sexo es obligatorio");
		return;}
		if (!coordinador.validarTextoMascota(nombre)) {
			JOptionPane.showMessageDialog(this, "El campo de nombre es obligatorio");
			return;}
		if (!coordinador.validarTextoMascota(raza)) {
			JOptionPane.showMessageDialog(this, "El campo de raza es obligatorio");
			return;}
		if (!coordinador.validarTextoMascota(color)) {
			JOptionPane.showMessageDialog(this, "El campo de color es obligatorio");
			return;}
		
		Mascota pet = new Mascota();
		pet.setColorMascota(color);
		pet.setIdMascota(null);
		pet.setNombre(nombre);
		pet.setRaza(raza);
		pet.setSexo(sexo);
		 String res = coordinador.registro(pet);
		 if (res.equals("ok")) {
			JOptionPane.showMessageDialog(this, "Registro de mascota exitoso!!!");
			limpiarDatos();
			
			String resumen =
							"Nombre mascota: "+nombre+"\n"+
							"Sexo: "+sexo+"\n"+
							"Raza: "+raza+"\n"+
							"Color: "+color+"\n"
							;
			
			textArea.setText(resumen);
			System.out.println("Sexo: "+pet.getSexo());
			System.out.println("Raza: "+pet.getRaza());
			System.out.println("Nombre: "+pet.getNombre());
		} else {
			textArea.setText("Recuerda que solo se registran mascotas con dueño activo");
		}
	}

	private void consultar() throws SQLException {
	    try {
	        Long idMascota = Long.parseLong(txtid.getText().trim());

	        Mascota mascota = coordinador.consulta(idMascota);

	        if (mascota != null) {
	            String resumen =
	                    "Nombre mascota: " + mascota.getNombre() + "\n" +
	                    "Sexo: " + mascota.getSexo() + "\n" +
	                    "Raza: " + mascota.getRaza() + "\n" +
	                    "Color: " + mascota.getColorMascota() + "\n";

	            textArea.setText(resumen);

	            txtNombre.setText(mascota.getNombre());
	            txtSexo.setText(mascota.getSexo());
	            txtRaza.setText(mascota.getRaza());
	            txtColor.setText(mascota.getColorMascota());

	            System.out.println("Sexo: " + mascota.getSexo());
	            System.out.println("Raza: " + mascota.getRaza());
	            System.out.println("Nombre: " + mascota.getNombre());

	        } else {
	            JOptionPane.showMessageDialog(this, "No existen mascotas con el ID " + idMascota);
	            limpiarDatos();
	        }
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Ingrese un ID válido.");
	    }
	}

	private void actualizar() throws SQLException{

		try {
			Long idMascota = Long.parseLong(txtid.getText().trim());
			Mascota mascota = new Mascota();
			mascota.setIdMascota(idMascota);
			mascota.setNombre(txtNombre.getText());
			mascota.setRaza(txtRaza.getText());
			mascota.setColorMascota(txtColor.getText());
			mascota.setSexo(txtSexo.getText());

			String resp = coordinador.actualizar(mascota);
			JOptionPane.showMessageDialog(null, resp);
			limpiarDatos();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Ingrese un ID válido");
		}
	}

	private void listaID() throws SQLException{
		List<Mascota> registrosMascotas = coordinador.lista();
		String resumen;
		if (registrosMascotas==null) {
			resumen = "no hay registros de mascotas";
			textArea.setText(resumen);
			return;
		}
		
		resumen = "Lista mascotas\n\n";
		for(Mascota pet : registrosMascotas) {
			resumen+= "\nID mascota: "+pet.getIdMascota()
			+"\nNombre: "+pet.getNombre()
			+"\nRaza: "+pet.getRaza()
			+"\nSexo: "+pet.getSexo()
			+"\nColor: "+pet.getColorMascota()
			+"\n------------------------------------\n";
			textArea.setText(resumen);
		}
		
		
	}

	private void listaSexo() throws SQLException {
		String sexoSeleccionado = txtSexo.getText().trim();
	    List<Mascota> listaMascotas = coordinador.listaSexo(sexoSeleccionado);

	    if (listaMascotas.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "No hay mascotas con sexo " + sexoSeleccionado);
	        textArea.setText(""); // Limpia el área en caso de que tenga algo viejo
	        return;
	    }

	    String resumen = new String("Lista de mascotas con sexo: " + sexoSeleccionado + "\n\n");

	    resumen = "Lista mascotas\n\n";
		for(Mascota pet : listaMascotas) {
			resumen+= "\nID mascota: "+pet.getIdMascota()
			+"\nNombre: "+pet.getNombre()
			+"\nRaza: "+pet.getRaza()
			+"\nSexo: "+pet.getSexo()
			+"\nColor: "+pet.getColorMascota()
			+"\n------------------------------------\n";
			textArea.setText(resumen);
		}
		
	}

		
	
	public void limpiarDatos() {
		txtColor.setText("");
		txtid.setText("");
		txtNombre.setText("");
		txtRaza.setText("");
		txtSexo.setText("");
	}
}
