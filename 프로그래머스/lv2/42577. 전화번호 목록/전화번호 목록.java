class Solution {
    public boolean solution(String[] phone_book) {
        boolean rs = true;
        // 시작노드
        Node node = new Node((char) 0, false);
        for (int i = 0; i < phone_book.length; i++) {
            String phoneNum = phone_book[i];
            Node nodePointer = node;
            int sameWordStartIdx = -1;
            for (int j = 0; j < phoneNum.length(); j++) {
                char c = phoneNum.charAt(j);
                // 다음 문자가 기존의 문자열에 나오지 않았더라면 (새로운 문자열)
                if(nodePointer.nextNode[c - '0'] == null){
                    nodePointer.nextNode[c - '0'] = new Node(c, j == phoneNum.length()-1 ? true : false);
                    sameWordStartIdx = -1;
                }
                // 다음 문자가 기존의 문자열에 나왔었고 해당 문자가 마지막 단어일 경우 (조건 만족)
                else {
                    if(sameWordStartIdx == -1)
                        sameWordStartIdx = j;
                    // 오답노트
                    // 길이가 짧은 것이든 긴 것이든 비교할 때 상관없이 코드 작성 필요
                    // 기존의 코드에서는 짧은 코드를 먼저 넣어놓고 긴 코드를 비교하는 식으로만 작성
                    // -> || (j == phoneNum.length()-1)
                    if(sameWordStartIdx == 0 && (nodePointer.nextNode[c - '0'].isLastWord) || (j == phoneNum.length()-1)){
                        rs = false;
                        break;
                    }
                }

                nodePointer = nodePointer.nextNode[c - '0'];
            }
            if(!rs)
                break;
        }
        
        return rs;
    }
    
    static class Node{
        char c;
        Node[] nextNode;
        boolean isLastWord;

        public Node(char c, boolean isLastWord) {
            this.c = c;
            this.nextNode = new Node[10];
            this.isLastWord = isLastWord;
        }
    }
}