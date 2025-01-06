class Solution {
    public int[] minOperations(String boxes) {
        Queue<Integer> q=new LinkedList<>();
        int n=boxes.length();
        int[] res=new int[n];
        int i,j;
        for(i=0;i<n;i++)
        {
            if(boxes.charAt(i)=='1')
                q.add(i);
        }
        for(i=0;i<n;i++)
        {
            int x=q.size();
            while(x-->0)
            {
                int a=q.poll();
                res[i]+=Math.abs(i-a);
                q.add(a);
            }
        }
        return res;
    }
}