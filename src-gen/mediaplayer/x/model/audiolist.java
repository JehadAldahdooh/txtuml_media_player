package mediaplayer.x.model;

import hu.elte.txtuml.api.model.Association;
import hu.elte.txtuml.api.model.Composition;
import mediaplayer.x.model.Audio;
import mediaplayer.x.model.audioPlaylists;

@SuppressWarnings("all")
public class audiolist extends Composition {
  public class audioplaylist extends Composition.Container<audioPlaylists> {
  }
  
  public class audio extends Association.Some<Audio> {
  }
}
