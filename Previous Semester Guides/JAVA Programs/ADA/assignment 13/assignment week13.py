if __name__ == '__main__':
    import igraph
    import adjacency as m
    g = igraph.Graph()
    g = igraph.Graph.Adjacency(m.A, mode='directed')
    print(igraph.Graph.count_automorphisms_vf2(g))