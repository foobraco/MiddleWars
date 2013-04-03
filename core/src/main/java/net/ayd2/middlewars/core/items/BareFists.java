package net.ayd2.middlewars.core.items;

import net.ayd2.middlewars.core.utils.Entity;
import net.ayd2.middlewars.core.utils.Item;

public class BareFists extends Item{
	
	public BareFists(Entity ent, int amount) {
		super(ent, amount);
		this.setType(0);
	}

	@Override
	public void use() {
		getFather().getangle();
		
	}

}
