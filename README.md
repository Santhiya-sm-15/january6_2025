# january6_2025
The problems that I solved today

Problem Solutions: LeetCode and GeeksforGeeks

This repository contains solutions to various coding problems from LeetCode and GeeksforGeeks. Below are the details of the problems solved recently.

1. Minimum Number of Operations to Move All Balls to Each Box
Platform: LeetCode (Daily Challenge)  
Problem Description:
You are given a binary string `boxes` representing `n` boxes. Each box either contains a ball ('1') or is empty ('0'). For each box, calculate the minimum number of moves required to bring all balls to that box.

Solution:
class Solution {
    public int[] minOperations(String boxes) {
        Queue<Integer> q = new LinkedList<>();
        int n = boxes.length();
        int[] res = new int[n];
        int i, j;
        for (i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') 
                q.add(i);
        }
        for (i = 0; i < n; i++) {
            int x = q.size();
            while (x-- > 0) {
                int a = q.poll();
                res[i] += Math.abs(i - a);
                q.add(a);
            }
        }
        return res;
    }
}

2. Rod Cutting
Platform: GeeksforGeeks  
Problem Description:
Given a rod of length `n` and an array of prices, determine the maximum value obtainable by cutting up the rod and selling the pieces.

Solution:
class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return count(0, price, n, dp);
    }
    public int count(int ind, int[] price, int len, int[] dp) {
        if (ind == price.length) 
            return Integer.MIN_VALUE;
        if (len <= 0) 
            return 0;
        if (dp[len] != -1) 
            return dp[len];       
        int t = Integer.MIN_VALUE;
        if (len - (ind + 1) >= 0) 
            t = price[ind] + count(ind, price, len - (ind + 1), dp);
        int nt = count(ind + 1, price, len, dp);
        return dp[len] = Math.max(t, nt);
    }
}

3. Longest Common Prefix
Platform: GeeksforGeeks  
Problem Description:
Given an array of strings, return the longest common prefix among all strings. If no common prefix exists, return an empty string.

Solution:
class Trie {
    Trie[] t;
    boolean end;
    public Trie() {
        t = new Trie[26];
        end = false;
        for (int i = 0; i < 26; i++) 
            t[i] = null;
    }
    public void insert(Trie root, String s) {
        for (int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            if (root.t[ind] == null) 
                root.t[ind] = new Trie();
            root = root.t[ind];
        }
        root.end = true;
    }
    public int count(Trie root, int len, String s) {
        int ind = 0;
        for (int i = 0; i < len; i++) {
            int cnt = 0;
            for (int j = 0; j < 26; j++) {
                if (root.t[j] != null) 
                    cnt++;
                if (cnt > 1) 
                    return ind;
            }
            if (cnt > 1) 
                return ind;
            ind++;
            root = root.t[s.charAt(i) - 'a'];
        }
        return ind;
    }
}
class Solution {
    public String longestCommonPrefix(String arr[]) {
        Trie root = new Trie();
        Trie t = new Trie();
        int len = Integer.MAX_VALUE;

        for (String x : arr) {
            t.insert(root, x);
            len = Math.min(len, x.length());
        }

        int ind = t.count(root, len, arr[0]);
        return ind == 0 ? "" : arr[0].substring(0, ind);
    }
}
