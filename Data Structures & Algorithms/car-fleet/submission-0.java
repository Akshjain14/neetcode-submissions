class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double>st=new Stack<>();
        int n=position.length;
        double[][] cars=new double[n][2];          
        for(int i=0;i<position.length;i++){
                cars[i][0]=position[i];
                cars[i][1]=(double)(target-position[i])/speed[i];
        }
        Arrays.sort(cars, (a,b)->Double.compare(b[0],a[0]));
        for(int i=0;i<n;i++){
            double time=cars[i][1];
            if(st.isEmpty()){
                st.push(time);
            }
            else if(time>st.peek())
            st.push(time);

        }
        return st.size();
    }
}
