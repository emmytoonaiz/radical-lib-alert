/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easycoop.radical.lib.alert;

import com.easycoop.radical.lib.model.Authentication;
import com.easycoop.radical.lib.model.MessageDetails;
import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author akinw
 */
public class TextAlert {
     private final Client client;
    private WebTarget smsUrlTarget;
    private final String sendSmsUrl = "http://107.20.199.106/restapi/sms/1/text/single";

    public TextAlert() {
        this.client = ClientBuilder.newClient();
        this.smsUrlTarget = this.client.target(sendSmsUrl);
    }
    
    public void sendSingleText(Authentication auth, MessageDetails msg) {
        try {
            Gson gson = new Gson();
            String payload = gson.toJson(msg);
            System.out.println("payload before sending..." + payload);
            smsUrlTarget = client.target(sendSmsUrl);
            String response = smsUrlTarget.request(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Basic " + Util.getEncodeCredentials(auth))
                    .post(Entity.json(payload))
                    .readEntity(String.class);
            System.out.println("Response:::" + response);
        } catch (Exception ex) {
            System.out.println("Error occured due to: " + ex);
        }
    }
}
