class Solution {
    
         public int[] findnse(int[] heights) {
        int n = heights.length;
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty()? n : st.peek();
            st.push(i);
        }
        return  nse;
    }

   public int[] findpsee(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] > heights[i]) {
                s.pop();
            }
            pse[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        return pse;
    }
    
    public int largestRectangleArea(int[] heights) {
       int [] nse = findnse(heights);
        int [] psee = findpsee(heights);
        int n=heights.length;
        int maxi=0;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,heights[i]*(nse[i] - psee[i]-1));
        }
        return maxi;
    }
}