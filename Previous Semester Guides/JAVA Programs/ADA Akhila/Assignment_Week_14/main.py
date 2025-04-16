import igraph
from adjacency import A

def main():
    # Create a graph from the adjacency matrix
    g = igraph.Graph.Adjacency(A)

    # Determine the size of the automorphism group
    automorphism_group_size = g.count_automorphisms_vf2()
    
    # Print the size of the automorphism group
    print("Size of the automorphism group:", automorphism_group_size)

if __name__ == '__main__':
    main()
