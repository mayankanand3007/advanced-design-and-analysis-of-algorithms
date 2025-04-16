from bst import BST
from helper import readJSONfile2Dict, dict2balancedDict
from copy import deepcopy

if __name__ == '__main__':
    episodeGuide = BST()
    episodes = readJSONfile2Dict("WildKrattsDB.json")
    for episode in episodes:
        episodeGuide.insert(episode, episodes[episode])
    print("size  ", len(episodes))
    print("height of tree:", episodeGuide.depth())
    print("minimum of tree:", episodeGuide.minimum())
    print("Test Results after delete minimum key:")
    episodeGuide.delete('S01E01')
    print("size", len(episodes))
    print("height of tree:", episodeGuide.depth())
    print("minimum of tree:", episodeGuide.minimum())
