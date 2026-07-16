class Solution {

    public String foreignDictionary(String[] words) {

        // Graph of 26 lowercase characters
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        // To know which characters actually exist
        boolean[] present = new boolean[26];

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {

            String s1 = words[i];
            String s2 = words[i + 1];

            // Invalid case
            if (s1.length() > s2.length() && s1.startsWith(s2))
                return "";

            int len = Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {

                if (s1.charAt(j) != s2.charAt(j)) {

                    adj.get(s1.charAt(j) - 'a')
                       .add(s2.charAt(j) - 'a');

                    break;
                }
            }
        }

        List<Integer> topo = topoSort(adj, present);

        // Cycle exists
        int totalChars = 0;
        for (boolean b : present)
            if (b)
                totalChars++;

        if (topo.size() != totalChars)
            return "";

        StringBuilder ans = new StringBuilder();

        for (int node : topo) {
            ans.append((char) (node + 'a'));
        }

        return ans.toString();
    }

    public List<Integer> topoSort(List<List<Integer>> adj, boolean[] present) {

        int[] indegree = new int[26];

        for (int i = 0; i < 26; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (present[i] && indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();

            topo.add(node);

            for (int it : adj.get(node)) {

                indegree[it]--;

                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        return topo;
    }
}