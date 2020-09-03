package com.sandeep.agoratoken.sample;

import com.sandeep.agoratoken.media.RtcTokenBuilder;
import com.sandeep.agoratoken.media.RtcTokenBuilder.Role;

public class RtcTokenBuilderSample {
    static String appId = "3f3280678a214a30b86b5cde6c27e5c6";
    static String appCertificate = "ebf1d64e51694dca8a31056c08333e7d";
    static String channelName = "7d72365eb983485397e3e3f9d460bdda";
    static String userAccount = "2082341273";
    static int uid = 2082341273;
    static int expirationTimeInSeconds = 3600; 

    public static void main(String[] args) throws Exception {
        RtcTokenBuilder token = new RtcTokenBuilder();
        int timestamp = (int)(System.currentTimeMillis() / 1000 + expirationTimeInSeconds);
        String result = token.buildTokenWithUserAccount(appId, appCertificate,  
        		 channelName, userAccount, Role.Role_Publisher, timestamp);
        System.out.println(result);
        
        result = token.buildTokenWithUid(appId, appCertificate,  
       		 channelName, uid, Role.Role_Publisher, timestamp);
        System.out.println(result);
    }
}
