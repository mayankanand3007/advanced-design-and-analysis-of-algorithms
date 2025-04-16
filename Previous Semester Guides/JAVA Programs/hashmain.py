import ctypes
from linkedList import singlyLinkedList
class hashTable:
    def __init__(self, m=127):
        self.m = m
        pyarraytype = ctypes.py_object * m
        self.table = pyarraytype()
        for i in range(m):
            self.table[i] = singlyLinkedList()
    def keyToHash(self, key):
        return hash(key)%self.m
    def insert(self, key, value):
        index = self.keyToHash(key)
        self.table[index].insert(key, value)
    def delete(self, key):
        index = self.keyToHash(key)
        self.table[index].delete(key)
    def __getitem__(self, key):
        index = self.keyToHash(key)
        return self.table[index].__getitem__(key)