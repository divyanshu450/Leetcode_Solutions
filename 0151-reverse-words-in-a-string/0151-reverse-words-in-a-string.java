class Solution {
    public String reverseWords(String s) {
        String trimmed = s.trim();
        String[] arr = trimmed.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i > -1; i--){
            String word = arr[i];
            if(sb.length() < 1){
                sb.append(word);
            }
            else{
                sb.append(" ");
                sb.append(word);
            }
            System.out.println("sb: "+ sb);
            
        }
        return sb.toString();
    }
}