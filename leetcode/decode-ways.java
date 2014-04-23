public class Solution {
    /*
    * Not difficult, just thinking it's elegant.
    */
    public int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        int[] ways=new int[s.length()+1];
        ways[0]=1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                if(i==0 || s.charAt(i-1)=='0' || s.charAt(i-1)-'0'>2) return 0;
                ways[i+1]=ways[i-1];
            }
            else{
              ways[i+1]=ways[i];
              if(i>0 && s.charAt(i-1)!='0' && (s.charAt(i-1)-'0'<2 || (s.charAt(i-1)=='2' && s.charAt(i)-'0'<=6)) ) ways[i+1]+=ways[i-1];
            }
        }
        return ways[s.length()];
    }
}
