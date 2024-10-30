package xyz.funtimes909.serverseekerv2.network;

import io.ipinfo.api.IPinfo;
import io.ipinfo.api.errors.RateLimitedException;
import xyz.funtimes909.serverseekerv2.Main;

public class IpInfo {
    public static String lookupCountry(String ip) {
        IPinfo ipInfo = new IPinfo.Builder()
                .setToken(Main.token)
                .build();
        try {
            return ipInfo.lookupIP(ip).getCountryName();
        } catch (RateLimitedException e) {
            System.out.println("GeoIP lookup rate limited! Trying secondary API");
            return "No country information avaliable";
            // TODO More stuff here
        }
    }

    public static String lookupAsn(String ip) {
        IPinfo asnInfo = new IPinfo.Builder()
                .setToken(Main.token)
                .build();
        try {
            return asnInfo.lookupASN(ip).getAsn();
        } catch (RateLimitedException e) {
            System.out.println("ASN Lookup rate limited! Trying secondary API");
            return "No country information avaliable";
            // TODO More stuff here
        }
    }
}