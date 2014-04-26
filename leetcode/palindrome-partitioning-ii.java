public class Solution {

    /*
    * This solution is a 2-dimension DP + 1-dimension DP.

    * Hope to find a even better solution in the future.

    */

    public int minCut(String s) {

        if(s==null || s.length()<=1) return 0;

        boolean[][] map=new boolean[s.length()][s.length()];

        int[] cuts=new int[s.length()+1];

        cuts[0]=-1;

        for(int i=0;i<s.length();i++){

            cuts[i+1]=cuts[i];

            map[i][i]=true;

            for(int j=i-1;j>=0;j--){

                map[j][i]=((i-j<=2 || map[j+1][i-1])&&s.charAt(i)==s.charAt(j));

                if(map[j][i]) cuts[i+1]=Math.min(cuts[i+1],cuts[j]);

            }

            cuts[i+1]++;

        }

        return cuts[s.length()];

    }

}