package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BSTNodeTest {
    public static Map<Integer, String> linkedHashMap;
    public static BSTNode bstNode;
    public static BSTNode node;

    @BeforeAll
    static void insertLinkedHashMap() {
        List<Integer> keys = new ArrayList<>();
        linkedHashMap = new LinkedHashMap<>();
        for (int i = 2; i <= 22; i++) {
            keys.add(i);
        }
        Collections.shuffle(keys);
        for (int key : keys) {
            linkedHashMap.put(key, String.valueOf(key));
            //System.out.println(key);
        }
    }

    @BeforeEach
    void testInsert() {
        bstNode = new BSTNode(2, linkedHashMap.get(2));
        for (int key : linkedHashMap.keySet()) {
            String value = linkedHashMap.get(key);
            bstNode.insert(bstNode, key, value);
        }
        assertEquals(linkedHashMap.size(), bstNode.countNodes(bstNode));
    }

    @Order(1)
    @Test
    void testDelete() {
        bstNode = bstNode.delete(bstNode, 3);
        assertEquals(linkedHashMap.size() -1, bstNode.countNodes(bstNode));
        node = bstNode.search(bstNode, 3);
        assertNull(node);
    }

    @Order(2)
    @Test
    void testInsertAnotherValue() {
        bstNode.insert(bstNode, 3, "3");
        node = bstNode.search(bstNode, 3);
        assertEquals("3", node.getValue());
        assertEquals(linkedHashMap.size(), bstNode.countNodes(bstNode));

        bstNode.insert(bstNode, 3, "3+");
        assertEquals(linkedHashMap.size(), bstNode.countNodes(bstNode));


        node = bstNode.search(bstNode, 3);
        assertEquals("3+", node.getValue());
    }

    @Order(3)
    @Test
    void testSearch() {
        for (int key : new int[]{12, 7, 19, 9}) {
            node = bstNode.search(bstNode, key);
            assertEquals("" + key, node.getValue());
        }
        node = bstNode.search(bstNode, 0);
        assertNull(node);
    }
}