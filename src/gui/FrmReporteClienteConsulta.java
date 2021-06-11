package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entidad.Cliente;
import model.ClienteModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import reporte.GeneradorReporte;

public class FrmReporteClienteConsulta extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblReporteDeCliente;
	private JLabel lblDni;
	private JTextField txtDNI;
	private JButton btnFiltrar;
	private Panel panelReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteClienteConsulta frame = new FrmReporteClienteConsulta();
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
	public FrmReporteClienteConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblReporteDeCliente = new JLabel("Reporte de Cliente por DNI");
		lblReporteDeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDeCliente.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblReporteDeCliente.setBounds(12, 13, 734, 28);
		contentPane.add(lblReporteDeCliente);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(65, 72, 56, 16);
		contentPane.add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(121, 69, 146, 22);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		btnFiltrar = new JButton("FILTRAR");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(513, 68, 97, 25);
		contentPane.add(btnFiltrar);
		
		panelReporte = new Panel();
		panelReporte.setBounds(12, 133, 850, 475);
		contentPane.add(panelReporte);
		panelReporte.setLayout(new BorderLayout(0,0));
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(arg0);
		}
	}
	protected void actionPerformedBtnFiltrar(ActionEvent arg0) {
		String DNI= txtDNI.getText().trim();
		
		ClienteModel model= new ClienteModel();
		List<Cliente> lisData= null;
		
		if(DNI.equals("")) {
			lisData= model.consultaCliente();
		}else {
			lisData= model.consultaCliente(DNI);
		}
		
		JRBeanCollectionDataSource dataSource 
				= new JRBeanCollectionDataSource(lisData);
		
		String file = "reporteCliente.jasper";
		
		JasperPrint jasperPrint= 
				GeneradorReporte.genera(file, dataSource, null);
	
		JRViewer jRViewer= new JRViewer(jasperPrint);
		
	
		panelReporte.removeAll();
		panelReporte.add(jRViewer);
		panelReporte.repaint();
		panelReporte.revalidate();
	}
}
