package org.example;

public class BSTNode {
    private int key;
    private String value;
    private BSTNode left;
    private BSTNode right;

    public String getValue() {
        return value;
    }

    public BSTNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void insert(BSTNode node, int key, String value) {
        if (key < node.key) {
            if (node.left == null) {
                node.left = new BSTNode(key, value);
            } else {
                insert(node.left, key, value);
            }
        } else if (key > node.key) {
            if (node.right == null) {
                node.right = new BSTNode(key, value);
            } else {
                insert(node.right, key, value);
            }
        } else {
            node.value = value;
        }
    }

    public BSTNode search(BSTNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.key == key) {
            return node;
        }
        return (key < node.key) ? search(node.left, key) : search(node.right, key);
    }

    public BSTNode delete(BSTNode node, int key) {
        if (node == null) {
            return null;
        } else if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                BSTNode maxInLeft = getMax(node.left);
                node.key = maxInLeft.key;
                node.value = maxInLeft.value;
                node.right = maxInLeft.right;
            }
        }
        return node;
    }

    private BSTNode getMax(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    int countNodes(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    void printTree(BSTNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        printTree(node.right);
        System.out.print(node.value + " ");
    }
}
