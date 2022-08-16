import java.util.*;
// TC O(n) Sc O(n);
public class Main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     String s = sc.next();
    int count[] = new int [256];
    
    // counting the frequency of character.
    for(int i=0; i<s.length(); i++){
      count[s.charAt(i)]++;
      // System.out.print(Arrays.toString(count));
    }
    int index = -1;
    
    // if frequency remaining same 1. then it will index=i; 
    for(int i=0; i<s.length(); i++){
      if(count[s.charAt(i)]==1){
        index  = i;
        break;
      }
    }
    System.out.print(index);
  }
}
/*
Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
*/

// leet code.

class Solution {
    public int firstUniqChar(String s) {
      int count[] = new int[256];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)]++;
        }
        int index =-1;
        for(int i=0; i<s.length(); i++){
            if(count[s.charAt(i)]==1){
                index = i;
                break;
            }
        }
        return index;
    }
}


// faster .

class Solution {
    public int firstUniqChar(String s) {
        int count[] = new int[26];
        int n  = s.length();
       
        for(int i =0; i<n;i++){
           count[s.charAt(i)-'a']++; // duplicate frequency count. 
        }
        for(int i =0; i<n; i++){
            if(count[s.charAt(i)-'a']==1){  // if first elements frequency is 1 then return it.
                return i;
            }
        }
        return -1; // if no unique elements then return -1;
    }
}

//

class Solution {
     public int firstUniqChar(String s) {
        // Stores lowest index / first index
        int ans = Integer.MAX_VALUE;
        // Iterate from a to z which is 26 which makes it constant
        for(char c='a'; c<='z';c++){
            // indexOf will return first index of alphabet and lastIndexOf will return last index
            // if both are equal then it has occured only once.
            // through this we will get all index's which are occured once
            // but our answer is lowest index
            int index = s.indexOf(c);
            if(index!=-1&&index==s.lastIndexOf(c)){
                ans = Math.min(ans,index);
            }
        }

        // If ans remain's Integer.MAX_VALUE then their is no unique character
        return ans==Integer.MAX_VALUE?-1:ans;
    }   
}



// hashmap

import java.util.*;
/*
Input: s = "leetcode"
Output: 0
*/
public class Main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     String s = sc.nextLine();
     int n = s.length();
     Map<Character,Integer> map = new HashMap<>();
     for(int i =0; i<n; i++){
       char c = s.charAt(i);
       
       map.put(c,map.getOrDefault(c,0)+1);
     }
     
     for(int i=0; i<n; i++){
       char c = s.charAt(i);
       if(map.get(c)==1){
         System.out.print(i);
         return;
       }
     }
     System.out.print(-1);
  }
}


// leetcode


class Solution {
    public int firstUniqChar(String s) {
      Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);  // frequncy.
        }
        for(int i =0; i<n; i++){
            char c = s.charAt(i);
            if(map.get(c)==1){
                return i;  // if unique elements return index.
            }
        }
        return -1;  // else return -1;
    }
}



import java.util.*;

public class Main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     String s = sc.nextLine();
     int n = s.length();
    HashMap<Character,Integer> map = new HashMap<>();
    for(int i=0; i<n; i++){
      char c  = s.charAt(i);
      if(!map.containsKey(c)){
        map.put(c,1);
      }else{
        map.put(c,map.get(c)+1);
      }
    }
   int index  = -1;
    for(int i=0; i<n; i++){
      char c = s.charAt(i);
      if(map.get(c)==1){
        index = i;
       break;
      }
    }
    
    System.out.print(index);
  }
}

/*
At first I was confused as to how I get the correct answer when we cannot trust the map to maintain the insertion order.

I thought I would have to use a LinkedHashMap?

Then I remembered I am iterating the string from first char to last char as I check against the map for character occurrence count.
*/


