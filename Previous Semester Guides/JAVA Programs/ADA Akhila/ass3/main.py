from bst import BST
from helper import readJSONfile2Dict, dict2balancedDict
from copy import deepcopy

if __name__ == '__main__':
    episodeGuide = BST()
    episodes = readJSONfile2Dict("WildKrattsDB2.json")
    for episode in episodes:
        episodeGuide.insert(episode, episodes[episode])
    print(episodeGuide)

    print('minimum: ' + episodeGuide.minimum())
    print(episodeGuide.successor("S06E12"))

    episodes2 = dict2balancedDict(episodes)
    episodeGuide2 = BST()
    for episode in episodes2:
        episodeGuide2.insert(episode, episodes[episode])
    print(episodeGuide2)

    print('minimum: ' + episodeGuide2.minimum())
    print('maximum: ' + episodeGuide2.maximum())
