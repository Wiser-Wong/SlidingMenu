package com.wiser.slidingmenu;

import com.wiser.library.SlidingMenu;
import com.wiser.library.activity.SlidingMenuActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.animation.Interpolator;

public class MainActivity extends SlidingMenuActivity {

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setBehindOffsetRes(R.dimen.sliding_menu_offset);
		sm.setFadeDegree(0.5f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.setMode(SlidingMenu.LEFT_RIGHT);
		 setSlidingActionBarEnabled(true);
		 sm.setBehindScrollScale(0.0f);
		 sm.setBehindCanvasTransformer(new SlidingMenu.CanvasTransformer() {
		 @Override
		 public void transformCanvas(Canvas canvas, float percentOpen) {
		// float scale = (float) (percentOpen*0.25 + 0.75);
		// canvas.scale(scale, scale, canvas.getWidth()/2, canvas.getHeight()/2);
		 canvas.translate(canvas.getHeight()*(1-new Interpolator() {
		 @Override
		 public float getInterpolation(float t) {
		 t -= 1.0f;
		 return t * t * t + 1.0f;
		 }
		 }.getInterpolation(percentOpen)), 0);
		 }
		 });

		setBehindContentView(R.layout.left_frame);
		sm.setShadowDrawable(R.drawable.shadow_left);
		getSupportFragmentManager().beginTransaction().replace(R.id.left_frame, new LeftMenuFragment()).commit();

		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new ContentFragment()).commit();

		getSlidingMenu().setSecondaryMenu(R.layout.right_frame);
		getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadow_right);
		getSupportFragmentManager().beginTransaction().replace(R.id.right_frame, new RightMenuFragment()).commit();
	}
}
