import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ptr1 = 0;
        int ptr2 = 0;
        Vector<Integer> v = new Vector<>();
        int size = nums1.length + nums2.length;
        int count = 0;
        while(ptr1 < nums1.length && ptr2 < nums2.length && count<=(size/2)){
            if(nums1[ptr1] <= nums2[ptr2]){
                v.add(nums1[ptr1]);
                ptr1++;
                count++;
            }
            else{
                v.add(nums2[ptr2]);
                ptr2++;
                count++;
            }
        }
        if(count<=(size/2)){
            if(ptr1 == nums1.length){
                while(count <=(size/2) && ptr2 < nums2.length){
                    v.add(nums2[ptr2]);
                    ptr2++;
                    count++;
                }
            }
            else if(ptr2 == nums2.length){
                while(count <=(size/2) && ptr1 < nums1.length){
                    v.add(nums1[ptr1]);
                    ptr1++;
                    count++;
                }
            }
            
        }
        
        int len = v.size();
        // System.out.println(v);
        if(size%2==0){
            // System.out.println((int)v.get(len-2)+" "+(int)v.get(len-1));
            return (double)((int)v.get(len-2)+(int)v.get(len-1))/2;
        }
        else{
            // System.out.println((int)v.get(len-1));
            return (double)((int)v.get(len-1));
        }
    }
}