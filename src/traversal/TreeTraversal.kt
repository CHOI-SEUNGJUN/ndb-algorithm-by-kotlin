package traversal

// 트리 순회 알고리즘

private data class BinaryTree(
    var data: Int,
    var left: BinaryTree? = null,
    var right: BinaryTree? = null
)

/**
 * 전위 순회
 */
private fun preOrder(binaryTree: BinaryTree) {
    print("${binaryTree.data} ")
    binaryTree.left?.let { preOrder(it) }
    binaryTree.right?.let { preOrder(it) }
}

/**
 * 중위 순회
 */
private fun inOrder(binaryTree: BinaryTree) {
    binaryTree.left?.let { inOrder(it) }
    print("${binaryTree.data} ")
    binaryTree.right?.let { inOrder(it) }
}

/**
 * 후위 순회
 */
private fun postOrder(binaryTree: BinaryTree) {
    binaryTree.left?.let { postOrder(it) }
    binaryTree.right?.let { postOrder(it) }
    print("${binaryTree.data} ")
}

fun main() {
    val binaryTrees = arrayOfNulls<BinaryTree>(16)

    for (i in 1 until binaryTrees.size) {
        binaryTrees[i] = BinaryTree(i)
    }

    for (i in 1 until binaryTrees.size) {
        if (i % 2 == 0) {
            binaryTrees[i / 2]?.left = binaryTrees[i]
        } else {
            binaryTrees[i / 2]?.right = binaryTrees[i]
        }
    }

    preOrder(binaryTrees[1]!!)
    println()
    inOrder(binaryTrees[1]!!)
    println()
    postOrder(binaryTrees[1]!!)
}