package com.pinyin.utils;

import android.app.Application;

import com.pinyin.model.Person;

/**
 * Created by Liusirui on 2017/3/7.
 */

public class MyApplication extends Application {
    private static Person person;


    public static Person getPerson() {
        return person;
    }

    public static void setPerson(Person p) {
        person = p;
    }
}
