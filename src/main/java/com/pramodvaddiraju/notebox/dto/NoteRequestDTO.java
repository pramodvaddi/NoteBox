package com.pramodvaddiraju.notebox.dto;

import jakarta.validation.constraints.NotBlank;

public class NoteRequestDTO {

    @NotBlank(message = "Title should not be null")
    private String title;

    @NotBlank(message = "Content should not be null")
    private String content;
    private String internalTag;

    public NoteRequestDTO(){

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
