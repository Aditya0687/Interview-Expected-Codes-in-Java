package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            input[i] = sc.nextInt();
        }
        mergeSort(input);
        for(int i = 0 ; i<n ; i++){
            System.out.println(input[i]);
        }
    }
    private static void mergeSort(int[] input) {
        int len =  input.length;
        if(len == 1){
            return;
        }
        int m = (len-1)/2;
        int n1 = m+1;
        int n2 = len-m-1;
        int s1[] = new int[n1];
        int s2[] = new int[n2];
        for(int i = 0;i<n1;i++){
            s1[i] = input[i];
        }
        for(int i = m+1;i<len;i++){
            s2[i-m-1] = input[i];
        }
        mergeSort(s1);
        mergeSort(s2);
        merge(s1,s2,input);
    }

    private static void merge(int[] s1, int[] s2, int[] input) {
        int i =0;
        int j =0;
        int k = 0;
        while(i!=s1.length && j!=s2.length){
            if(s1[i]>s2[j]){
                input[k++] = s2[j++];
            }else{
                input[k++] = s1[i++];
            }
        }
        for(;i<s1.length;i++){
            input[k++] = s1[i];
        }
        for(;j<s2.length;j++){
            input[k++]=s2[j];
        }
    }
}
