package net.ayd2.middlewars.core.utils;

/*
 * Estas clases son iguales a las de ejemplo del XNA-Platformer, 
 * copyright a quien sea debido :P
 * 
 */

public class MathHelper {

	public static float Clamp(float x, float min, float max) {
		if (x < min) {
			return min;
		}
		if (x > max) {
			return max;
		}
		return x;
	}
}
