package control;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;

import view.Finestra;

public class KeyControl implements KeyListener {

	private Finestra f;
	private MusixMatch master;
	private List<Track> list;
	
	public KeyControl(Finestra f,MusixMatch master,List<Track> list) {
		this.master=master;
		this.f=f;
		this.list=list;
		f.getArtistField().addKeyListener(this);
		f.getTrackField().addKeyListener(this);
	}
	
	public static final Comparator<Track> Trackcomparator = new Comparator<Track>() {

		@Override
		public int compare(Track o1, Track o2) {
			
			return o1.getTrack().getAlbumName().compareToIgnoreCase(o2.getTrack().getAlbumName());
		}
    };

	@Override
	public void keyPressed(KeyEvent key) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent key) {
		if(key.getKeyChar()==KeyEvent.VK_ENTER) {
			
			try {
				if(!f.getTrack().equals("") || !f.getArtist().equals("")){
					list = master.searchTracks(f.getTrack(), f.getArtist(), "", 1, 999, true);
					Collections.sort(list,Trackcomparator);
					stampa();
				}
				else {
					JOptionPane.showMessageDialog(null, "INSERIRE UN ARTISTA O UNA TRACCIA", "", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (MusixMatchException e) {
				JOptionPane.showMessageDialog(null, "ERRORE RICERCA CANZONE", "", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public void stampa() {
		DefaultTableModel model = (DefaultTableModel)f.getTable().getModel();	
		model.getDataVector().removeAllElements();
		
		for(int i=0;i<list.size();i++) {
			TrackData temp=list.get(i).getTrack();
			model.addRow(new String[]{temp.getTrackName(),temp.getAlbumName(),temp.getArtistName()});
		}
	}

	public List<Track> getTrackList(){
		return list;
	}
	public MusixMatch getMaster() {
		return master;
	}
	public Finestra getFinestra() {
		return f;
	}
	
}
