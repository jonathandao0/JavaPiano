import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class WhiteKey extends JButton{
	MediaPlayer sound;
	Media file;
	Path filepath;
	
	WhiteKey(String key){
		
		setText(key);
		setFont(new Font("Arial", Font.PLAIN, 20));
		setVerticalAlignment(SwingConstants.BOTTOM);
		setBackground(Color.white);
		setOpaque(true);
		
		filepath = Paths.get("src/PianoAudio/" + key + ".mp3");
		file = new Media(filepath.toUri().toString());
		
		this.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					sound = new MediaPlayer(file);
					sound.play();
				}
			}
		);
	}
}
