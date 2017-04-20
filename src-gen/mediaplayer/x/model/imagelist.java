package mediaplayer.x.model;

import hu.elte.txtuml.api.model.Association;
import hu.elte.txtuml.api.model.Composition;
import mediaplayer.x.model.Image;
import mediaplayer.x.model.ImagePlaylists;

@SuppressWarnings("all")
public class imagelist extends Composition {
  public class imageplaylist extends Composition.Container<ImagePlaylists> {
  }
  
  public class image extends Association.Many<Image> {
  }
}
