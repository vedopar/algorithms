public class Solution {
    /*
    * sort it first, then iterate num for the first number,
    * the second and third are got by greedy and also compare
    * the absolute value to the current @res.
    * @res is the final answer.
    */
    public int threeSumClosest(int[] num, int target) {
        assert(num!=null && num.length>=3);
        Arrays.sort(num);
        int res=num[0]+num[1]+num[2];
        for(int i=0;i<num.length-2;i++){
            int begin=i+1;
            int end=num.length-1;
            while(begin<end){
                int tmp_sum=num[i]+num[begin]+num[end];
                if(Math.abs(res-target)>Math.abs(tmp_sum-target)) res=tmp_sum;
                else if(target<tmp_sum) end--;
                else begin++;
            }
        }
        return res;
    }
}
