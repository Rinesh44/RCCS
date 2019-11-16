package com.example.rccs.dagger.component;

import com.example.rccs.activities.login.LoginActivity;
import com.example.rccs.dagger.component.module.AppModule;
import com.example.rccs.dagger.component.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
   void inject(LoginActivity loginActivity);
}