package com.idmission;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.StrictMode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.flutter.Log;
import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
private  static final String GPS_CHANNEL= "team.native.io/gps";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.VmPolicy.Builder builder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            builder = new StrictMode.VmPolicy.Builder();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.setVmPolicy(builder.build());
        }
//        GeneratedPluginRegistrant.registerWith(getApplicationContext());

        new MethodChannel(getFlutterView(), GPS_CHANNEL).setMethodCallHandler(
                new MethodChannel.MethodCallHandler() {
                    @Override
                    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
                        if (call.method.equals("gps")) {
                            String fileUri = call.argument("filePath").toString();
                            Log.e("printing in methods", "printed now and channel starts");
                            result.success("Done");
                        } else {
                            result.notImplemented();
                        }

                    }
                });
    }

}
