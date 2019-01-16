/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easycoop.radical.lib.alert;

import com.easycoop.radical.lib.model.Authentication;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author emmanuel.idoko
 */
public class Util {

    public static String getEncodeCredentials(Authentication auth) {
        if ((auth.getUsername() != null && !auth.getUsername().trim().isEmpty()) && (auth.getPassword() != null && !auth.getPassword().trim().isEmpty())) {
            String authString = auth.getUsername() + ":" + auth.getPassword();
            return (new Base64().encodeToString(authString.getBytes()));
        } else {
            return "Invalid parameters detected.";
        }
    }

}
