package com.example.testebuttonback;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

import java.util.List;

public class MyAccessibilityService extends AccessibilityService {

//    private static final String TAG = "MyAccessibilityService";
//
//    @Override
//    public void onAccessibilityEvent(AccessibilityEvent event) {
//
//        //Log.d(TAG, "onAccessibiltyEvent" + event.toString());
//
//        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_CLICKED){
//            //Log.e(TAG, "CLICK NO BOTAO" );
//        }
//
//    }
//
//    @Override
//    public void onInterrupt() {
//        Log.e(TAG, "onInterrupt: algo deu errado");
//    }
//
//    @Override
//    protected boolean onKeyEvent(KeyEvent event) {
//        return handleKeyEvent(event);
//    }
//
//    private boolean handleKeyEvent(KeyEvent event) {
//        int action = event.getAction();
//        int keyCode = event.getKeyCode();
//        if (action == KeyEvent.ACTION_DOWN) {
//            switch (keyCode) {
//                case KeyEvent.KEYCODE_VOLUME_DOWN:
//                    Log.e(TAG, "cliclou no button");
//                    return true;
//
//                case KeyEvent.KEYCODE_VOLUME_UP: {
//                    Log.e(TAG, "cliclou no button");
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    @Override
//    protected void onServiceConnected() {
//
//        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
//
//        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
//
//
//
//
//        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;
//
//
//
//        info.notificationTimeout = 100;
//
//        this.setServiceInfo(info);
//        Log.e(TAG, "onServiceConnected: ");
//    }


    // codigo que mostra a activity

    private static final String TAG = "MyAccessibilityService";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            CharSequence packageName = event.getPackageName();
            CharSequence className = event.getClassName();
            Log.d(TAG, "Package: " + packageName + ", Class: " + className);
        }
    }

    @Override
    public void onInterrupt() {
        // Este método é chamado quando o serviço de acessibilidade é interrompido.
    }

    @Override
    public boolean onKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            // O botão "Back" foi pressionado
            Log.d(TAG, "Botão 'Back' pressionado");
            // Retorna true para indicar que o evento foi consumido e tratado
            return true;
        }
        // Retorna false para permitir que outros tratadores de eventos processem o evento
        return super.onKeyEvent(event);
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        setServiceInfo(info);
    }
//    private static final String TAG = "MyAccessibilityService";
//
//    @Override
//    public void onAccessibilityEvent(AccessibilityEvent event) {
//        // Lógica para lidar com eventos de acessibilidade
//    }
//
//    @Override
//    public boolean onKeyEvent(KeyEvent event) {
//        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
//            // O botão "Back" foi pressionado
//            Log.d(TAG, "Botão 'Back' pressionado");
//            // Retorna true para indicar que o evento foi consumido e tratado
//            return true;
//        }
//        // Retorna false para permitir que outros tratadores de eventos processem o evento
//        return super.onKeyEvent(event);
//    }
//
//    @Override
//    public void onInterrupt() {
//        // Este método é chamado quando o serviço de acessibilidade é interrompido.
//    }
//
//    @Override
//    protected void onServiceConnected() {
//        super.onServiceConnected();
//
//        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
//        info.eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED | AccessibilityEvent.TYPE_VIEW_FOCUSED | AccessibilityEvent.TYPE_VIEW_LONG_CLICKED;
//        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
//        info.flags = AccessibilityServiceInfo.DEFAULT;
//        setServiceInfo(info);
//    }
}