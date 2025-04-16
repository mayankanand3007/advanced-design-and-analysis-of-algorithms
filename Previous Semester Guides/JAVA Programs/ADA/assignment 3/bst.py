class Node:
    def __init__(self, key, value):
        self.left = None
        self.right = None
        self.key = key
        self.value = value

    def __iter__(self):
        if self.left:
            yield from self.left
        yield self
        if self.right:
            yield from self.right

class BST:
    def __init__(self):
        self.root = None

    def isEmpty(self):
        return self.root == None

    # Python size method
    def __len__(self):
        return self.size(self.root)

    def size(self, node):
        if node is None:
            return 0
        return 1 + self.size(node.left) + self.size(node.right)

    # Python is in method
    def __contains__(self, key):
        return self.isElementOf(self.root, key)

    def isElementOf(self, node, key):
        if node is None:
            return False
        if key < node.key:
            return self.get(node.left, key)
        elif node.key < key:
            return self.get(node.right, key)
        else:
            return True

    # Python accessor value = BST[key]
    def __getitem__(self, key):
        return self.__get(self.root, key)

    # recursive part of getter __getitem__
    def __get(self, node, key):
        if node is None:
            raise KeyError
        if key < node.key:
            return self.__get(node.left, key)
        elif node.key < key:
            return self.__get(node.right, key)
        else:
            return node.value

    # Python modifier BST[key] = value
    def __setitem__(self, key, value):
        self.root = self.insert(self.root, key, value)

    def insert(self, key, value):
        self.root = self.__insert(self.root, key, value)

    # recursive part of setter __setitem__
    def __insert(self, node, key, value):
        if node is None:
            return Node(key, value)
        if key < node.key:
            node.left = self.__insert(node.left, key, value)
        elif node.key < key:
            node.right = self.__insert(node.right, key, value)
        else:
            node.key = key
            node.value = value
        return node

    def maximum(self):
        max = self.__maximum(self.root)
        return max.key

    def __maximum(self, node):
        currentNode = node
        while currentNode.right is not None:
            currentNode = currentNode.right
        return currentNode
    
    def __minimum(self, startNode):
        current = startNode
        if(current == None):
           return current

        while(current.left is not None):
            current = current.left           
        return current
        
    def minimum(self):
        if self.root is None:
            return None
            
        minNode = self.__minimum(self.root)        
        return minNode.key
        
    def delete(self, key ): 
        self.root = self.__delete(self.root, key)
    
    def __delete(self, delnode, delkey):
        if delnode is  None:
            return delnode
        
        if delkey < delnode.key:
            delnode.left = self.__delete(delnode.left, delkey)
        else:       
            if delkey > delnode.key:
                delnode.right = self.__delete(delnode.left, delkey)
            
            if delnode.left == None:
                return delnode.right
            
            if delnode.right == None:
                return delnode.left                  
        
            delnode = self.__minimum(delnode.right)
            delnode.right = self.__delete(delnode.right, delkey)
        return delnode
    
    def inOrder(self):
        keys = []
        self.__inOrder(self.root, keys)
        return keys

    def __inOrder(self, node, keys):
        if node is not None:
            self.__inOrder(node.left, keys)
            keys.append(node.key)
            self.__inOrder(node.right, keys)

    def getNodeDepth(self, node):
        if node is None:
            return 0
        if node.left is None:
            if node.right is None:
                return 1
            else:
                return self.getNodeDepth(node.right)+1
        elif node.right is None:
            if node.left is None:
                return 1
            else:
                return self.getNodeDepth(node.left)+1
        else:
            return max(self.getNodeDepth(node.left), self.getNodeDepth(node.right))+1

    def depth(self):
        return self.getNodeDepth(self.root)

    def __iter__(self):
        if self.root:
            for node in self.root.__iter__():
                yield node.key

    def __repr__(self):
        if self.root == None:
            return "empty binary search tree"
        else:
            size = self.size(self.root)
            depth = self.depth()
            return f"binary search tree of size {size} and depth {depth}"