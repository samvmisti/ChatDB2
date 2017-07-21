package com.example.who.chatdb2.pojo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by who on 21.07.2017.
 */

public class Channel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("last_message")
    @Expose
    private LastMessage lastMessage;
    @SerializedName("users")
    @Expose
    private List<User> users = null;
    @SerializedName("unread_messages_count")
    @Expose
    private Integer unreadMessagesCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LastMessage getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(LastMessage lastMessage) {
        this.lastMessage = lastMessage;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getUnreadMessagesCount() {
        return unreadMessagesCount;
    }

    public void setUnreadMessagesCount(Integer unreadMessagesCount) {
        this.unreadMessagesCount = unreadMessagesCount;
    }

}
