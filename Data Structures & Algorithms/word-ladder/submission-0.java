class Solution {
    class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> ss = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            ss.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        // mark beginWord visited if it exists in set
        ss.remove(beginWord);
        while (!q.isEmpty()) {
            Pair current = q.poll();
            String word = current.word;
            int steps = current.steps;

            if (word.equals(endWord)) {
                return steps;
            }
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char originalchar = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String newword = new String(chars);
                    if (ss.contains(newword)) {
                        ss.remove(newword);
                        q.offer(new Pair(newword, steps + 1));
                    }
                }
                chars[i] = originalchar;
            }

        }
        return 0;
    }
}
