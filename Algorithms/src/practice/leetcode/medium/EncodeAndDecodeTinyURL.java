package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @design
 *
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
 * and it returns a short URL such as http://tinyurl.com/4e9iAk.
 *
 * Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 *
 *
 */
public class EncodeAndDecodeTinyURL {
    class Codec {
        Map<Integer, String> map = new HashMap<>();
        public String encode(String longUrl) {
            int h = longUrl.hashCode();
            map.put(h, longUrl);
            return "http://tinyurl.com/" + h;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String url = map.get(Integer.valueOf(shortUrl.replace("http://tinyurl.com/", "")));
            return url;
        }
    }
}