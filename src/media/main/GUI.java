package media.main;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import javafx.scene.media.Media;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;
import hu.elte.txtuml.api.model.Action;
import hu.elte.txtuml.api.model.execution.ModelExecutor;
import mediaplayer.x.model.Artist;
import mediaplayer.x.model.Audio;
import mediaplayer.x.model.Director;
import mediaplayer.x.model.Image;
import mediaplayer.x.model.ImagePlaylists;
import mediaplayer.x.model.Mediaplayer;
import mediaplayer.x.model.Playlists;
import mediaplayer.x.model.Video;
import mediaplayer.x.model.VideoPlaylists;
import mediaplayer.x.model.Webstore;
import mediaplayer.x.model.audioPlaylists;
import mediaplayer.x.model.audiolist;
import mediaplayer.x.model.directd;
import mediaplayer.x.model.imagelist;
import mediaplayer.x.model.pause;
import mediaplayer.x.model.prepareAsyn;
import mediaplayer.x.model.ready;
import mediaplayer.x.model.start;
import mediaplayer.x.model.stop;
import mediaplayer.x.model.videolist;
import mediaplayer.x.model.webplaylist;
import javafx.scene.media.MediaPlayer;
import javafx.embed.swing.JFXPanel;

public class GUI implements GUIInterface {
	static BufferedImage mediaOff;
	static BufferedImage mediaOn;
	static BufferedImage mediapau;
	static JLabel mediaOffLabel;
	static JLabel mediaOnLabel;
	static Mediaplayer player;
	static Webstore webstore;
	static Director director;
	static Media media;
	static Artist artist;
	static ImagePlaylists imageplaylist;
	static Playlists playlist;
	static Image image;
	static Video video;
	static VideoPlaylists vplaylist;
	static audioPlaylists aplaylist;
	static Audio audio;
	static JFrame frame;
	static JPanel mainPanel;
	static JPanel Webstore;
	static JPanel outputPanel;
	static JPanel runningPanel;
	static JPanel buttonPanel;
	static JPanel lampPanel;
	static JButton openButton;
	static JButton startButton;
	static JButton pauseButton;
	static JButton stopButton;
	static JButton testButton;
	static BufferedImage mediaplaying;
	static JLabel mstartingLabel;
	static BufferedImage mediaClosed;
	static BufferedImage mediaOpen;
	static JLabel ClosedLabel;
	static JLabel OpenLabel;
	static String fileName = null;
	static MediaPlayer mediaPlayer;

