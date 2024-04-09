package com.example.testebuttonback;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class FloatingButtonService extends Service {

    private WindowManager windowManager;
    private View floatingView;

    public FloatingButtonService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        // Inflar o layout do botão flutuante
        floatingView = LayoutInflater.from(this).inflate(R.layout.layout_floating_button, null);

        // Configurar o WindowManager
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );

        // Configurar a posição do botão flutuante
        params.gravity = Gravity.BOTTOM | Gravity.END;
        params.x = 16;
        params.y = 16;

        // Adicionar o botão flutuante à janela do sistema
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        windowManager.addView(floatingView, params);

        // Configurar o clique do botão flutuante
        Button btnFloating = floatingView.findViewById(R.id.btnFloating);
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adicione sua lógica de clique aqui
            }
        });

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (floatingView != null) {
            windowManager.removeView(floatingView);
        }
    }
}
