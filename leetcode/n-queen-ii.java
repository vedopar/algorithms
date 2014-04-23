public class Solution {
    /*
    * This is a typical way of cost more computing instead of space resource.
    */
    public int totalNQueens(int n) {
        if(n<=0) return 0;
        ArrayList<Integer> pos=new ArrayList<Integer>();
        return helper(n,pos);
    }
    
    private int helper(int n,ArrayList<Integer> pos){
        if(pos.size()==n) return 1;
        int sum=0;
        int i=pos.size();
        for(int j=0;j<n;j++){
            boolean is_valid=true;
            for(int i2=0;i2<i;i2++){
                int j2=pos.get(i2);
                if(j2==j || Math.abs(i-i2)==Math.abs(j-j2)) {
                    is_valid=false;break;
                }
            }
            if(is_valid){
                pos.add(j);
                sum+=helper(n,pos);
                pos.remove(i);
            }
        }
        return sum;
    }
    /*
    * This is the typical way of cost space instead of computing resource.
    */
    public int totalNQueens2(int n) {
        assert(n>=0);
        if(n==0) return 0;
        int[] res=new int[1];
        helper(res,new int[n][n],0,n);
        return res[0];
    }
    private void helper2(int[] res,int[][] matrix,int row,int n){
        if(row==n) res[0]++;
        else{
            for(int i=0;i<n;i++){
                if(matrix[row][i]>0) continue;
                for(int j=row+1;j<n;j++) matrix[j][i]++;
                for(int j=0;j<i;j++){
                    if(row+i-j<n) matrix[row+i-j][j]++;
                }
                for(int j=i+1;j<n;j++){
                    if(row+j-i<n) matrix[row+j-i][j]++;
                }
                helper(res,matrix,row+1,n);
                for(int j=row+1;j<n;j++) matrix[j][i]--;
                for(int j=0;j<i;j++){
                    if(row+i-j<n) matrix[row+i-j][j]--;
                }
                for(int j=i+1;j<n;j++){
                    if(row+j-i<n) matrix[row+j-i][j]--;
                }
            }
        }
    }

}
