import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class KeyboardListener implements NativeKeyListener {

    private HashMap<Integer, Boolean> pressedTable;
    String currentString = "";
    public KeyboardListener(){
        try {
			/* Register jNativeHook */
            GlobalScreen.setEventDispatcher(new VoidDispatchService());
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(this);
        } catch (NativeHookException ex) {
            System.out.println("Native Hook Was Not Enabled!");
        }
        LogManager.getLogManager().reset();
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
    }


    /*
        If a key is pressed, its corresponding keycode will be set to true in the hashtable. When the key
        is released, it will be set to null.
     */
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        //pressedTable.put(e.getKeyCode(), true);
        if(e.getKeyCode()==KeyboardProcessor.SPACE.getKeyNum()){
            currentString = "";
        }
        else if(e.getKeyCode()==KeyboardProcessor.BACKSPACE.getKeyNum())
            currentString = currentString.substring(0, currentString.length()-1);
        else
            currentString+=KeyboardProcessor.getString(e.getKeyCode());
        System.out.println(currentString+"\n \n \n \n");
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        pressedTable.put(e.getKeyCode(), null);

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {}

    public void killEvent(NativeKeyEvent e){
        try {
            Field f = NativeInputEvent.class.getDeclaredField("reserved");
            f.setAccessible(true);
            f.setShort(e, (short) 0x01);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
