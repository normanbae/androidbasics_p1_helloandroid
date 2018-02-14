package com.baeinc.normanbae.helloandroid;

import android.widget.ImageView;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

    public class MainActivity extends Activity {

        //found this on Google
        //generates random image every time app is opened
        final Random rnd = new Random();

        protected final static int getResourceID
                (final String resName, final String resType, final Context ctx) {
            final int ResourceID =
                    ctx.getResources().getIdentifier(resName, resType,
                            ctx.getApplicationInfo().packageName);
            if (ResourceID == 0) {
                throw new IllegalArgumentException
                        (
                                "No resource string found with name " + resName
                        );
            } else {
                return ResourceID;
            }
        }

        @Override
        protected void onCreate(
                final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            final ImageView img = (ImageView) findViewById(R.id.imgRandom);
            // I have 3 images named img_0 to img_2, so...
            final String str = "nanodegree_" + rnd.nextInt(3);
            img.setImageDrawable
                    (
                            getResources().getDrawable(getResourceID(str, "drawable",
                                    getApplicationContext()))
                    );
        }
    }
