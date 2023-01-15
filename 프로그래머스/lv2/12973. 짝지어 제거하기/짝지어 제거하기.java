import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            s1.push(s.charAt(i));
        }

        while (!s1.isEmpty()) {
            if (!s2.isEmpty() && s1.peek() == s2.peek()) {
                s1.pop();
                s2.pop();
            } else {
                s2.push(s1.pop());
            }
        }

        int rs = 0;
        if(s2.isEmpty())
            rs = 1;
        
        return rs;
    }
}