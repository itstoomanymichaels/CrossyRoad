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

        frog = BitmapFactory.decodeResource(res, R.drawable.forg);

        width = frog.getWidth();
        height = frog.getHeight();

        width /= 4;
        height /= 4;

        frog = Bitmap.createScaledBitmap(frog, width, height, false);
        y = screenY-frog.getHeight();
        x = screenX / 2;

    }
    Bitmap getFrog () {
        return frog;
    }

}