package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

/**
 * Created by Edgar on 2/23/2016.
 */
public class Game extends Form{
    private GameWorld gw;

    public Game() {
        gw = new GameWorld();
        gw.initLayout();
        play();
    }

    private void play() {
        Label myLabel = new Label("Enter a command:");
        this.addComponent(myLabel);
        final TextField myTextField = new TextField();
        this.addComponent(myTextField);
        this.show();

        myTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String sCommand = myTextField.getText().toString();
                myTextField.clear();

                //switch statement to handle the user input
                switch (sCommand.charAt(0)) {
                    case 'e':
                        gw.expand();
                        break;
                    case 'c':



                }
            }
        });


    }

}
