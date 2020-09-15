package com.assignment.bookmark.helper;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Random;

@Component
public class UrlShorterHelper {
    private static final String DEFAULT_DOMAIN = "http://sgt.in";
    private HashMap<String, String> keyMap;
    private HashMap<String, String> valueMap;

    private String domain;

    private char charArray[];

    private final Random random;
    private int keyLength;


    UrlShorterHelper() {
        keyMap = new HashMap<>();
        valueMap = new HashMap<>();
        random = new Random();
        keyLength = 8;
        charArray = new char[62];
        for (int i = 0; i < 62; i++) {
            int j = 0;
            if (i < 10) {
                j = i + 48;
            } else if (i > 9 && i <= 35) {
                j = i + 55;
            } else {
                j = i + 61;
            }
            charArray[i] = (char) j;
        }
        domain = DEFAULT_DOMAIN;
    }

    // Constructor which enables you to define tiny URL key length and base URL
    // name
    UrlShorterHelper(int length, String newDomain) {
        this();
        this.keyLength = length;
        if (!newDomain.isEmpty()) {
            newDomain = sanitizeURL(newDomain);
            domain = newDomain;
        }
    }


    public String shortenURL(String longURL) {
        String shortURL = "";
        if (validateURL(longURL)) {
            longURL = sanitizeURL(longURL);
            if (valueMap.containsKey(longURL)) {
                shortURL = domain + "/" + valueMap.get(longURL);
            } else {
                shortURL = domain + "/" + getKey(longURL);
            }
        }

        return shortURL;
    }

    public String expandURL(String shortURL) {
        String longURL = "";
        String key = shortURL.substring(domain.length() + 1);
        longURL = keyMap.get(key);
        return longURL;
    }

    boolean validateURL(String url) {
        return true;
    }

    String sanitizeURL(String url) {
        if (url.substring(0, 7).equals("http://"))
            url = url.substring(7);

        if (url.substring(0, 8).equals("https://"))
            url = url.substring(8);

        if (url.charAt(url.length() - 1) == '/')
            url = url.substring(0, url.length() - 1);
        return url;
    }

    private String getKey(String longURL) {
        String key;
        key = generateKey();
        keyMap.put(key, longURL);
        valueMap.put(longURL, key);

        return key;
    }

    // generateKey
    private String generateKey() {
        String key = "";
        boolean flag = true;
        while (flag) {
            key = "";
            for (int i = 0; i <= keyLength; i++) {
                key += charArray[random.nextInt(62)];
            }

            if (!keyMap.containsKey(key)) {
                flag = false;
            }
        }
        return key;
    }


    public static void main(String args[]) {
        UrlShorterHelper u = new UrlShorterHelper(5, "www.rkturl.com/");
        String urls[] = {"www.google.com/", "www.socgen.com"};

        for (int i = 0; i < urls.length; i++) {
            System.out.println("URL:" + urls[i] + "\tTiny: "
                    + u.shortenURL(urls[i]) + "\tExpanded: "
                    + u.expandURL(u.shortenURL(urls[i])));
        }
    }
}