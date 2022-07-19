package com.deveshsharma.makenotes.model;

public class Note {
    public String title;
    public String desc;
    public long sno;
    public Note(String title,String desc){
        this.title = title;
        this.desc = desc;
    }
    public Note(long sno,String title,String desc){
        this.sno = sno;
        this.title = title;
        this.desc = desc;
    }
}
