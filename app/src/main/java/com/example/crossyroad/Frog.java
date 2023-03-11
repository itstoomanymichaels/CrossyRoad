package com.example.crossyroad;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

//import static com.heyletscode.ihavetofly.GameView.screenRatioX;
//import static com.heyletscode.ihavetofly.GameView.screenRatioY;

public class Frog {

    public int x, y, width, height;
    Bitmap frog;
    private GameView gameView;

    Frog (GameView gameView, int screenY, int screenX, Resources res, int sprite) {

        this.gameView = gameView;

        frog = BitmapFactory.decodeResource(res, R.drawable.frog);

        width = 2*screenY/36-30;
        height = 2*screenY/36-30;

        frog = Bitmap.createScaledBitmap(frog, width, height, false);
        y = screenY - height - 15;
        x = screenX/2 - width/2;

    }
    Bitmap getFrog () {
        return frog;
    }

}