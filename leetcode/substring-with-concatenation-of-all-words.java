public class Solution {
    /*
    * This way cleverly use a hashmap to solve duplicates and string concatenation problems,
    * however, every iteration a new @dict instance is cloned, which is costy. 
    */
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        assert(L!=null && L.length>0);
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(S==null || S.length()==0) return res;
        HashMap<String,Integer> dict=new HashMap<String,Integer>();
        int len=L[0].length();
        int ful_len=len*L.length;
        
        for(String s:L){
            if(dict.containsKey(s)) dict.put(s,dict.get(s)+1);
            else dict.put(s,1);
        }
        
        for(int i=0;i<=S.length()-ful_len;i++){
            int i2=i;
            HashMap<String,Integer> dict2=(HashMap<String,Integer>)dict.clone();
            while(i2<=S.length()){
                if(i2-i==ful_len){
                    res.add(i);
                    break;
                }
                String s=S.substring(i2,i2+len);
                if(!dict2.containsKey(s) || dict2.get(s)==0) break;
                else dict2.put(s,dict2.get(s)-1);
                i2+=len;
            }
        }
        return res;
    }
}