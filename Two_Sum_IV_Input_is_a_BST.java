import java.util.*;
class Solution {
    public void inorder(TreeNode root, List<Integer> lst) {
        if (root == null) {
            return;
        }
        inorder(root.left,lst);
        lst.add(root.val);
        inorder(root.right,lst);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<Integer>();
        
        inorder(root,lst);
        if (lst.size() == 1) {
            return false;
        }
        for (int i : lst) {
            if (k-i == i) {
                continue;
            }
             if (Collections.binarySearch(lst, k-i) >= 0) {
                 return true;
             }
        }
        return false;
        
    }
}
