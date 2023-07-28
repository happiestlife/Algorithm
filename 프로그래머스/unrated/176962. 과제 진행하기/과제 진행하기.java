import java.util.*;

class Solution {
    
    private class Node{
        private String name;
        private int s;
        private int time;
        
    }
    
    public String[] solution(String[][] plans) {
        Node[] nodes = new Node[plans.length];
        for(int i = 0; i < plans.length; i++){
            String[] raw = plans[i];
            
            Node n = new Node();
            
            n.name = raw[0];
            String[] comp = raw[1].split(":");
            n.s = Integer.parseInt(comp[0]) * 60 + Integer.parseInt(comp[1]);
            n.time = Integer.parseInt(raw[2]);
            
            nodes[i] = n;
        }
        
        Arrays.sort(nodes, (n1, n2) -> {
            return n1.s - n2.s;
        });
        
        int idx = 0;
        String[] answer = new String[plans.length];
        
        int prevStartTime = 0;
        Stack<Node> s = new Stack<>();
        for(int i = 0; i < nodes.length; i++){
            int passTime = nodes[i].s - prevStartTime;
            // System.out.println(passTime);
            while(!s.isEmpty()){
                // System.out.println(passTime + ", " + s.peek());
                if(passTime < s.peek().time){
                    s.peek().time -= passTime;
                    break;
                }
                Node nd = s.pop();
                passTime -= nd.time; 
                answer[idx++] = nd.name;
            }
            
            prevStartTime = nodes[i].s;
            s.push(nodes[i]);
            // System.out.println("stack size >> " + s.size());
        }
        while(!s.isEmpty()){
            answer[idx++] = s.pop().name;
        }
        
        return answer;
    }
}