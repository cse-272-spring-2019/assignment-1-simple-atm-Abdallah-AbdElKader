/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;

public class confirmation {

    HashMap dictinonary;

    public confirmation() {
        dictinonary = new HashMap();
        dictinonary.put("Abdallah", "4676");
    }

    public boolean confirm(String username, String password) {
        boolean result = false;
        String name = (String) dictinonary.get(username);
        if (name != null) {
            result = name.equals(password);
        }
        return result;
    }

}