	static void init() {
		try {
			player = Action.create(Mediaplayer.class);

			webstore = Action.create(Webstore.class);
			director = Action.create(Director.class);
			artist = Action.create(Artist.class);
			imageplaylist = Action.create(ImagePlaylists.class);
			playlist = Action.create(Playlists.class);
			image = Action.create(Image.class);
			video = Action.create(Video.class);
			vplaylist = Action.create(VideoPlaylists.class);
			aplaylist = Action.create(audioPlaylists.class);
			audio = Action.create(Audio.class);
			player = Action.create(Mediaplayer.class);
			Action.link(directd.director.class, director, directd.webstore.class, webstore);
			Action.link(webplaylist.webstore.class, webstore, webplaylist.playlist.class, playlist);
			Action.link(imagelist.imageplaylist.class, imageplaylist, imagelist.image.class, image);
			Action.link(videolist.videoplaylist.class, vplaylist, videolist.video.class, video);
			Action.link(audiolist.audioplaylist.class, aplaylist, audiolist.audio.class, audio);
			Action.start(webstore);
			Action.start(director);
			Action.start(artist);
			Action.start(imageplaylist);
			Action.start(playlist);
			Action.start(image);
			Action.start(video);
			Action.start(vplaylist);
			Action.start(aplaylist);
			Action.start(audio);
			Action.start(player);
			mainPanel = new JPanel();
			mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
			outputPanel = new JPanel();
			runningPanel = new JPanel();
			buttonPanel = new JPanel();
			lampPanel = new JPanel();

			try {

				mediaClosed = ImageIO.read(new File("src/media/images/initial.jpg"));
				mediaOpen = ImageIO.read(new File("src/media/images/webstore.jpg"));
				mediaplaying = ImageIO.read(new File("src/media/images/playing.jpg"));
				mediaOff = ImageIO.read(new File("src/media/images/lampoff.jpg"));
				mediaOn = ImageIO.read(new File("src/media/images/lampon.jpg"));
				mediapau = ImageIO.read(new File("src/media/images/red.JPG"));

			} catch (IOException e) {
				e.printStackTrace();
			}

			ClosedLabel = new JLabel(new ImageIcon(mediaClosed));
			OpenLabel = new JLabel(new ImageIcon(mediaOpen));
			mstartingLabel = new JLabel(new ImageIcon(mediaplaying));
			mediaOffLabel = new JLabel(new ImageIcon(mediaOff));
			mediaOnLabel = new JLabel(new ImageIcon(mediaOn));
			mediaOnLabel.setVisible(false);
			outputPanel.setBackground(new Color(255, 255, 255));
			outputPanel.add(ClosedLabel);
			outputPanel.add(OpenLabel);
			OpenLabel.setVisible(false);
			runningPanel.setBackground(new Color(255, 255, 255));
			runningPanel.add(mstartingLabel);
			runningPanel.setVisible(false);
			openButton = new JButton("OpenMediaPlayer");
			pauseButton = new JButton("PauseMediaPalyer");
			startButton = new JButton("StartMediaPalyer");
			startButton.setVisible(false);
			stopButton = new JButton("StopMediaPlayer");

			openButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

					ClosedLabel.setVisible(false);
					OpenLabel.setVisible(true);
					mstartingLabel.setVisible(false);
					pauseButton.setVisible(true);
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3");
					chooser.setFileFilter(filter);
					int returnVal = chooser.showOpenDialog(null);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						fileName = chooser.getSelectedFile().toURI().toString();
					}
					mediaPlayer = new MediaPlayer(new Media(fileName));
					Action.send(new prepareAsyn(), player);
					Action.send(new ready(), player);
					startButton.setVisible(true);

				}
			});

			startButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					runningPanel.setVisible(true);
					mstartingLabel.setVisible(true);
					OpenLabel.setVisible(false);
					ClosedLabel.setVisible(false);
					mediaPlayer.play();
					Action.send(new start(), player);

				}
			});

			pauseButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					mediaPlayer.pause();
					Action.send(new pause(), player);

				}
			});

			stopButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					mediaPlayer.stop();
					startButton.setVisible(false);
					pauseButton.setVisible(false);
					Action.send(new stop(), player);

				}
			});
			openButton.setBackground(Color.gray);
			pauseButton.setBackground(Color.pink);
			stopButton.setBackground(Color.red);
			startButton.setBackground(Color.green);
			buttonPanel.add(openButton);
			buttonPanel.add(startButton);
			buttonPanel.add(stopButton);
			buttonPanel.add(pauseButton);
			lampPanel.add(mediaOffLabel);
			lampPanel.add(mediaOnLabel);
			mainPanel.add(outputPanel);
			mainPanel.add(runningPanel);
			mainPanel.add(buttonPanel);
			mainPanel.add(lampPanel);
			frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(mainPanel);
			frame.pack();
			frame.setVisible(true);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
			Action.start(player);
		} catch (Exception e) {

		}
	}

	public void start() {
		final CountDownLatch latch = new CountDownLatch(1);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JFXPanel();
				latch.countDown();
			}
		});
		try {
			latch.await();
		} catch (InterruptedException ex) {
		}
	}

	@Override
	public void mediaOn() {
		System.out.println("Media On Trigger ");
		ImageIcon image = new ImageIcon("src/media/images/lampon.jpg");
		mediaOnLabel.setIcon(image);
		mediaOffLabel.setVisible(false);
		mediaOnLabel.setVisible(true);
	}

	@Override
	public void mediaOff() {
		System.out.println("Media Off Trigger ");
		mediaOnLabel.setVisible(false);
		mediaOffLabel.setVisible(true);
	}

	@Override
	public void mediapause() {
		System.out.println("Media Pause Trigger ");
		ImageIcon image = new ImageIcon("src/media/images/red.JPG");
		mediaOnLabel.setIcon(image);
	}

	public static void main(String[] args) {
		new GUI().start();
		ModelExecutor.create().setTraceLogging(true).start(GUI::init);
	}
}
