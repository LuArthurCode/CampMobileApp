package com.mvgx.me.event;

public class LanguageEvent {
   private String language;

    public String getLanguage() {
        return language == null ? "" : language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
