package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;

import model.translate;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class LyricsFinestra extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblOriginale;
	private JLabel lblTradotto;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public LyricsFinestra(String title,int TrackId,MusixMatch master) throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 835, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 366, 525);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(438, 64, 366, 525);
		contentPane.add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		lblOriginale = new JLabel("ORIGINALE");
		lblOriginale.setForeground(Color.DARK_GRAY);
		lblOriginale.setFont(new Font("Yu Gothic Light", Font.PLAIN, 16));
		lblOriginale.setBounds(10, 26, 366, 27);
		contentPane.add(lblOriginale);
		
		lblTradotto = new JLabel("TRADOTTO");
		lblTradotto.setForeground(Color.DARK_GRAY);
		lblTradotto.setFont(new Font("Yu Gothic Light", Font.PLAIN, 16));
		lblTradotto.setBounds(438, 26, 366, 27);
		contentPane.add(lblTradotto);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 819, 600);
		ImageIcon icon = new ImageIcon(getClass().getResource("/background.jpg"));
		lblNewLabel.setIcon(icon);
		contentPane.add(lblNewLabel);
		setTitle(title);
		
		textArea.setEditable(false);
		textArea_1.setEditable(false);
		
		Lyrics lyrics = master.getLyrics(TrackId);
		String testo=lyrics.getLyricsBody().replace("******* This Lyrics is NOT for Commercial use *******", "");
		textArea.setText(testo);
		
		textArea_1.setText(translate.traduci(lyrics.getLyricsLang(), "it", testo.replaceAll("\n", "|")));
		
		
		
		
		
		setVisible(true);
	}
}
