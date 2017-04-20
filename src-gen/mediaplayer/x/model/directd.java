package mediaplayer.x.model;

import hu.elte.txtuml.api.model.Association;
import mediaplayer.x.model.Director;
import mediaplayer.x.model.Webstore;

@SuppressWarnings("all")
public class directd extends Association {
  public class director extends Association.One<Director> {
  }
  
  public class webstore extends Association.Many<Webstore> {
  }
}
