package mediaplayer.x.model;

import hu.elte.txtuml.api.model.Action;
import hu.elte.txtuml.api.model.From;
import hu.elte.txtuml.api.model.ModelClass;
import hu.elte.txtuml.api.model.StateMachine;
import hu.elte.txtuml.api.model.To;
import hu.elte.txtuml.api.model.Trigger;
import media.main.GUI;
import media.main.GUIInterface;
import mediaplayer.x.model.Lamp;
import mediaplayer.x.model.LampOn;
import mediaplayer.x.model.Lampause;
import mediaplayer.x.model.Lamps;
import mediaplayer.x.model.mlamp;
import mediaplayer.x.model.pause;
import mediaplayer.x.model.playback;
import mediaplayer.x.model.prepareAsyn;
import mediaplayer.x.model.ready;
import mediaplayer.x.model.start;
import mediaplayer.x.model.stop;

/**
 * signal loop;
 * signal ended;
 */
@SuppressWarnings("all")
public class Mediaplayer extends ModelClass {
  GUIInterface gui;
  
  public class Init extends StateMachine.Initial {
  }
  
  public class Initialized extends StateMachine.State {
  }
  
  public class Preparing extends StateMachine.State {
  }
  
  public class Prepared extends StateMachine.State {
  }
  
  public class Started extends StateMachine.State {
    @Override
    public void entry() {
      Lamp lamp = Mediaplayer.this.assoc(mediaplayer.x.model.mlamp.lamp.class).selectAny();
      Action.send(new LampOn(), lamp);
    }
  }
  
  Mediaplayer() {
    GUI _gUI = new GUI();
    this.gui = _gUI;
    Lamp lamp = Action.<Lamp>create(Lamp.class);
    Action.<Mediaplayer, Lamp>link(mlamp.mp.class, this, mediaplayer.x.model.mlamp.lamp.class, lamp);
    Action.start(lamp);
  }
  
  public class Paused extends StateMachine.State {
    @Override
    public void entry() {
      Lamp lamp = Mediaplayer.this.assoc(mediaplayer.x.model.mlamp.lamp.class).selectAny();
      Action.send(new Lampause(), lamp);
    }
  }
  
  public class Stopped extends StateMachine.State {
    @Override
    public void entry() {
      Lamp lamp = Mediaplayer.this.assoc(mediaplayer.x.model.mlamp.lamp.class).selectAny();
      Action.send(new Lamps(), lamp);
    }
  }
  
  public class Playback extends StateMachine.State {
  }
  
  @From(Mediaplayer.Init.class)
  @To(Mediaplayer.Initialized.class)
  public class TInitialize extends StateMachine.Transition {
    @Override
    public void effect() {
      Action.log("Mediaplayer in Initialized state ");
    }
  }
  
  @From(Mediaplayer.Initialized.class)
  @To(Mediaplayer.Preparing.class)
  @Trigger(prepareAsyn.class)
  public class Preparing_state extends StateMachine.Transition {
    @Override
    public void effect() {
      Action.log("Mediaplayer in Preparing State");
    }
  }
  
  @From(Mediaplayer.Preparing.class)
  @To(Mediaplayer.Prepared.class)
  @Trigger(ready.class)
  public class Ready_state extends StateMachine.Transition {
    @Override
    public void effect() {
      Action.log("Mediaplayer in Ready state");
    }
  }
  
  @From(Mediaplayer.Prepared.class)
  @To(Mediaplayer.Started.class)
  @Trigger(start.class)
  public class Starting_state extends StateMachine.Transition {
  }
  
  @From(Mediaplayer.Started.class)
  @To(Mediaplayer.Paused.class)
  @Trigger(pause.class)
  public class Pausing_state extends StateMachine.Transition {
    @Override
    public void effect() {
      Action.log("Mediaplayer in Pausing state");
    }
  }
  
  @From(Mediaplayer.Started.class)
  @To(Mediaplayer.Stopped.class)
  @Trigger(stop.class)
  public class Stopped_state extends StateMachine.Transition {
    @Override
    public void effect() {
      Action.log("Mediaplayer in stopped state");
    }
  }
  
  @From(Mediaplayer.Started.class)
  @To(Mediaplayer.Playback.class)
  @Trigger(playback.class)
  public class A6 extends StateMachine.Transition {
    @Override
    public void effect() {
      Action.log("Mediaplayer in Playback state");
    }
  }
  
  /**
   * transition A7 {
   * from Playback;
   * to Started;
   * trigger start;
   * effect {
   * log("Mediaplayer in starting state");
   * }
   * 
   * }
   */
  @From(Mediaplayer.Stopped.class)
  @To(Mediaplayer.Preparing.class)
  @Trigger(prepareAsyn.class)
  public class stopped_preparing_state extends StateMachine.Transition {
    @Override
    public void effect() {
      Action.log("Mediaplayer in prepareasync state");
    }
  }
  
  /**
   * transition A9 {
   * from Playback;
   * to Stopped;
   * trigger stop;
   * 
   * }
   */
  @From(Mediaplayer.Paused.class)
  @To(Mediaplayer.Stopped.class)
  @Trigger(stop.class)
  public class pause_stopped_state extends StateMachine.Transition {
    @Override
    public void effect() {
      Action.log("Mediaplayer in Pausing-Stopped state");
    }
  }
  
  @From(Mediaplayer.Paused.class)
  @To(Mediaplayer.Started.class)
  @Trigger(start.class)
  public class pause_started_state extends StateMachine.Transition {
    @Override
    public void effect() {
      Action.log("Mediaplayer in Pausing-Starting state");
    }
  }
  
  @From(Mediaplayer.Stopped.class)
  @To(Mediaplayer.Prepared.class)
  @Trigger(ready.class)
  public class Stopped_prepared_state extends StateMachine.Transition {
    @Override
    public void effect() {
      Action.log("Mediaplayer in ready-prepared state");
    }
  }
  
  @From(Mediaplayer.Prepared.class)
  @To(Mediaplayer.Stopped.class)
  @Trigger(stop.class)
  public class prepared_stopped_state extends StateMachine.Transition {
    @Override
    public void effect() {
      Action.log("Mediaplayer in stopped state");
    }
  }
}
