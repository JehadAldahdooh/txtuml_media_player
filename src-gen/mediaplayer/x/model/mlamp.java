package mediaplayer.x.model;

import hu.elte.txtuml.api.model.Association;
import hu.elte.txtuml.api.model.Composition;
import mediaplayer.x.model.Lamp;
import mediaplayer.x.model.Mediaplayer;

@SuppressWarnings("all")
public class mlamp extends Composition {
  public class mp extends Composition.Container<Mediaplayer> {
  }
  
  public class lamp extends Association.One<Lamp> {
  }
}
