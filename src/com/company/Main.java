package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countriesNumber = scanner.nextInt();
        int u,v,clubsNumber;
        Graph graph = new Graph();
        Country root = null;
        Country country;

        //Add Vertexes
        for(int i = 0 ; i < countriesNumber; i++){
            country = new Country(i+1,false);
            if (i == 0){
                root = country;
            }
            graph.addVertex(country);
        }

        //Add edges
        for(int i = 0 ; i < countriesNumber-1; i++){
             u = scanner.nextInt();
             v = scanner.nextInt();
             graph.addEdge(u,v);
        }

        clubsNumber = scanner.nextInt();

        //Add Clubs
        for (int i = 0; i < clubsNumber; i++) {
            graph.getVertex(scanner.nextInt()).setHasClub(true);
        }

        System.out.println(graph.BFS(root).id);
    }
}
