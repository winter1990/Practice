package practice.leetcode.medium;

import java.util.*;

public class DesignTwitter {
}

/*
postTweet(userId, tweetId):
Compose a new tweet.

getNewsFeed(userId):
Retrieve the 10 most recent tweet ids in the user's news feed.
Each item in the news feed must be posted by users who the user followed or by the user herself.
Tweets must be ordered from most recent to least recent.

follow(followerId, followeeId):
Follower follows a followee.

unfollow(followerId, followeeId):
Follower unfollows a followee.
 */

/**
 * user->tweets
 * user->followers
 */
class Twitter {
    Map<Integer, List<Integer>> users;
    Map<Integer, Set<Integer>> followers;
    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
        followers = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new ArrayList<>());
        }
        users.get(userId).add(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        List<Integer> tweets = users.get(userId);
        if (tweets.size() < 10) {
            for (int i = tweets.size() - 1; i >= 0; i--) {
                res.add(tweets.get(i));
            }
        } else {
            for (int i = tweets.size() - 1; i >= tweets.size() - 10; i--) {
                res.add(tweets.get(i));
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followeeId)) {
            followers.put(followeeId, new HashSet<>());
        }
        followers.get(followeeId).add(followerId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    }
}
