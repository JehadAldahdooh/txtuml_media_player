package mediaplayer.x.model;

import hu.elte.txtuml.api.model.From;
import hu.elte.txtuml.api.model.ModelClass;
import hu.elte.txtuml.api.model.StateMachine;
import hu.elte.txtuml.api.model.To;
import hu.elte.txtuml.api.model.Trigger;
import mediaplayer.x.model.LampOff;
import mediaplayer.x.model.LampOn;
import mediaplayer.x.model.Lampause;
import mediaplayer.x.model.Lamps;
import mediaplayer.x.model.Mediaplayer;
import mediaplayer.x.model.mlamp;

@SuppressWarnings("all")
public class Lamp extends ModelClass {
  public class Init extends StateMachine.Initial {
  }
  
  public class Off extends StateMachine.State {
  }
  
  public class On extends StateMachine.State {
  }
  
  public class pau extends StateMachine.State {
  }
  
  @From(Lamp.Init.class)
  @To(Lamp.Off.class)
  public class Initialize extends StateMachine.Transition {
  }
  
  @From(Lamp.pau.class)
  @To(Lamp.Off.class)
  @Trigger(Lamps.class)
  public class Switchstop extends StateMachine.Transition {
    @Override
    public void effect() {
      Mediaplayer _selectAny = Lamp.this.assoc(mlamp.mp.class).selectAny();
      _selectAny.gui.mediaOff();
    }
  }
  
  @From(Lamp.On.class)
  @To(Lamp.Off.class)
  @Trigger(Lamps.class)
  public class Switchsstop extends StateMachine.Transition {
    @Override
    public void effect() {
      Mediaplayer _selectAny = Lamp.this.assoc(mlamp.mp.class).selectAny();
      _selectAny.gui.mediaOff();
    }
  }
  
  @From(Lamp.Off.class)
  @To(Lamp.On.class)
  @Trigger(LampOn.class)
  public class SwitchOn extends StateMachine.Transition {
    @Override
    public void effect() {
      Mediaplayer _selectAny = Lamp.this.assoc(mlamp.mp.class).selectAny();
      _selectAny.gui.mediaOn();
    }
  }
  
  @From(Lamp.On.class)
  @To(Lamp.pau.class)
  @Trigger(Lampause.class)
  public class Switchpause extends StateMachine.Transition {
    @Override
    public void effect() {
      Mediaplayer _selectAny = Lamp.this.assoc(mlamp.mp.class).selectAny();
      _selectAny.gui.mediapause();
    }
  }
  
  @From(Lamp.On.class)
  @To(Lamp.Off.class)
  @Trigger(LampOff.class)
  public class SwitchOff extends StateMachine.Transition {
    @Override
    public void effect() {
      Mediaplayer _selectAny = Lamp.this.assoc(mlamp.mp.class).selectAny();
      _selectAny.gui.mediaOff();
    }
  }
}
