package g0201_0300.s0212_word_search_ii;

@SuppressWarnings("java:S1104")
public class Tree {
    private Tree[] children;
    public String end;
    private int length = 0;

    private Tree addChild(char c) {
        int i = c - 'a';
        if (children == null) {
            children = new Tree[26];
        }
        if (children[i] == null) {
            children[i] = new Tree();
            ++length;
        }
        return children[i];
    }

    public Tree getChild(char c) {
        return (children == null) ? null : children[c - 'a'];
    }

    public int len() {
        return length;
    }

    public static void addWord(Tree root, String word) {
        Tree t = root;
        for (char c : word.toCharArray()) {
            t = t.addChild(c);
        }
        t.end = word;
    }

    public static void deleteWord(Tree root, String word) {
        Tree toDelOn = root;
        char toDel = word.charAt(0);
        for (char c : word.toCharArray()) {
            if (root.length > 1) {
                toDelOn = root;
                toDel = c;
            }
            root = root.getChild(c);
            if (root == null) {
                throw new IllegalArgumentException();
            }
        }
        toDelOn.children[toDel - 'a'] = null;
        --toDelOn.length;
        if (root.length != 0) {
            throw new IllegalArgumentException();
        }
    }
}
