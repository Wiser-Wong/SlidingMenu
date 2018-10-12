package com.wiser.slidingmenu;

import com.wiser.library.SlidingMenu;
import com.wiser.library.activity.SlidingMenuActivity;

import android.os.Bundle;

public class MainActivity extends SlidingMenuActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBehindContentView(R.layout.left_frame);
        SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidthRes(R.dimen.shadow_width);
        sm.setShadowDrawable(R.drawable.shadow_left);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setFadeDegree(0.35f);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		// setSlidingActionBarEnabled(true);
		// sm.setBehindScrollScale(0.0f);
		// sm.setBehindCanvasTransformer(new SlidingMenu.CanvasTransformer() {
		// @Override
		// public void transformCanvas(Canvas canvas, float percentOpen) {
		//// float scale = (float) (percentOpen*0.25 + 0.75);
		//// canvas.scale(scale, scale, canvas.getWidth()/2, canvas.getHeight()/2);
		// canvas.translate(canvas.getHeight()*(1-new Interpolator() {
		// @Override
		// public float getInterpolation(float t) {
		// t -= 1.0f;
		// return t * t * t + 1.0f;
		// }
		// }.getInterpolation(percentOpen)), 0);
		// }
		// });
        setContentView(R.layout.activity_main);
        getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.left_frame, new LeftMenuFragment())
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new ContentFragment())
                .commit();
//
        getSlidingMenu().setSecondaryMenu(R.layout.right_frame);
        getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadow_right);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.right_frame, new RightMenuFragment())
                .commit();
    }
}
