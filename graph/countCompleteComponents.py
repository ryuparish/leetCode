# We will first create a list that maps each index (index 0 is node 0 and index 1 is node 1 and so on)
# or node to their set of edges. Then, we will use stack-based dfs to explore the whole component and increment
# the number of components by 1. Then, we will increment the number of components each time we find
# and unvisited node, which we will keep track of in an array. We will also use a set to keep track of the 
# nodes visited relative to the component. If each of the nodes in the component have inComponent-1 edges, then add to
# complete components. Return the number of complete components found.
class Solution:
    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:
        visited = [False] * n
        nodeEdges = [set() for node in range(n)]
        # Create our nodeEdges array of arrays
        for node1, node2 in edges:
            nodeEdges[node1].add(node2)
            nodeEdges[node2].add(node1)
        
        components = 0
        # Loop through all nodes
        for nodeNum in range(n):
            # Add node to stack if node has not been visited
            if not visited[nodeNum]:
                stack = []
                inComponent = set()
                stack.append(nodeNum)
                inComponent.add(nodeNum)
                visited[nodeNum] = True
                # Explore the component
                while len(stack) > 0:
                    node = stack.pop()
                    # Explore each neighbor and add to stack if unvisited
                    for neighbor in nodeEdges[node]:
                        if not visited[neighbor]:
                            inComponent.add(neighbor)
                            stack.append(neighbor)
                            visited[neighbor] = True
                # If all the nodes in the component have inComponent-1 edges, then it is fully connected
                if all(len(nodeEdges[node]) == len(inComponent)-1 for node in inComponent):
                    components += 1
        return component
