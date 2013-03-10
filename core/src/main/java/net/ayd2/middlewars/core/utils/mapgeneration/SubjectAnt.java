package net.ayd2.middlewars.core.utils.mapgeneration;

import java.util.Observer;

public interface SubjectAnt {
	 public void register(Observer o);
	 public void unregister(Observer o);
}
