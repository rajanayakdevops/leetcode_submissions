class Solution {

    Stack<Integer> st;

    public void fun(ListNode node, List<Integer> ans) {
        if(node == null) return;

        fun(node.next, ans);

        while(!st.isEmpty() && node.val >= st.peek()) {
            st.pop();
        }

        if(st.isEmpty()) ans.add(0);
        else ans.add(st.peek());

        st.push(node.val);
    }

    public int[] nextLargerNodes(ListNode head) {

        List<Integer> ans = new ArrayList<>();
        st = new Stack<>();

        fun(head, ans);

        Collections.reverse(ans);

        int[] arr = new int[ans.size()];

        for(int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }
}