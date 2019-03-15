package practice.leetcode.medium;

import java.util.*;

public class DesignTwitter {
}

/**
 * @design
 *
 * postTweet(userId, tweetId): Compose a new tweet.
 *
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the user herself.
 * Tweets must be ordered from most recent to least recent.
 *
 * follow(followerId, followeeId):Follower follows a followee.
 *
 * unfollow(followerId, followeeId):
 * Follower unfollows a followee.
 *
 * post tweet:
 * user id -> a list of tweet ids
 * get news feed: based on user id, get the 10 most recent ids (from last to first)
 * follow: another may user id -> a set of user ids
 * unfollow: remove from the set
 */
class Twitter {
    Map<Integer, List<Tweet>> tweets;
    Map<Integer, Set<Integer>> followers;
    int ts = 0;
    int maxFeed = 10;

    public Twitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
//            followers.put(userId, new HashSet<>());
            follow(userId, userId);
        }
        tweets.get(userId).add(0, new Tweet(tweetId, ts++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!followers.containsKey(userId)) return res;
        PriorityQueue<Tweet> feed = new PriorityQueue<>((a, b) -> a.time - b.time);
        Set<Integer> set = followers.get(userId);
        if (set == null || set.size() == 0) return res;
        for (int id : set) {
            if (tweets.get(id) == null || tweets.get(id).size() == 0) continue;
            for (int i = 0; i < Math.min(10, tweets.get(id).size()); i++) {
                feed.offer(tweets.get(id).get(i));
                if (feed.size() > maxFeed) feed.poll();
            }
        }
        while (!feed.isEmpty()) {
            res.add(0, feed.poll().id);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId) || followerId == followeeId) return;
        followers.get(followerId).remove(followeeId);
    }

    class Tweet {
        int id;
        int time;
        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        twitter.follow(1,2);
        twitter.follow(2,1);
        twitter.getNewsFeed(2);
        twitter.postTweet(2,6);
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(2,1);
        twitter.getNewsFeed(1);
        twitter.getNewsFeed(2);
        twitter.unfollow(1,2);
        twitter.getNewsFeed(1);
        twitter.getNewsFeed(2);
//        twitter.postTweet(1,11);
//        System.out.println(twitter.getNewsFeed(1));
//        twitter.follow(2,1);
//        twitter.postTweet(2,21);
//        twitter.postTweet(2,22);
//        twitter.postTweet(1,12);
//        twitter.postTweet(2,23);
//        System.out.println(twitter.getNewsFeed(2));
//        twitter.unfollow(2,1);
//        System.out.println(twitter.getNewsFeed(2));
    }
}
