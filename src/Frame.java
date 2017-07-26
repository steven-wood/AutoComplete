import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Frame extends JFrame {

    private int width = 200;
    private int height = 160;
    KeyboardListener kl;

    public Frame(){
        kl = new KeyboardListener();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

        this.setSize(new Dimension(width, height));
        this.setLocation(rect.width-width, rect.height-height-75);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setAlwaysOnTop( true );
        this.setVisible(true);
    }


}
