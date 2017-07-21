package com.example.who.chatdb2.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by who on 21.07.2017.
 */

public class Message {
    @SerializedName("is_read")
    @Expose
    private Boolean isRead;
    @SerializedName("sender")
    @Expose
    private Sender sender;
    @SerializedName("create_date")
    @Expose
    private String createDate;
    @SerializedName("text")
    @Expose
    private String text;

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
