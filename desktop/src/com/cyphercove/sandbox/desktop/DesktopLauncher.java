package com.cyphercove.sandbox.desktop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cyphercove.sandbox.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {

        ApplicationListener applicationListener = new MainGame();
		if (arg != null && arg.length > 0){
            try {
                Class type = Class.forName("com.cyphercove.sandbox." +  arg[0]);
                applicationListener = (ApplicationListener)type.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e){
                e.printStackTrace();
            } catch (IllegalAccessException e){
                e.printStackTrace();
            } catch (ClassCastException e){
                e.printStackTrace();
            }
        }

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(applicationListener, config);
	}
}
