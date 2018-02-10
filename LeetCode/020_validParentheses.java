class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<Character>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' :
                    deque.push((Character)c);
                    break;
                case '{' :
                    deque.push((Character)c);
                    break;
                case '[' :
                    deque.push((Character)c);
                    break;
                case ')' :
                    if (deque.isEmpty() || deque.pop() != '(')
                        return false;
                    break;
                case '}' :
                    if (deque.isEmpty() || deque.pop() != '{')
                        return false;
                    break;
                case ']' :
                    if (deque.isEmpty() || deque.pop() != '[')
                        return false;
                    break;

            }
        }
        return deque.isEmpty();
    }
}
