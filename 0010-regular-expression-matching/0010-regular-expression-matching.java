class Solution {
// here u see that strings are not changing right so there is not need to use them in defining the dp state right, here since the indices r changing so we are keeping those as dp state right. 
Boolean[][] dp;

public boolean find(String s, String p ,int str, int ptr){
    // remember that we need to check weather the patter matches the string or not right 
    // the base will be like this if the patter comes to an end then check weather the str reached end or not 

    if(ptr == p.length()){
        return str == s.length(); // if both reached reached end then we can say that patter matches the string right;
    }

    // not first and for most thing is the check weather the current char is matches the string or not;

// remember to add correct brackets  ->  ( str.leng  &&  ( a || b ) ). 

// if( dp is used )

    if(dp[str][ptr] != null ) return dp[str][ptr];

    boolean current = (str < s.length() && (p.charAt(ptr) == s.charAt(str) || p.charAt(ptr) == '.'));

    // look i dont know weather the current char is matches or not right. 
     // the char will match 100 if char is ". " but dont know right now;


     // so my other is that if the next char is *  then i can skip the current char matching or match the preceding char right 

    if( ptr + 1 < p.length() && p.charAt(ptr + 1) == '*'){
        
        // if the next char is * then i have 2 option right
        // 1 - to skip the prev char from the pattern right 
        // 2 - match preceding char  only if the current char is matches right
        // if the current char is matched then the there is point to checking the next char 

// here remember that to increse the ptr by +2 right because the next is * right 

        return dp[str][ptr] = find(s,p,str,ptr+2) || (current && find(s,p,str+1,ptr));
    }else{
        

    // and if the next is not * then we have to return ans 
    // if the current is matched then only check for the next using recursion rigt 

    return  dp[str][ptr] = current && find(s,p,str+1,ptr+1);
    }




}

    public boolean isMatch(String s, String p) {
        // what is the recursive sol for this
        
        // we get to know that there are 3 case right if . - then it match the current char right.

        // and if the current char matches and the next char is * then the prev char can be used to match 0 or more than then one occurence of the same character right;
        dp = new Boolean[s.length()+1][p.length()+1];
        return find(s,p,0,0);  //lets have a faith in recursion that is this is going to return weather starting from 0 0 can the patter be matched with the string right. 

        
    }
}