public class Solution {
    /*
    * Basically it's DP,however F(i) is only about F(i-1)
    * The main concern is new instances per iteration seems costy.
    */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length==0) return res;
        res.add(new ArrayList<Integer>(Arrays.asList(num[0])));
        for(int i=1;i<num.length;i++){
            ArrayList<ArrayList<Integer>> tmp_res=new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> arr:res){
                for(int j=0;j<=arr.size();j++){
                    ArrayList<Integer> tmp_arr=new ArrayList<Integer>(arr);
                    tmp_arr.add(j,num[i]);
                    tmp_res.add(tmp_arr);
                }
            }
            res=tmp_res;
        }
        return res;
    }

    /*
    * Old way, use recursion and use HashSet to avoid duplicates(necessary?)
    */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num==null) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        HashSet<String> result_set= subProcess(0,num);
        for(String s:result_set){
            ArrayList<Integer> arr=new ArrayList<Integer>();
            String[] tmp=s.split(",");
            for(int i=0;i<tmp.length;i++) {
            	if(tmp[i].length()==0) continue;
            	arr.add(Integer.parseInt(tmp[i]));
            }
            result.add(arr);
        }
        return result;
    }
    private HashSet<String> subProcess(int begin,int[] num){
        HashSet<String> result=new HashSet<String>();
        if(begin==num.length-1){
               result.add(num[begin]+",");
               return result;
        }
        HashSet<String> result2=subProcess(begin+1,num);
        for(String s:result2){
        	result.add(num[begin]+","+s);
            for(int i=s.indexOf(',');i!=-1;i=s.indexOf(',',i+1)){
            	String tmp=s.substring(0,i+1)+num[begin]+","+s.substring(i+1);
                result.add(tmp);
            }
        }
        return result;
    }
}
