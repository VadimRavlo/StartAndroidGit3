package com.example.p0981servicebindinglocal;

import android.os.Binder;

/**
 * Created by administrator on 20.08.2016.
 */
public class MainBinder extends Binder {

    MainService service;

    public MainBinder(MainService service) {
        this.service = service;
    }

    MainService getService(){
        return service;
    }
}
