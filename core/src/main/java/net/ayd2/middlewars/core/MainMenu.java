package net.ayd2.middlewars.core;

import net.ayd2.middlewars.core.utils.Boton;
import playn.core.AssetWatcher;
import playn.core.Font;
import playn.core.Image;
import playn.core.ImmediateLayer;
import playn.core.Key;
import playn.core.Keyboard;
import playn.core.PlayN;
import playn.core.TextFormat;
import playn.core.Keyboard.TypedEvent;
import playn.core.Platform.Type;
import playn.core.PlayN.LifecycleListener;
import playn.core.Pointer;
import playn.core.Surface;
import playn.core.Pointer.Event;

import net.ayd2.middlewars.core.utils.Screen;
import net.ayd2.middlewars.core.utils.Vector2;

import static playn.core.PlayN.*;

public class MainMenu extends Screen {

	private ImmediateLayer layer;
	Boton continuar, options, exit, editor,heyzap;
	boolean doneLoading = false;
	MiddleWars middlewars;
	Image titulo, fondo,copy;
	public TextFormat tformat;
	public final AssetWatcher watcher = new AssetWatcher();

	public MainMenu(MiddleWars middlewars) {
		this.middlewars = middlewars;
	}

	@Override
	public String name() {
		return "Menu";
	}
	
	@Override
	public void Init() {
	PlayN.setLifecycleListener(new LifecycleListener(){
			@Override
			public void onPause() {
				// TODO Auto-generated method stub
				if (graphics().ctx().quadShader(null) != null) {
					graphics().ctx().quadShader(null).clearProgram();
					}
					if (graphics().ctx().trisShader(null) != null) {
					graphics().ctx().trisShader(null).clearProgram();
					}
			}

			@Override
			public void onResume() {
				
			}

			@Override
			public void onExit() {
				// TODO Auto-generated method stub
				if (graphics().ctx().quadShader(null) != null) {
					graphics().ctx().quadShader(null).clearProgram();
					}
					if (graphics().ctx().trisShader(null) != null) {
					graphics().ctx().trisShader(null).clearProgram();
					}
			}
		});
	
		
		layer = graphics().createImmediateLayer(800,480,new ImmediateLayer.Renderer() {

					public void render(Surface surf) {
							surf.clear();
//							surf.drawImage(fondo, 0, 0);
//							surf.drawImage(titulo, 160 ,40, 480, 220);
//							surf.drawImage(copy, 0, 440);
							continuar.Draw(surf);
							
						}
				});
		graphics().rootLayer().clear();
		graphics().rootLayer().add(layer);
		watcher.start();
										tformat = new TextFormat().withFont(graphics()
												.createFont("PressStart", Font.Style.PLAIN, 40));
										// TODO Auto-generated method stub
										continuar = new Boton(
												null,
												null,
												"Play",
												new Vector2(160, 40),
												new Vector2(330,
														260));

										
//										titulo = MiddleWars.Imagenes.get("name");
//										fondo = MiddleWars.Imagenes.get("title");
//										copy= MiddleWars.Imagenes.get("copy");
//									
										platformType();
										if (platformType() == Type.ANDROID) {
										//	middlewars.zap.showAd();
										}
										
										doneLoading = true;
									
										keyboard().setListener(new Keyboard.Listener() {
										@Override
										public void onKeyUp(playn.core.Keyboard.Event event) {
											
										}
										
										@Override
										public void onKeyTyped(TypedEvent event) {
											
										}
										
										@Override
										public void onKeyDown(playn.core.Keyboard.Event event) {
								
										}
									});


		pointer().setListener(new Pointer.Listener() {

			@Override
			public void onPointerStart(Event event) {

				continuar.Touched(MiddleWars.FingerRectangle(event.x(), event.y()));

			}

			@Override
			public void onPointerEnd(Event event) {
				if (continuar.wasTouched(MiddleWars.FingerRectangle(event.x(),
						event.y()))) {
					middlewars.activeScreen = new Map(MiddleWars.data);;
					middlewars.activeScreen.Init();
				}
				

			}

			@Override
			public void onPointerDrag(Event event) {
			}

			@Override
			public void onPointerCancel(Event event) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void shutdown() {
		graphics().rootLayer().clear();
		layer.destroy();
		layer = null;
	}

	@Override
	public void Update(float delta) {
		
	}

	@Override
	public void Draw(float alpha) {
		
	}

	
	
}
