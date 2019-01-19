/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easycoop.radical.lib.alert;

import com.easycoop.radical.lib.model.Authentication;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

    public static String getEmailTemplate(String tempatePath, String templateName) {
        Path wiki_path = Paths.get(tempatePath, templateName);

        Charset charset = Charset.forName("ISO-8859-1");
        StringBuilder sb = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(wiki_path, charset);

            int index = 0;
            System.out.println("Template path \t\t Index");
            for (String line : lines) {
                index++;
                System.out.println(line + "\t\t" + index);
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return sb.toString();
    }

}
