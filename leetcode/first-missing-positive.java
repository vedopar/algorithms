public class Solution {
    /*
    * The question itself is confusing. It actually meanings finding the least positive value that not appears
    * in the array.
    * To think of a elegant took a while.
    */
    public int firstMissingPositive(int[] A) {
        if(A==null || A.length==0) return 1;
        Arrays.sort(A);
        int min=1;
        for(int i=0;i<A.length;i++){
            if(A[i]<min) continue;
            if(A[i]==min) min++;
            else{
                if(A[i]-min>=1) return min;
                min=A[i]+1;
            }
    }
        return min;
    }
}
