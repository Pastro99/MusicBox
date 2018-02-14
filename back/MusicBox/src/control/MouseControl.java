package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;

import view.Finestra;
import view.LyricsFinestra;

public class MouseControl implements MouseListener {
	
	private MusixMatch master;
	private Finestra f;
	private List<Track> list=null;
	private KeyControl control;

	public MouseControl(KeyControl control) {
		this.master=control.getMaster();
		this.f=control.getFinestra();
		this.control=control;
		f.getTable().addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount()>=2) {
			list=control.getTrackList();
			JTable table=(JTable)e.getSource();
			int row=table.getSelectedRow();
			Track track=list.get(row);
			TrackData temp=track.getTrack();
			try {
				LyricsFinestra x= new LyricsFinestra(temp.getTrackName(), temp.getTrackId(), master);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
