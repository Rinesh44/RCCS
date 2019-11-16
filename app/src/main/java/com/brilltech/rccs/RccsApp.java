package com.brilltech.rccs;

import android.app.Application;
import android.content.Context;

import com.brilltech.rccs.component.AppComponent;
import com.brilltech.rccs.component.DaggerAppComponent;
import com.brilltech.rccs.component.module.AppModule;
import com.brilltech.rccs.component.module.NetModule;
import com.brilltech.rccs.realm.RealmDatabase;

public class RccsApp extends Application {
    private static final String TAG = "RccsApp";
    private static Context context;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        RccsApp.context = getApplicationContext();

        setUpRealm();
    }

    public static RccsApp getMyApplication(Context context) {
        return (RccsApp) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .netModule(new NetModule())
                    .build();
        }
        return appComponent;
    }

    private void setUpRealm() {
        RealmDatabase.init(this);
    }
}
