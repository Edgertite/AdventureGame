package Map;

import Items.Key;

public class LockedPath extends Path {
	
	private Key key;
	private boolean isUnlocked;
	private boolean hasLock = true;
	
	public LockedPath(Room source, Room target, String exitName, Key key) {
		super(source, target, exitName);
		setKey(key);
		setUnlocked(false);
		source.addLockedExit(this);
	}
	
	//
	public boolean unlock(Key key) {
		if (key == getKey()) {
			setUnlocked(true);
			return true;
		} else {
			return false;
		}
	}

	//
	public Key getKey() {
		return key;
	}

	//
	public void setKey(Key key) {
		this.key = key;
	}

	//
	public boolean isUnlocked() {
		return isUnlocked;
	}

	//
	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}
}
