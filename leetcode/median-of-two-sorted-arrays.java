public class Solution {
    /*
    * It passes the leetcode , but I seriously doubt it's really correct.
    */
    public double findMedianSortedArrays(int A[], int B[]) {
        assert(B!=null || A!=null);
        if(A==null) A=new int[0];
        if(B==null) B=new int[0];
        int len=A.length+B.length;
        if(len%2==1) return findKth(A,0,A.length-1,B,0,B.length-1,(A.length+B.length)/2+1)+0.0;
        else{
            int fir=findKth(A,0,A.length-1,B,0,B.length-1,(A.length+B.length)/2);
            int sec=findKth(A,0,A.length-1,B,0,B.length-1,(A.length+B.length)/2+1);
            return fir*0.5+sec*0.5;
        }
        
    }
    private int findKth(int A[],int ab,int ae,int B[],int bb,int be,int k){
        if(ab>ae) return B[bb+k-1];
        if(bb>be) return A[ab+k-1];
        if(k<=1) return Math.min(A[ab],B[bb]);
        int a_len=ae-ab+1;
        int b_len=be-bb+1;
        int am=A[ab+a_len/2];
        int bm=B[bb+b_len/2];
        
        if(k<=a_len/2+b_len/2+1){
            if(am>bm) return findKth(A,ab,ab+a_len/2-1,B,bb,be,k);
            else return findKth(A,ab,ae,B,bb,bb+b_len/2-1,k);
        }
        else{
            if(am>bm) return findKth(A,ab,ae,B,bb+b_len/2+1,be,k-b_len/2-1);
            else return findKth(A,ab+a_len/2+1,ae,B,bb,be,k-a_len/2-1);
        }
    }
}