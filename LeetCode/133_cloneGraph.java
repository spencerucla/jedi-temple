/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> oldNewMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> toVisit = new LinkedList<UndirectedGraphNode>();
        toVisit.add(node);
        while (!toVisit.isEmpty()) {
            UndirectedGraphNode oldNode = toVisit.poll();
            UndirectedGraphNode newNode = new UndirectedGraphNode(oldNode.label);
            oldNewMap.put(oldNode, newNode);
            for (UndirectedGraphNode oldNeighbor : oldNode.neighbors) {
                if (!oldNewMap.containsKey(oldNeighbor)) {
                    toVisit.add(oldNeighbor);
                }
            }
        }
        for (UndirectedGraphNode oldNode : oldNewMap.keySet()) {
            UndirectedGraphNode newNode = oldNewMap.get(oldNode);
            for (UndirectedGraphNode oldNeighbor : oldNode.neighbors) {
                UndirectedGraphNode newNeighbor = oldNewMap.get(oldNeighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return oldNewMap.get(node);
    }
}
