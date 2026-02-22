class Solution {
    public boolean isDigitorialPermutation(int n) {
        int n2 = n;
        int dig = 0;
        int currSum = 0;
        while(n > 0){
            dig = n % 10;
            currSum += fact(dig);
            n = n/10;
        }
        String s = String.valueOf(n2);
        Set<String> set = new HashSet<>();
        set.add(s);
       // permute(s.toCharArray(), 0, set);--TLE
       // return set.contains(String.valueOf(currSum));--TLE
        return isPermutation(currSum, n2);
    }

    int fact(int n){
        if (n == 0 || n == 1) { // Base case
            return 1;
        } else {
            return n * fact(n - 1); // Recursive call
        }
    }

    //to not get TLE
    private boolean isPermutation(int n1, int n2) {
        String s1 = String.valueOf(n1);
        String s2 = String.valueOf(n2);
        
        // If lengths differ, they can't be permutations
        if (s1.length() != s2.length()) return false;
        
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        
        // Sort both character arrays
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        // If sorted arrays are identical, the numbers are permutations
        return Arrays.equals(chars1, chars2);
    }

    // -----TLE
    // void permute(char[] arr, int l, Set<String> set){
    //     if(l == arr.length - 1){
    //         set.add(String.valueOf(arr));
    //         return;
    //     }
    //     else{
    //         for(int i = l; i < arr.length; i++){
    //             swap(arr, l, i);
    //             permute(arr, l + 1, set);
    //             swap(arr, l, i);
    //         }
    //     }
    // }

    void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}