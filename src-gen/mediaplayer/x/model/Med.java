package mediaplayer.x.model;

import hu.elte.txtuml.api.model.Association;
import mediaplayer.x.model.Artist;
import mediaplayer.x.model.Media;

@SuppressWarnings("all")
public class Med extends Association {
  public class a extends Association.Many<Media> {
  }
  
  public class b extends Association.One<Artist> {
  }
}
