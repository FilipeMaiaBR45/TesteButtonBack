package com.example.testebuttonback;

import android.accessibilityservice.AccessibilityButtonController;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import java.util.List;

public class MyAccessibilityService extends AccessibilityService {
    private static final String TAG = "MyAccessibilityServiceee";



    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

//        int eventType = event.getEventType();
//        if (eventType == AccessibilityEvent.TYPE_VIEW_CLICKED) {
//            // Se o evento for de clique, você pode manipulá-lo aqui
//            Log.d(TAG, "Clique detectado!");
//            // Aqui você pode adicionar a lógica para notificar seu aplicativo sobre o evento de clique
//        } else if (eventType == AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_START) {
//            // Se o evento for um gesto de exploração de toque, você pode manipulá-lo aqui
//            Log.d(TAG, "Gesto de exploração de toque detectado!");
//            // Aqui você pode adicionar a lógica para notificar seu aplicativo sobre o evento de gesto de toque
//        }



        if (event.getSource() != null){
            //Log.d(TAG, "nome do botão: " + event.getSource().toString());
            if (event.getSource().getContentDescription() != null){
                if (event.getSource().getContentDescription().equals("Voltar")){
                    Log.d(TAG, "clicou no voltar");
                }
            }

//            if (event.getSource().getViewIdResourceName().equals("any of the values given above as home....")){
//                //Do your stuff
//            }
        }

    }



    @Override
    public void onInterrupt() {

    }

    private AccessibilityButtonController accessibilityButtonController;
    private AccessibilityButtonController
            .AccessibilityButtonCallback accessibilityButtonCallback;
    private boolean mIsAccessibilityButtonAvailable;

    public void onServiceConnected() {
        // Set the type of events that this service wants to listen to. Others
        // aren't passed to this service.
        Log.d(TAG, "conectou");

        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED |
                AccessibilityEvent.TYPE_VIEW_FOCUSED;

        info.flags = AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS;

        // If you only want this service to work with specific apps, set their
        // package names here. Otherwise, when the service is activated, it listens
        // to events from all apps.


        // Set the type of feedback your service provides.
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;

        // Default services are invoked only if no package-specific services are
        // present for the type of AccessibilityEvent generated. This service is
        // app-specific, so the flag isn't necessary. For a general-purpose service,
        // consider setting the DEFAULT flag.

        // info.flags = AccessibilityServiceInfo.DEFAULT;

        info.notificationTimeout = 100;

        this.setServiceInfo(info);
    }
}



