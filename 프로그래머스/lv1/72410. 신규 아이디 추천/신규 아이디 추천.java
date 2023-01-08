class Solution {
    public String solution(String new_id) {
       new_id = new_id.toLowerCase();

        new_id = new_id.replaceAll("[^0-9a-z-_.]", "");

        new_id = new_id.replaceAll("[.]{2,}", ".");

        new_id = new_id.replaceAll("^[.]", "");

        new_id = new_id.replaceAll("[.]$", "");

        if (new_id.length() == 0) {
            new_id = new_id.replaceAll("^$", "a");
        } else if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15).replaceAll("[.]$", "");
        }

        if (new_id.length() < 3) {
            StringBuilder sb = new StringBuilder(new_id);
            char c = new_id.charAt(new_id.length() - 1);
            while (sb.length() < 3) {
                sb.append(c);
            }

            new_id = sb.toString();
        }

        return new_id;
    }
}