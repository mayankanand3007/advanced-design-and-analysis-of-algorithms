import json

# using "with" closes resource automatically
def readJSONfile2Dict(filename):
    with open(filename, 'r') as jsonFile:
        data = json.load(jsonFile)
        return data

def writeDict2JSONfile(aDict, filename):
    with open(filename, 'w') as jsonFile:
        json.dump(aDict, jsonFile)

def dict2balancedDict(aDict):
    balanced_keys = []
    ordered_keys = sorted(key for key in aDict.keys())
    _dict2balancedDict(ordered_keys, balanced_keys)
    return {key:aDict[key] for key in balanced_keys}

# _dict2balancedDict does an pre-order walk on ordered data by median (median, left, right)
def _dict2balancedDict(ordered_keys, balanced_keys):
    l = len(ordered_keys)
    if l == 0:
        return
    else:
        median_key = ordered_keys[l//2]
        left_keys = ordered_keys[:l//2]        #[key for key in keys if key < median_key]
        right_keys = ordered_keys[l//2+1:]     #[key for key in keys if key > median_key]
        balanced_keys.append(median_key)
        _dict2balancedDict(left_keys, balanced_keys)
        _dict2balancedDict(right_keys, balanced_keys)
        return