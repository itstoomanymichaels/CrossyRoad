package com.example.crossyroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Branch extends Log{
    public Branch(int x, int y, int screenY, int screenX, int speed, String direction, Resources res) {
        super(x,y,screenY,screenX,speed,direction);
        log = BitmapFactory.decodeResource(res, R.drawable.bran);
    }
    public Bitmap getLog(){return log;}

    public boolean isCollided(Frog frog){
        return false;
    }
}
