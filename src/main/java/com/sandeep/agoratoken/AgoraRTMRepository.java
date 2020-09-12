package com.sandeep.agoratoken;

public class AgoraRTMRepository {
    static String appId = "APP_ID";
    static String appCertificate = "APP_CERT";
    private String userId;
    private int expireTimestamp = 0;

    public static String getAppId() {
        return appId;
    }

    public static String getAppCertificate() {
        return appCertificate;
    }

    public static void setAppCertificate(String appCertificate) {
        AgoraRTMRepository.appCertificate = appCertificate;
    }

    public String getUserId() {
        return userId;
    }
    
    public int getExpireTimestamp() {
        return expireTimestamp;
    }

    public static void setAppId(String appId) {
        AgoraRTMRepository.appId = appId;
    }
}
