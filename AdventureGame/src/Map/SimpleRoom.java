package Map;

import java.util.ArrayList;

public class SimpleRoom extends Room{

    // constructor
	public SimpleRoom(String name, String desc) {
        this.name = name;
        this.description = desc;
        setExits(new ArrayList<Path>());
    }
}
