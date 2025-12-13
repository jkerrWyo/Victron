package com.lightningsports.VictronBatteryMonitor;

/**
 * Created by r_koller on 10/28/2025.
 */
public class VictronFeedProtocol {

    public static VictronKeyValue processFeedString(String feed) {
        int tab=feed.indexOf("\t");
        try {
            if (tab > 0) {
                String key=feed.substring(0, tab).toUpperCase();
                String value=feed.substring(tab + 1);
                String keyMap=VictronCode.fromCode(VictronFeedCode.fromValue(key).getCode()).name();
                return new VictronKeyValue(keyMap,value);
            } else
                throw new Exception("Invalid Feed Row - "+feed);
        } catch (Exception e) {
            return new VictronKeyValue("Error",e.getMessage());
        }
    }
}
