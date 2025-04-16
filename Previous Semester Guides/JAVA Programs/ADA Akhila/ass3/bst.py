class BSTNode:
    def __init__(self, key, value, parent=None):
        self.key = key
        self.value = value
        self.left = None
        self.right = None
        self.parent = parent


class BST:
    def __init__(self):
        self.root = None

    def minimum(self, startNode):
        node = startNode
        while node.left is not None:
            node = node.left
        return node

    def minimum(self):
        if self.root is None:
            return None
        return self.minimum(self.root).key

    def search(self, startNode, key):
        if startNode is None:
            return None
        if startNode.key == key:
            return startNode
        if startNode.key < key:
            return self.search(startNode.right, key)
        else:
            return self.search(startNode.left, key)

    def successor(self, key):
        node = self.search(self.root, key)
        if node is None:
            raise KeyError("Key not found in the tree")

        if node.right is not None:
            return self.minimum(node.right).key

        parent = node.parent
        while parent is not None and node == parent.right:
            node = parent
            parent = parent.parent

        if parent is None:
            return None
        return parent.key
