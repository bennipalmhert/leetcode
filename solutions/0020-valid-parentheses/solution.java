class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put('(',')');
        pairs.put('{','}');
        pairs.put('[',']');
        for (Character c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                brackets.push(c);
            } else if (!(brackets.isEmpty()) && pairs.get(brackets.peek()) == c){
                brackets.pop();
            } else {
                return false;
            }
        }
        return brackets.isEmpty();
    }
}
