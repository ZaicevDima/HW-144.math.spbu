package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

public class AVLNodeTest {

    @Test
    public void compareTo() {
        AVLTreeNode<Integer> newNode1 = new AVLTreeNode<>(1, null);
        AVLTreeNode<Integer> newNode2 = new AVLTreeNode<>(2, null);
        Assert.assertTrue(newNode1.compareTo(newNode2) < 0);
    }
}