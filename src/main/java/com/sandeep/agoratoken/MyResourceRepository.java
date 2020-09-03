package com.sandeep.agoratoken;

public class MyResourceRepository {
    static String appId = "3f3280678a214a30b86b5cde6c27e5c6";
    static String appCertificate = "ebf1d64e51694dca8a31056c08333e7d";
    private String channelName;
    private int uid = 0;
    private int expirationTimeInSeconds = 3600;
    private int role = 2; // By default subscriber

    public static String getAppId() {
        return appId;
    }

    public static void setAppId(String appId) {
        MyResourceRepository.appId = appId;
    }

    public static String getAppCertificate() {
        return appCertificate;
    }

    public static void setAppCertificate(String appCertificate) {
        MyResourceRepository.appCertificate = appCertificate;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getExpirationTimeInSeconds() {
        return expirationTimeInSeconds;
    }

    public void setExpirationTimeInSeconds(int expirationTimeInSeconds) {
        this.expirationTimeInSeconds = expirationTimeInSeconds;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
