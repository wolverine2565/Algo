package homework4;
/*
 * Необходимо превратить собранное на семинаре дерево поиска 
 * в полноценное левостороннее красно-черное дерево. 
 * И реализовать в нем метод добавления новых элементов с балансировкой.
 * 
 * Красно-черное дерево имеет следующие критерии:
    • Каждая нода имеет цвет (красный или черный)
    • Корень дерева всегда черный
    • Новая нода всегда красная
    • Красные ноды могут быть только левым ребенком
    • У краной ноды все дети черного цвета
 */

public class BinTree {

    Node root;

    private class Node {
        int value;
        Node left;
        Node right;
        Color color;

        Node() {
            this.color = Color.red;
        }

        Node(int _value) {
            this.value = _value;
            this.color = Color.red;
        }
    }

    enum Color {
        red, black
    }

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            root.color = Color.black;
            return true;
        } else {
            addNode(root, value);
            rebalance(root);
            return true;
        }
    }

    private Node addNode(Node node, int value) {
        if (node.value == value)
            return null;
        if (node.value > value) {
            if (node.left == null) {
                node.left = new Node(value);
                return node.left;
            } else
                return addNode(node.left, value);
        } else {
            if (node.right == null) {
                node.right = new Node(value);
                return node.right;
            } else
                return addNode(node.right, value);
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean flagBalance;
        do {
            flagBalance = false;
            if (result.right != null && result.right.color == Color.red &&
                    (result.left == null && result.left.color == Color.black)) {
                flagBalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.red &&
                    result.left.left != null && result.left.left.color == Color.red) {
                flagBalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.red &&
                    result.right != null && result.right.color == Color.red) {
                flagBalance = true;
                colorSwap(result);
            }
        } while (flagBalance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.right;
        Node temp = rightChild.left;
        rightChild.right = node;
        node.right = temp;
        rightChild.color = node.color;
        node.color = Color.red;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.left;
        Node temp = leftChild.right;
        leftChild.right = node;
        node.left = temp;
        leftChild.color = node.color;
        node.color = Color.red;
        return leftChild;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.black;
        node.left.color = Color.black;
        node.color = Color.red;
    }

    public boolean search(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            if (currentNode.value > value)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return false;
    }

}
