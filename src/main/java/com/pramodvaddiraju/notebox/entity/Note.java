package com.pramodvaddiraju.notebox.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "note_details")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    private String internalTag;

    public Note(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInternalTag() {
        return internalTag;
    }

    public void setInternalTag(String internalTag) {
        this.internalTag = internalTag;
    }
}
