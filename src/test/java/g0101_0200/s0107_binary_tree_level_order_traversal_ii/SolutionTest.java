package g0101_0200.s0107_binary_tree_level_order_traversal_ii;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com_github_leetcode.ArrayUtils;
import com_github_leetcode.TreeNode;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void levelOrderBottom() {
        TreeNode bottomLeft = new TreeNode(15);
        TreeNode bottomRight = new TreeNode(7);
        TreeNode upRight = new TreeNode(20, bottomLeft, bottomRight);
        TreeNode upLeft = new TreeNode(9);
        TreeNode root = new TreeNode(3, upLeft, upRight);
        assertThat(
                new Solution().levelOrderBottom(root),
                equalTo(ArrayUtils.getLists(new int[][] {{15, 7}, {9, 20}, {3}})));
    }
}
