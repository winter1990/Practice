package practice.interview.google;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DesignHashmapWithExpiration {

     static class WeakConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {

        private static final long serialVersionUID = 1L;
        private Map<K, Long> timeMap = new ConcurrentHashMap<K, Long>();
        private long expiryInMillis = 1000;
        private static final SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss:SSS");

        public WeakConcurrentHashMap() {
            initialize();
        }

        public WeakConcurrentHashMap(long expiryInMillis) {
            this.expiryInMillis = expiryInMillis;
            initialize();
        }

        void initialize() {
            new CleanerThread().start();
        }

        @Override
        public V put(K key, V value) {
            Date date = new Date();
            timeMap.put(key, date.getTime());
            System.out.println("Inserting : " + sdf.format(date) + " : " + key + " : " + value);
            V returnVal = super.put(key, value);
            return returnVal;
        }

        @Override
        public void putAll(Map<? extends K, ? extends V> m) {
            for (K key : m.keySet()) {
                put(key, m.get(key));
            }
        }

        @Override
        public V putIfAbsent(K key, V value) {
            if (!containsKey(key))
                return put(key, value);
            else
                return get(key);
        }

        class CleanerThread extends Thread {
            @Override
            public void run() {
                System.out.println("Initiating Cleaner Thread..");
                while (true) {
                    cleanMap();
                    try {
                        Thread.sleep(expiryInMillis / 2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            private void cleanMap() {
                long currentTime = new Date().getTime();
                for (K key : timeMap.keySet()) {
                    if (currentTime > (timeMap.get(key) + expiryInMillis)) {
                        V value = remove(key);
                        timeMap.remove(key);
                        System.out.println("Removing : " + sdf.format(new Date()) + " : " + key + " : " + value);
                    }
                }
            }
        }
    }

    class MyMap<K, V> {
        Map<K, V> map;
        Map<K, Long> time;
        private static final int DEFAULT_CAPACITY = 16;
        private static final float DEFAULT_LOAD_FACTOR = 0.75f;
        private Thread clearThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(5000);
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                    for(K key : map.keySet()) get(key);
                }
            }

        });
        public MyMap() {
            this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
        }
        public MyMap(int capacity) {
            this(capacity, DEFAULT_LOAD_FACTOR);
        }
        public MyMap(int capacity, float loadFactor) {
            map = new ConcurrentHashMap<>(capacity, loadFactor);
            time = new ConcurrentHashMap<>(capacity, loadFactor);
            clearThread.start();
        }
        public synchronized V get(K key) {
            long now = System.currentTimeMillis();
            Long expired = time.get(key);
            if(expired == null) return null;
            if(Double.compare(now, expired) > 0) {
                map.remove(key);
                time.remove(key);
                return null;
            } else {
                return map.get(key);
            }
        }
        public V put(K key, V value, long duration) {
            long now = System.currentTimeMillis();
            long expired = now + duration;
            time.put(key, expired);
            return map.put(key, value);
        }
    }

}
