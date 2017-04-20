package media.code;

import hu.elte.txtuml.api.layout.Below;
import hu.elte.txtuml.api.layout.ClassDiagram;
import hu.elte.txtuml.api.layout.Column;
import hu.elte.txtuml.api.layout.East;
import hu.elte.txtuml.api.layout.North;
import hu.elte.txtuml.api.layout.Right;
import hu.elte.txtuml.api.layout.Row;
import mediaplayer.x.model.*;



public class classd extends ClassDiagram {
	
	@Row({Image.class, Playlists.class ,Audio.class,Video.class})
	@Column({Media.class,Playlists.class,Person.class,Director.class})
	@Row({ImagePlaylists.class, Person.class ,VideoPlaylists.class,audioPlaylists.class})
	@Row({Artist.class, Director.class})
	
   class classlayout extends Layout {}
}
