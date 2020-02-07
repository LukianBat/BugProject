package com.education.bugproject;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class MyBehavior<V extends View> extends BottomSheetBehavior<V> {

    public MyBehavior() {
    }

    public MyBehavior(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout parent, @NonNull V child, @NonNull MotionEvent event) {
        Boolean intercept = super.onInterceptTouchEvent(parent, child, event);
        Log.i("TAG", "state = " + getState() + "onInterceptTouchEvent = " + intercept);
        return intercept;
    }

    @Override
    public void onRestoreInstanceState(
            @NonNull CoordinatorLayout parent, @NonNull V child, @NonNull Parcelable state) {
        Log.i("TAG", "onRestoreInstanceState");
        super.onRestoreInstanceState(parent, child, state);
    }

    @Override
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        Log.i("TAG", "onAttachedToLayoutParams");
        super.onAttachedToLayoutParams(layoutParams);
    }

    @Override
    public void onDetachedFromLayoutParams() {
        Log.i("TAG", "onDetachedFromLayoutParams");
        super.onDetachedFromLayoutParams();
    }

    @Override
    public boolean onLayoutChild(
            @NonNull CoordinatorLayout parent, @NonNull V child, int layoutDirection) {
        Log.i("TAG", "onLayoutChild");
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean onTouchEvent(
            @NonNull CoordinatorLayout parent, @NonNull V child, @NonNull MotionEvent event) {
        Log.i("TAG", "onTouchEvent " + event.toString());
        return super.onTouchEvent(parent, child, event);
    }

    @Override
    public boolean onStartNestedScroll(
            @NonNull CoordinatorLayout coordinatorLayout,
            @NonNull V child,
            @NonNull View directTargetChild,
            @NonNull View target,
            int axes,
            int type) {
        Log.i("TAG", "type = " + type);
        Log.i("TAG", "onStartNestedScroll");
        try {
            Field nestedScrollingChildRefField = this.getClass().getSuperclass().getDeclaredField("nestedScrollingChildRef");
            nestedScrollingChildRefField.setAccessible(true);
            nestedScrollingChildRefField.set(this, new WeakReference<>(target));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Log.i("TAG", e.toString());
            e.printStackTrace();
        }
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public void onNestedPreScroll(
            @NonNull CoordinatorLayout coordinatorLayout,
            @NonNull V child,
            @NonNull View target,
            int dx,
            int dy,
            @NonNull int[] consumed,
            int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
    }

    @Override
    public void onStopNestedScroll(
            @NonNull CoordinatorLayout coordinatorLayout,
            @NonNull V child,
            @NonNull View target,
            int type) {
        Log.i("TAG", "onStopNestedScroll");
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
    }

    @Override
    public void onNestedScroll(
            @NonNull CoordinatorLayout coordinatorLayout,
            @NonNull V child,
            @NonNull View target,
            int dxConsumed,
            int dyConsumed,
            int dxUnconsumed,
            int dyUnconsumed,
            int type,
            @NonNull int[] consumed) {
        Log.i("TAG", "onNestedScroll");
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
    }

    @Override
    public boolean onNestedPreFling(
            @NonNull CoordinatorLayout coordinatorLayout,
            @NonNull V child,
            @NonNull View target,
            float velocityX,
            float velocityY) {
        Log.i("TAG", "onNestedPreFling");
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }
}