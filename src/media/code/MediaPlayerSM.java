package media.code;

import hu.elte.txtuml.api.layout.Column;
import hu.elte.txtuml.api.layout.Row;
import hu.elte.txtuml.api.layout.StateMachineDiagram;
import mediaplayer.x.model.Mediaplayer;
import mediaplayer.x.model.Mediaplayer.Init;
import mediaplayer.x.model.Mediaplayer.Started;
import mediaplayer.x.model.Mediaplayer.Initialized;
import mediaplayer.x.model.Mediaplayer.Preparing;
import mediaplayer.x.model.Mediaplayer.Prepared;
import mediaplayer.x.model.Mediaplayer.Paused;
import mediaplayer.x.model.Mediaplayer.Stopped;
import mediaplayer.x.model.Mediaplayer.Playback;


public class MediaPlayerSM extends StateMachineDiagram<Mediaplayer> {
	@Row({Init.class,Initialized.class})
	@Column({Initialized.class,Preparing.class,Prepared.class,Started.class,Paused.class})
	@Row({Stopped.class,Paused.class,Playback.class})

	class L extends Layout{}
	
}
