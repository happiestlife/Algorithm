import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        while(path.indexOf("//") != -1) path = path.replaceAll("//", "/");

        Stack<String> stack = new Stack<>();
        StringTokenizer stk = new StringTokenizer(path, "/");
        while(stk.hasMoreTokens()) {
            String curToken = stk.nextToken();
            if(curToken.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            } else if(curToken.equals(".")) {
                continue;
            }
            else {
                stack.add(curToken);
            }
        }

        StringBuilder sb = new StringBuilder("/");

        int idx = 0;
        List<String> list = new ArrayList<>(stack);
        for(String s : list) {
            sb.append(s);
            if(idx < list.size() -1) sb.append("/");
            idx++;
        }

        return sb.toString();
    }
}