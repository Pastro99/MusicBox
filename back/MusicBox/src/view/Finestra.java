package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;

public class Finestra extends JFrame {

	private JPanel contentPane;
	private Panel panel;
	private JTextField textField;
	private JLabel lblCanzone;
	private JLabel lblArtista;
	private JTextField textField_1;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	


	/**
	 * Create the frame.
	 */
	public Finestra() {
		setTitle("MusicBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new Panel();
		panel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		panel.setBounds(0, 0, 866, 604);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(175, 39, 188, 23);
		textField.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		panel.add(textField);
		textField.setColumns(10);
		
		lblCanzone = new JLabel("CANZONE");
		lblCanzone.setBounds(63, 38, 105, 23);
		lblCanzone.setFont(new Font("Yu Gothic Light", Font.PLAIN, 16));
		panel.add(lblCanzone);
		
		lblArtista = new JLabel("ARTISTA");
		lblArtista.setBounds(447, 38, 105, 23);
		lblArtista.setFont(new Font("Yu Gothic Light", Font.PLAIN, 16));
		panel.add(lblArtista);
		
		textField_1 = new JTextField();
		textField_1.setBounds(556, 38, 188, 23);
		textField_1.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(245, 245, 245)));
		scrollPane.setBounds(57, 116, 743, 451);
		panel.add(scrollPane);
		
		table = new JTable() {public boolean isCellEditable(int row,int column){  
	         return column==3;
	       }  
	     }; 
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(false);
		table.setBorder(new LineBorder(new Color(245, 245, 245)));
		table.setFont(new Font("Yu Gothic Light", Font.PLAIN, 15));
		table.setShowGrid(false);
		scrollPane.setViewportView(table);
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/background.jpg"));
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Track");
		tableModel.addColumn("Album");
		tableModel.addColumn("Artist");
		table.setOpaque(false);
		
	
		table.setRowHeight(40);
		table.setModel(tableModel);
		
	
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 866, 604);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(icon));
		
		
		setVisible(true);
			
		//txtField.setText("");
			
	}
	
	
	public String getTrack() {
		return textField.getText().trim();
	}
	
	public String getArtist() {
		return textField_1.getText().trim();
	}
	
	public JTextField getTrackField() {
		return textField;
	}
	
	public JTextField getArtistField() {
		return textField_1;
	}
	public JTable getTable() {
		return table;
	}
	
	
}
