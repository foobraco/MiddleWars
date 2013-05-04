package net.ayd2.middlewars.core.utils;

import net.ayd2.middlewars.core.Map;
import playn.core.Pointer;

public class PointerControls implements playn.core.Pointer.Listener{
	Map mapa;
		public PointerControls(Map mapa){
			this.mapa=mapa;
		}
        @Override
        public void onPointerEnd(Pointer.Event event) {
          mapa.touchVectorX = mapa.touchVectorY = 0;
         
        }
        @Override
        public void onPointerCancel(Pointer.Event event) {
        	mapa.touchVectorX = mapa.touchVectorY = 0;
        }
        @Override
        public void onPointerDrag(Pointer.Event event) {
        	mapa.touchMove(event.x(), event.y());
        }
        @Override
        public void onPointerStart(Pointer.Event event) {
        	 if(!mapa.hasStarted){
       			mapa.hasStarted=true;
       		}
        	mapa.touchMove(event.x(), event.y());
        }
}
