package com.deveshsharma.makenotes.model;

public class Note {
    public static long sno_increment = 0;
    public long sno;
    public String title;
    public String desc;
    public Note(String title,String desc){
        this.sno = sno_increment;
        sno_increment++;
        this.title = title;
        this.desc = desc;
    }
    public Note(long sno,String title,String desc){
        this.sno = sno;
        sno_increment++;
        this.title = title;
        this.desc = desc;
    }
}
