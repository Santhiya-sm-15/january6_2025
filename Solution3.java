class Trie
{
    Trie[] t;
    boolean end;
    public Trie()
    {
        t=new Trie[26];
        end=false;
        for(int i=0;i<26;i++)
            t[i]=null;
    }
    public void insert(Trie root,String s)
    {
        for(int i=0;i<s.length();i++)
        {
            int ind=s.charAt(i)-'a';
            if(root.t[ind]==null)
                root.t[ind]=new Trie();
            root=root.t[ind];
        }
        root.end=true;
    }
    public int count(Trie root,int len,String s)
    {
        int ind=0,i;
        for(i=0;i<len;i++)
        {
            int cnt=0;
            for(int j=0;j<26;j++)
            {
                if(root.t[j]!=null)
                    cnt++;
                if(cnt>1)   
                    return ind;
            }
            if(cnt>1)   
                return ind;
            ind++;
            root=root.t[s.charAt(i)-'a'];
        }
        return ind;
    }
}
class Solution {
    public String longestCommonPrefix(String arr[]) {
        Trie root=new Trie();
        Trie t=new Trie();
        int len=Integer.MAX_VALUE;
        for(String x:arr){
            t.insert(root,x);
            len=Math.min(len,x.length());
        }
        int ind=t.count(root,len,arr[0]);
        return ind==0?"":arr[0].substring(0,ind);
    }
}