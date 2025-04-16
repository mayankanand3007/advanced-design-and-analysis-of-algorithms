from helper import readJSONfile2Dict, dict2balancedDict
class Node:
    def __init__(self, key, value):
        self.left = None
        self.right = None
        self.key = key
        self.value = value
        self.parent = None


class BST:
    def __init__(self):
        self.root = None

    def insert(self, key, value):
        self.root = self.__insert(self.root, key, value)
        self.root.parent = None


    def __insert(self, node, key, value):
        if node is None:
            return Node(key, value)
        if key < node.key:
            node.left = self.__insert(node.left, key, value)
            node.left.parent = node
        elif node.key < key:
            node.right = self.__insert(node.right, key, value)
            node.right.parent = node
        else:
            node.key = key
            node.value = value
        return node


    def __minimum(self, startNode):
        node = startNode
        while node.left is not None:
            node = node.left
        return node

    def minimum(self):
        if self.root is None:
            return None
        return self.__minimum(self.root).key

    def search(self, startNode, key):
        if not startNode:
            return None
        if startNode.key == key:
            return startNode
        elif startNode.key < key:
            return self.search(startNode.right, key)
        elif startNode.key > key:
            return self.search(startNode.left, key)

    def successor(self, key):
        node = self.search(self.root, key)
        if node is None:
            raise KeyError("Key not found in the tree")
        if node.right is not None:
            return self.__minimum(node.right).key
        parent = node.parent
        while parent is not None and node == parent.right:
            node = parent
            parent = parent.parent
        if parent is None:
            return None
        return parent.key
if __name__ == '__main__':
    shan = BST()
    file = readJSONfile2Dict("WildKrattsDB.json")
    for doc in file:
        shan.insert(doc, file[doc])
    min_key = shan.minimum()
    print("Minimum key in the tree:", min_key)
    key = "S06E12"
    succ = shan.successor(key)
    print("Successor of", key, "is", succ)

    key = "S06E16"
    succ = shan.successor(key)
    print("Successor of", key, "is", succ)
