class Solution {
    public String convert(String s, int numRows) {
        if(s.length() == 1 || numRows == 1) return s;

        StringBuilder[] comps = new StringBuilder[numRows];
        for(int i = 0; i < comps.length; i++) {
            comps[i] = new StringBuilder();
        }

        int cycle = (numRows - 1) * 2;
        int y = 0;
        for(int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));

            int curStep = i % cycle;
            if(curStep < cycle / 2) {
                comps[y++].append(c);
            } else {
                comps[y--].append(c);
            }

        }


        StringBuilder result = new StringBuilder();
        for(int i = 0; i < comps.length; i++) {
            System.out.println(comps[i]);
            result = result.append(comps[i]);
        }

        return result.toString();
    }
}