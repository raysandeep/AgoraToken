package com.sandeep.agoratoken;

import com.sandeep.agoratoken.media.RtcTokenBuilder;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;

@Path("myresource")
public class MyResource extends Exception {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Object getIt(MyResourceRepository resource) {

        RtcTokenBuilder token = new RtcTokenBuilder();
        String channelName = resource.getChannelName();
        int expireTime = resource.getExpirationTimeInSeconds();
        RtcTokenBuilder.Role role = RtcTokenBuilder.Role.Role_Subscriber;
        int uid = resource.getUid();

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
        JSONObject json = new JSONObject();
        json.put("message",result);
        return json;
    }

}
