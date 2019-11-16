package com.brilltech.rccs.component;

import com.brilltech.rccs.activities.login.LoginActivity;
import com.brilltech.rccs.component.module.AppModule;
import com.brilltech.rccs.component.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
   void inject(LoginActivity loginActivity);
}