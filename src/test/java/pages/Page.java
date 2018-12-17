package pages;

import java.util.concurrent.TimeUnit;

/**
 * Created by mycola on 17.12.2018.
 */
public class Page {

    public static void Sleep(int time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
