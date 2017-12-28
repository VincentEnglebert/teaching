package configuration.pattern.example;

import configuration.pattern.ConfigElement;

public abstract class ISOLayer implements ConfigElement {
	private ISOLayer up = null;
	private ISOLayer down = null;

	public ISOLayer getUp() {
		return up;
	}

	public void setUp(ISOLayer up) {
		this.up = up;
	}

	public ISOLayer getDown() {
		return down;
	}

	public void setDown(ISOLayer down) {
		this.down = down;
	}

}
