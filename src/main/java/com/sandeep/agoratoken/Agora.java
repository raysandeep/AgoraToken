package com.sandeep.agoratoken;

import com.sandeep.agoratoken.media.RtcTokenBuilder;
import com.sandeep.agoratoken.rtm.RtmTokenBuilder;
import com.sandeep.agoratoken.rtm.RtmTokenBuilder.Role;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;

@Path("api")
public class Agora{

    @POST
    @Path("rtc")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getRTCToken(AgoraRepository resource) {

        RtcTokenBuilder token = new RtcTokenBuilder();
        String channelName = resource.getChannelName();
        int expireTime = resource.getExpirationTimeInSeconds();
        RtcTokenBuilder.Role role = RtcTokenBuilder.Role.Role_Subscriber;
        int uid = resource.getUid();

        // check for null channelName
        if (channelName==null){
            JSONObject error=new JSONObject();
            error.put("error","Channel ID cannot be blank");
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }

        if(expireTime==0){
            expireTime = 3600;
        }

        if(resource.getRole()==1){
            role = RtcTokenBuilder.Role.Role_Publisher;
        }else if(resource.getRole()==0){
            role = RtcTokenBuilder.Role.Role_Attendee;
        }

        int timestamp = (int)(System.currentTimeMillis() / 1000 + expireTime);


        String result = token.buildTokenWithUid(resource.appId, resource.appCertificate,
                channelName, uid, role, timestamp);
        System.out.print(result);
        JSONObject jsondict = new JSONObject();
        jsondict.put("message",result);
        return jsondict;


    }

    @POST
    @Path("rtm")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getRTMToken(AgoraRTMRepository resource) throws Exception {

        String userId = resource.getUserId();

        if (userId==null){
            JSONObject error=new JSONObject();
            error.put("error","Channel ID cannot be blank");
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }

        RtmTokenBuilder token = new RtmTokenBuilder();
        String result = token.buildToken(resource.getAppId(), resource.getAppCertificate(), userId, Role.Rtm_User, resource.getExpireTimestamp());
        System.out.println(result);
        JSONObject jsondict = new JSONObject();
        jsondict.put("message",result);
        return jsondict;
    }

}