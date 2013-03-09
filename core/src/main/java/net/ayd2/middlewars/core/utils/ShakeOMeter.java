package net.ayd2.middlewars.core.utils;

public class ShakeOMeter {
	public Accel Acelerometer;
	float MinimumForce=6f;
	float OldX,OldY,OldZ=0;
	
	public ShakeOMeter(Accel ac){
		this.Acelerometer=ac;
		OldX=Acelerometer.getX();
		OldY=Acelerometer.getY();
		OldZ=Acelerometer.getZ();
	}
	
	public void SetAccelerometer(Accel ac){
		this.Acelerometer=ac;
	}
	
	public boolean SenseShake(){
		float TotalForce = Math.abs((Acelerometer.getX() + Acelerometer.getY() + Acelerometer.getZ()) - (OldX + OldY + OldZ));
		OldX=Acelerometer.getX();
		OldY=Acelerometer.getY();
		OldZ=Acelerometer.getZ();
		if(TotalForce>MinimumForce){
			return true;
		}
		return false;
	}
	
}
