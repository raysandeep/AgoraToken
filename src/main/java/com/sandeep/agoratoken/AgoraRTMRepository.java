package com.sandeep.agoratoken;

public class AgoraRTMRepository {
    static String appId = "APP_ID";
    static String appCertificate = "APP_CERT";
    private static String userId;
    private static int expireTimestamp = 0;

    public static String getAppId() {
        return appId;
    }

    public static String getAppCertificate() {
        return appCertificate;
    }

    public static void setAppCertificate(String appCertificate) {
        AgoraRTMRepository.appCertificate = appCertificate;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        AgoraRTMRepository.userId = userId;
    }

    public static int getExpireTimestamp() {
        return expireTimestamp;
    }

    public static void setExpireTimestamp(int expireTimestamp) {
        AgoraRTMRepository.expireTimestamp = expireTimestamp;
    }

    public static void setAppId(String appId) {
        AgoraRTMRepository.appId = appId;
    }
}
