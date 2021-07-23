/*Running Time Complexity: O(n)
Space Complexity: O(n)
Successfully Run and Compiled on leetcode
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        result = 0;
        return dfs(root, low,high);
    }
    private int dfs(TreeNode root, int low, int high){
        //base
        if(root == null) return 0;
        
        //logic
        //preorderif(root.val>=low && root.val<=high){
        //     result += root.val;
        // }
        result = 0;
        if(root.val>=low && root.val<=high){
            result += root.val;
        }
        //System.out.println("up: " + root.val);
        if(root.val > low)
            result += dfs(root.left,low,high);
        //inorder
        
        if(root.val<high)
            result += dfs(root.right,low,high);
        //System.out.println("down: " + root.val);
        //postorder
        // if(root.val>=low && root.val<=high){
        //     result += root.val;
        // }
        return result;
    }
    
}
/*
//Using Queue
Space Complexity: O(n)
Successfully Run and Compiled on leetcode
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int result = 0;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null) q.add(curr.left);
            if(curr.val>=low && curr.val<=high) result += curr.val;
            if(curr.right != null) q.add(curr.right);
            
        }
        
        return result;
    }
    
}
//Using stack 
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        Stack<TreeNode> st = new Stack<>();
        // st.push(root);
        int result = 0;
        while(!st.isEmpty() || root!=null){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(root.val>=low && root.val<=high){
                result += root.val;
            }
            root = root.right;
        }
        
        return result;
    }
    
}
*/