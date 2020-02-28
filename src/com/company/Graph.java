package com.company;

import java.util.*;

class Graph {

    private Map<Country, List<Country>> map = new HashMap<>();

    public void addVertex(Country s)
    {
        map.put(s, new LinkedList<Country>());
    }

    public void addEdge(int source, int destination)
    {
        //Bidirectional
        Country sourceV =  getVertex(source);
        Country destinationV=  getVertex(destination);
        map.get(sourceV).add(destinationV);
        map.get(destinationV).add(sourceV);
    }

    public Country getVertex(int id)
    {
        for (Country c:map.keySet()) {
            if (c.id == id){
                return c;
            }
        }
        return null;
    }

    public Country BFS(Country root){
        Queue<Country> queue = new LinkedList<>();
        List<Country> visitedVertex = new LinkedList<>();
        Country currentVertex;
        //Visit root
        queue.add(root);
        visitedVertex.add(root);

        while (!queue.isEmpty()){
            currentVertex = queue.poll();
            List<Country> children = map.get(currentVertex);
            Collections.sort(children);
            for (Country vertex:children) {
                if (!visitedVertex.contains(vertex)){
                    if (vertex.hasClub){
                        return vertex;
                    }
                    visitedVertex.add(vertex);
                    queue.add(vertex);
                }
            }
        }
        return null;
    }

}