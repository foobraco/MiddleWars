package net.ayd2.middlewars.core.utils;

public interface Accel {
	float getX();
	float getY();
	float getZ();
	void start();
	void pause();
	float[] getValues();
}
