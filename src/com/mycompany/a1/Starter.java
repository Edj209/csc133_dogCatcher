package com.mycompany.a1;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
import userclasses.StateMachine;

/**
 * Created by Edgar on 2/23/2016.
 */
public class Starter {
    private Form current;

    public void init(Object context) {
    }

    public void start() {
        if(current != null){
            current.show();
            return;
        }
        new Game();
        //new StateMachine("/theme");
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
    }

    public void destroy() {
    }
}
