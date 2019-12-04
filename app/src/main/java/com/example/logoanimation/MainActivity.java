package com.example.logoanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout viewOne;
    private LinearLayout viewTwo;
    private LinearLayout viewThree;
    private LinearLayout viewFour;
    private LinearLayout viewFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScrollView sv = findViewById(R.id.main_content);
        sv.getViewTreeObserver().addOnScrollChangedListener(new ScrollingHandle(sv));

        viewOne = findViewById(R.id.one);
        viewOne.setX(-1080L);

        viewTwo = findViewById(R.id.two);
        viewTwo.setX(-1080L);

        viewThree = findViewById(R.id.three);
        viewThree.setX(-1080L);

        viewFour = findViewById(R.id.four);
        viewFour.setX(-1080L);

        viewFive = findViewById(R.id.five);
        viewFive.setX(-1080L);
    }

    private class ScrollingHandle implements ViewTreeObserver.OnScrollChangedListener {
        public static final long DURATION_MILLIS = 450L;
        private View view;

        private Animation leftSlideIn;
        private Animation rightSlideIn;
        private Animation bottomSlideIn;
        private Animation rightBottomCorner;
        private Animation leftBottomCornerSlideIn;

        private int numberOfAnimationPlayed;

        public  ScrollingHandle (View view) {
            this.view = view;
            leftSlideIn = new TranslateAnimation(-1080, 0, 0, 0);
            leftSlideIn.setDuration(DURATION_MILLIS);

            rightSlideIn = new TranslateAnimation(1080, 0, 0, 0);
            rightSlideIn.setDuration(DURATION_MILLIS);

            bottomSlideIn = new TranslateAnimation(0, 0, 1080, 0);
            bottomSlideIn.setDuration(DURATION_MILLIS);

            rightBottomCorner = new TranslateAnimation(1080, 0, 1080, 0);
            rightBottomCorner.setDuration(DURATION_MILLIS);

            leftBottomCornerSlideIn = new TranslateAnimation(-1080, 0, 1080, 0);
            leftBottomCornerSlideIn.setDuration(DURATION_MILLIS);

            numberOfAnimationPlayed = 0;
        }

        @Override
        public void onScrollChanged() {
            if(view.getScrollY() >= 0  && view.getScrollY() <= 1000 && numberOfAnimationPlayed == 0){
                viewOne.startAnimation(leftSlideIn);
                viewOne.setX(0);
                numberOfAnimationPlayed++;
            }

            if(view.getScrollY() >= 1400 && view.getScrollY() <= 1500 && numberOfAnimationPlayed == 1) {
                viewTwo.startAnimation(rightSlideIn);
                viewTwo.setX(0);
                numberOfAnimationPlayed++;
            }

            if(view.getScrollY() >= 3800 && view.getScrollY() <= 4000 && numberOfAnimationPlayed == 2) {
                viewThree.startAnimation(rightBottomCorner);
                viewThree.setX(0);
                numberOfAnimationPlayed++;
            }

            if(view.getScrollY() >= 6200 && view.getScrollY() <= 6300 && numberOfAnimationPlayed == 3) {
                viewFour.startAnimation(bottomSlideIn);
                viewFour.setX(0);
                numberOfAnimationPlayed++;
            }

            if(view.getScrollY() >= 8800 && view.getScrollY() <= 9000 && numberOfAnimationPlayed == 4) {
                viewFive.startAnimation(leftBottomCornerSlideIn);
                viewFive.setX(0);
                numberOfAnimationPlayed++;
            }
        }
    }
}