////    private static final String TAG = "MyAccessibilityService";
////
////    @Override
////    public void onAccessibilityEvent(AccessibilityEvent event) {
////
////        //Log.d(TAG, "onAccessibiltyEvent" + event.toString());
////
////        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_CLICKED){
////            //Log.e(TAG, "CLICK NO BOTAO" );
////        }
////
////    }
////
////    @Override
////    public void onInterrupt() {
////        Log.e(TAG, "onInterrupt: algo deu errado");
////    }
////
////    @Override
////    protected boolean onKeyEvent(KeyEvent event) {
////        return handleKeyEvent(event);
////    }
////
////    private boolean handleKeyEvent(KeyEvent event) {
////        int action = event.getAction();
////        int keyCode = event.getKeyCode();
////        if (action == KeyEvent.ACTION_DOWN) {
////            switch (keyCode) {
////                case KeyEvent.KEYCODE_VOLUME_DOWN:
////                    Log.e(TAG, "cliclou no button");
////                    return true;
////
////                case KeyEvent.KEYCODE_VOLUME_UP: {
////                    Log.e(TAG, "cliclou no button");
////                    return true;
////                }
////            }
////        }
////        return false;
////    }
////
////    @Override
////    protected void onServiceConnected() {
////
////        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
////
////        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
////
////
////
////
////        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;
////
////
////
////        info.notificationTimeout = 100;
////
////        this.setServiceInfo(info);
////        Log.e(TAG, "onServiceConnected: ");
////    }
//
//
//    // codigo que mostra a activity
//
//    private static final String TAG = "MyAccessibilityService";
//
//    private AccessibilityButtonController accessibilityButtonController;
//    private AccessibilityButtonController
//            .AccessibilityButtonCallback accessibilityButtonCallback;
//    private boolean mIsAccessibilityButtonAvailable;
//
////    @Override
////    public void onAccessibilityEvent(AccessibilityEvent event) {
////
////        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
////            CharSequence packageName = event.getPackageName();
////            CharSequence className = event.getClassName();
////            //Log.d(TAG, "Package: " + packageName + ", Class: " + className);
////        }if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_CLICKED){
////            //Log.d(TAG, "clicou no botão");
////        }
////    }
//
//    @Override
//    public void onAccessibilityEvent(AccessibilityEvent event) {
//        final int eventType = event.getEventType();
//        if (eventType == AccessibilityEvent.TYPE_VIEW_CLICKED) {
//            AccessibilityNodeInfo nodeInfo = event.getSource();
//            if (nodeInfo != null && nodeInfo.getClassName().equals("android.widget.Button")) {
//                Log.d(TAG, "Accessibility button pressed!");
//                // O clique foi realizado em um botão
//                // Faça aqui o que você deseja fazer com o clique no botão
//            }
//        }
//    }
//
//    @Override
//    public void onInterrupt() {
//        // Este método é chamado quando o serviço de acessibilidade é interrompido.
//    }
//
//    @Override
//    public boolean onKeyEvent(KeyEvent event) {
//        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
//            // O botão "Back" foi pressionado
//            Log.d(TAG, "Botão 'Back' pressionado");
//            // Retorna true para indi
//            //
//            // ar que o evento foi consumido e tratado
//            return true;
//        }
//        // Retorna false para permitir que outros tratadores de eventos processem o evento
//        return super.onKeyEvent(event);
//    }
//
//    @Override
//    protected void onServiceConnected() {
//        accessibilityButtonController = getAccessibilityButtonController();
//        mIsAccessibilityButtonAvailable =
//                accessibilityButtonController.isAccessibilityButtonAvailable();
//
//        if (!mIsAccessibilityButtonAvailable) {
//            Log.d(TAG, "entrou no if " + mIsAccessibilityButtonAvailable);
//            return;
//        }
//
//        AccessibilityServiceInfo serviceInfo = getServiceInfo();
//        serviceInfo.flags = AccessibilityServiceInfo.FLAG_REQUEST_ACCESSIBILITY_BUTTON;
//        setServiceInfo(serviceInfo);
//
//        accessibilityButtonCallback =
//                new AccessibilityButtonController.AccessibilityButtonCallback() {
//                    @Override
//                    public void onClicked(AccessibilityButtonController controller) {
//                        Log.d(TAG, "Accessibility button pressed!");
//
//                        // Add custom logic for a service to react to the
//                        // accessibility button being pressed.
//                    }
//
//                    @Override
//                    public void onAvailabilityChanged(
//                            AccessibilityButtonController controller, boolean available) {
//                        if (controller.equals(accessibilityButtonController)) {
//                            mIsAccessibilityButtonAvailable = available;
//                        }
//                    }
//                };
//
//        accessibilityButtonController.registerAccessibilityButtonCallback(
//                accessibilityButtonCallback, null);
//    }

//    @Override
//    protected void onServiceConnected() {
//        super.onServiceConnected();
//
//        accessibilityButtonController = getAccessibilityButtonController();
//        mIsAccessibilityButtonAvailable =
//                accessibilityButtonController.isAccessibilityButtonAvailable();
//
//        if (!mIsAccessibilityButtonAvailable) {
//            return;
//        }
//
//        AccessibilityServiceInfo serviceInfo = getServiceInfo();
//        serviceInfo.flags |= AccessibilityServiceInfo.FLAG_REQUEST_ACCESSIBILITY_BUTTON;
//        setServiceInfo(serviceInfo);
//
//        //info.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED|AccessibilityEvent.TYPE_VIEW_CLICKED;
//
//        accessibilityButtonCallback =
//                new AccessibilityButtonController.AccessibilityButtonCallback() {
//                    @Override
//                    public void onClicked(AccessibilityButtonController controller) {
//                        Log.d(TAG, "clicou no botão acessibility");
//
//                        // Add custom logic for a service to react to the
//                        // accessibility button being pressed.
//                    }
//
//                    @Override
//                    public void onAvailabilityChanged(
//                            AccessibilityButtonController controller, boolean available) {
//                        if (controller.equals(accessibilityButtonController)) {
//                            mIsAccessibilityButtonAvailable = available;
//                        }
//                    }
//                };
//
//        if (accessibilityButtonCallback != null) {
//            accessibilityButtonController.registerAccessibilityButtonCallback(
//                    accessibilityButtonCallback, null);
//        }
//
//        //AccessibilityServiceInfo info = new AccessibilityServiceInfo();
//
//        //info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
//        //setServiceInfo(info);
//    }
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