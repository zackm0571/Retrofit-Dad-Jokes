package com.example.zack.retro;

import java.util.Locale;

public class DadJoke {

    public String id;
    public String joke;
    public int status;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return String.format(Locale.getDefault(), "id: %s\njoke:%s\nstatus:%d", id, joke, status);
    }
}
