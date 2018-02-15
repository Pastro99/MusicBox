
import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;

import control.KeyControl;
import control.MouseControl;
import model.translate;
import view.BackImage;
import view.Finestra;

import java.util.List;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		MusixMatch master = new MusixMatch("0448c4ba0befaa217d6f0c9a347c458b");
		List<Track> tracks=null;
	    Finestra f = new Finestra();
	    KeyControl keyevent = new KeyControl(f,master,tracks);
	    
	    MouseControl mousecontrol = new MouseControl(keyevent);
	    
	    translate.traduci("it","en", "ciao, come stai?");
	  
	}

}
