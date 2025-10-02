package org.example.wait;

import java.io.IOException;

public class WaitForSometime {

    public static void pleaseWaitForSometime() throws IOException {
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
