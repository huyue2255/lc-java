package LaiOffer;

import java.util.*;

/**
 * Created by yuehu on 6/28/20.
 * Q: For a composition with different of word,
 * try to find the top k frequent words from the composition
 */
public class TopKFrequent {
    // Assumptions: combon is not empty, k >= 1
    public String[] topKFrequent(String[] combo, int k) {
        // handle the special case of empty combo at the beginning.
        if (combo.length == 0) {
            return new String[0];
        }
        // get all the distinct strings as key and their frequencies as values
        // NOTICE: the freMap has at least size 1
        Map<String, Integer> freqMap = getFreMap(combo);
        // minHeap on the frequencies of the strings.
        // NOTICE: using Map.Entry as element type directly so that all the operations are mostly efficient.

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry: freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        // since the returned array requires the strings sorted by their
        // frequencies, use a seperate helper method to do this operation.
        return freqArray(minHeap);
    }

    private Map<String, Integer> getFreMap(String[] combo) {
        Map<String, Integer> freqMap = new HashMap<>();
        // NOTICE: when possible, choose the most efficient way for
        // HashMap operations
        for (String s: combo) {
            Integer freq = freqMap.get(s);
            if (freq == null) {
                freqMap.put(s, 1);
            } else {
                freqMap.put(s, freq + 1);
            }
        }
        return freqMap;
    }

    private String[] freqArray(PriorityQueue<Map.Entry<String,Integer>> minHeap) {
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        String[] combo = {"hello", "hello", "hello", "hello", "hello", "grace", "grace", "grace", "grace", "world"};
        TopKFrequent t = new TopKFrequent();
        String[] result = t.topKFrequent(combo, 1);
        System.out.println(Arrays.toString(result));
    }

}
