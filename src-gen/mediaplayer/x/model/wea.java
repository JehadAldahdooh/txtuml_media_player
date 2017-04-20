package mediaplayer.x.model;

import hu.elte.txtuml.api.model.Association;
import mediaplayer.x.model.Director;
import mediaplayer.x.model.Webstore;

@SuppressWarnings("all")
public class wea extends Association {
  public class a extends Association.One<Webstore> {
  }
  
  public class b extends Association.One<Director> {
  }
}
