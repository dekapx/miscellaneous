package com.kapx.java8.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValidator {
    private static final Pattern URL_PATTERN = Pattern.compile("^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?");
    private static final String PATTERN = "/^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$/";
    private static final String urlRegex = "\b(https?|ftp|file|ldap)://"
            + "[-A-Za-z0-9+&@#/%?=~_|!:,.;]"
            + "*[-A-Za-z0-9+&@#/%=~_|]";

    private static final Pattern REGEX = Pattern.compile(urlRegex);

    public static void main(String[] args) {
        final List<String> urls = getUrls();
        for (String url : urls) {
            final boolean isValidUrl = isValidUrl(url);
            System.out.println(url + " -> " + isValidUrl);
        }
    }

    public static boolean isValidUrl(final String url) {
        final Matcher matcher = URL_PATTERN.matcher(url);
        if (matcher.find()) {
            return true;
        }
        return false;
    }


    private static List<String> getUrls() {
        final List<String> urls = new ArrayList<>();
        urls.add("https://code.tutsplus.com/");
        urls.add("\"<script>alert(10);</script>");
        urls.add("https://www.google.ie/");
        urls.add("http://");
        urls.add("ttp://.");
        urls.add("http://..");
        urls.add("http://../");
        urls.add("http://?");
        urls.add("http://??");
        urls.add("http://??/");
        urls.add("http://#");
        urls.add("http://##");
        urls.add("http://##/");
        return urls;
    }
}
