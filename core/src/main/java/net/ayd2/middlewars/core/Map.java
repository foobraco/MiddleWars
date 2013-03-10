package net.ayd2.middlewars.core;

import net.ayd2.middlewars.core.utils.KeyboardControl;
import net.ayd2.middlewars.core.utils.Screen;

public class Map extends Screen{

	@Override
	public String name() {

		return null;
	}

	@Override
	public void Init() {
		
		new KeyboardControl(this);
	}

	@Override
	public void Update(float delta) {

	}

	@Override
	public void shutdown() {
		
	}

	@Override
	public void Draw(float delta) {

		
	}

}
