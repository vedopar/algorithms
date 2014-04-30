public class Solution {
    /*
    * This is an in-place version. Using the first row and first column to record.
    */
    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) return;
        boolean is_row=false;
        boolean is_column=false;
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                is_column=true;break;
            }
        }
        for(int i=0;i<m;i++){
            if(matrix[0][i]==0){
                is_row=true;break;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=1;i<n;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<m;j++) matrix[i][j]=0;
            }
        }
        for(int j=1;j<m;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<n;i++) matrix[i][j]=0;
            }
        }
        if(is_row){
            for(int j=0;j<m;j++) matrix[0][j]=0;
        }
        if(is_column){
            for(int i=0;i<n;i++) matrix[i][0]=0;
        }
    }
}
