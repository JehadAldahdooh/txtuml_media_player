package mediaplayer.x.model;

import hu.elte.txtuml.api.model.Association;
import hu.elte.txtuml.api.model.Composition;
import mediaplayer.x.model.Playlists;
import mediaplayer.x.model.Webstore;

@SuppressWarnings("all")
public class webplaylist extends Composition {
  public class webstore extends Composition.Container<Webstore> {
  }
  
  public class playlist extends Association.Many<Playlists> {
  }
}
