package mediaplayer.x.model;

import hu.elte.txtuml.api.model.Association;
import hu.elte.txtuml.api.model.Composition;
import mediaplayer.x.model.Video;
import mediaplayer.x.model.VideoPlaylists;

@SuppressWarnings("all")
public class videolist extends Composition {
  public class videoplaylist extends Composition.Container<VideoPlaylists> {
  }
  
  public class video extends Association.Many<Video> {
  }
}
