class Solution {
    public int cutRod(int[] price) {
        int n=price.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return count(0,price,n,dp);
    }
    public int count(int ind,int[] price,int len,int[] dp)
    {
        if(ind==price.length)
            return Integer.MIN_VALUE;
        if(len<=0)
            return 0;
        if(dp[len]!=-1)
            return dp[len];
        int t=Integer.MIN_VALUE;
        if(len-(ind+1)>=0)
            t=price[ind]+count(ind,price,len-(ind+1),dp);
        int nt=count(ind+1,price,len,dp);
        return dp[len]=Math.max(t,nt);
    }
}