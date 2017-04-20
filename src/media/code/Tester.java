package media.code;

import javax.print.attribute.standard.Media;

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
import mediaplayer.x.model.videolist;
import mediaplayer.x.model.webplaylist;
import mediaplayer.x.model.start;
import mediaplayer.x.model.stop;


public class Tester {

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
	static Mediaplayer player;


	static void init() {
		webstore = Action.create(Webstore.class);
		director = Action.create(Director.class);
		artist = Action.create(Artist.class);
		imageplaylist = Action.create(ImagePlaylists.class);
		playlist= Action.create(Playlists.class);
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

		Action.send(new prepareAsyn(), player);
	   
		Action.send(new ready(), player);
	//	Action.send(new pause(), player);


	}

	public static void main(String[] args) {
		ModelExecutor executor = ModelExecutor.create().setTraceLogging(false).launch(Tester::init);
		executor.shutdown();
	}
}
