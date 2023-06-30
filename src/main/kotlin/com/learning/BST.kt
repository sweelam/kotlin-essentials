class Node(val value: Int) {
    var leftNode: Node?
    var rightNode: Node?

    init {
        leftNode = null; rightNode = null;
    }
}


class BinaryTree {
    var root: Node? = null


    fun insert(currentNode: Node?, value: Int): Node {
        val newNode = Node(value)

        if (currentNode == null) return newNode

        val currentValue = currentNode!!.value

        when {
            (value < currentValue) -> currentNode.leftNode = insert(currentNode.leftNode, value)
            (value > currentValue) -> currentNode.rightNode = insert(currentNode.rightNode, value)
            else -> return currentNode
        }

        return currentNode
    }

    fun add(value: Int) {
        root = insert(root, value)
    }

    fun containsElement(currentNode: Node?, value: Int): Boolean {
        if (currentNode == null) return false

        if (currentNode.value == value) return true

        return if (value > currentNode.value) containsElement(currentNode.rightNode, value)
        else containsElement(currentNode.leftNode, value)
    }

    fun inorderTraverse(root: Node?) {
        if (root == null) return

        inorderTraverse(root.leftNode)
        println(root.value)
        inorderTraverse(root.rightNode)
    }

    fun postorderTraverse(root: Node?) {
        if (root == null) return

        postorderTraverse(root.leftNode)
        postorderTraverse(root.rightNode)
        println(root.value)
    }

    fun preorderTraverse(root: Node?) {
        if (root == null) return

        println(root.value)
        preorderTraverse(root.leftNode)
        preorderTraverse(root.rightNode)
    }
}

fun main() {
    val bt = BinaryTree()

    bt.add(6); bt.add(4); bt.add(8); bt.add(3); bt.add(5); bt.add(7); bt.add(9)

    println("In Order Traverse")
    bt.inorderTraverse(bt.root)


    println("Post Order Traverse")
    bt.postorderTraverse(bt.root)

    println("Pre Order Traverse")
    bt.preorderTraverse(bt.root)

    println("tree contains 8  ? ${bt.containsElement(bt.root, 8)}")
    println("tree contains 12 ? ${bt.containsElement(bt.root, 12)}")
    println("tree contains 4  ? ${bt.containsElement(bt.root, 4)}")
}

//                             6
//                           /   \
//                          4      8
//                         / \    / \
//                        3   5  7   9