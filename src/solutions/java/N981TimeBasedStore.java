package solutions.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class N981TimeBasedStore {

    static class TimeMap {

        private final Map<String, TreeMap<Integer, String>> store = new HashMap<>();

        public void set(String key, String value, int timestamp) {
            Map<Integer, String> inner = store.computeIfAbsent(key, i -> new TreeMap<>());
            inner.put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            return Optional.ofNullable(store.get(key))//
                    .flatMap(m -> Optional.ofNullable(m.floorEntry(timestamp)))//
                    .map(Map.Entry::getValue)//
                    .orElse("");
        }
    }
}
