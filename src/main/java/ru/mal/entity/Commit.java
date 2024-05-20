package ru.mal.entity;

public class Commit {

    private String nickName;
    private String hash;
    private String dateTime;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Commit(String nickName, String hash, String dateTime) {
        this.nickName = nickName;
        this.hash = hash;
        this.dateTime = dateTime;
    }

    public Commit() {
    }
}
