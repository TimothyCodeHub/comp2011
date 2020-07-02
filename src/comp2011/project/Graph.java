package comp2011.project;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import comp2011.lec4.Queue;
import comp2011.lecA.List;
/*project of F2018*/
    public class Graph {

        int AjIndexNumber = 0;

        public class vertex{
            int number;
            List neighbor;
        }

        vertex[] adjLists;


        Graph(String inputFile) throws FileNotFoundException {
            File d = new File(inputFile);
            Scanner input = new Scanner(d);

            input.next();
            adjLists = new vertex[input.nextInt()*2];

            while(input.hasNext()) {

                int start = input.nextInt();
                int dis = input.nextInt();

                addEdge(start,dis);

            }

            //for(int i=0; i < AjIndexNumber;i++)
               //System.out.println(i + "(index)："+adjLists[i].number+" --> "+ adjLists[i].neighbor.toString());



        }

        public void addEdge(int start, int dis){
            List a = new List();
            List b = new List();

            for(int i=0; i < adjLists.length; i++) {

                if(adjLists[i] != null) {
                    if(adjLists[i].number == start)
                        a = adjLists[i].neighbor;

                    if(adjLists[i].number == dis)
                        b = adjLists[i].neighbor;
                }
            }

            if(a.isEmpty()) {
                a.insertAtFront(dis);
                //a.insertAfter(a.search(start),dis);

                vertex v = new vertex();
                v.neighbor = a;
                v.number = start;

                adjLists[AjIndexNumber++] = v;
            }
            else {
                a.insertAtFront(dis);

            }

            if(b.isEmpty()) {
                b.insertAtFront(start);
                //b.insertAfter(b.search(dis),start);

                vertex v = new vertex();
                v.neighbor = b;
                v.number = dis;
                adjLists[AjIndexNumber++] = v;
            }
            else {
                b.insertAtFront(start);
            }


        }




    public String toString() {
        return "";
    }

    /*public boolean isForestV2(){
        boolean[] visited = new boolean[AjIndexNumber];
        boolean allforest = true;
        for (int i = 0; i <visited.length;i++) {
            if (visited[i] == false) {
                allforest = isATreeOrnot(i, visited,-1);

                //System.out.println("small group of graph Edge are " + number[1]);
                //System.out.println("small group of graph Vertex are " + number[0]);


            }

        }
        return allforest;



    }

    boolean isATreeOrnot (int a,boolean[] visited,int parent){

        visited[a] = true;
        int n = 0;
        for(int i =0; i<AjIndexNumber;i++){
            if(adjLists[i].number == a){
                n = i;
            }
        }

        int[] neighbor = adjLists[n].neighbor.toArray();

        for (int i:neighbor) {
            if (visited[i]) continue;
            //System.out.println(a + " ---> " + i);
            isATreeOrnot(i, visited,n);

            if (i != parent)
                return false;
        }



        return true;
    }

*/


    public boolean isForest(){
        boolean[] visited = new boolean[adjLists.length];
        boolean allForest = true;
        for (int i = 0; i <visited.length;i++) {
            if (visited[i] == false) {
                int[] number = {0,0};
                number = dfs(i, visited,number);
                number[1] = number[1]/2;
                //System.out.println("small group of graph Edge are " + number[1]);
                //System.out.println("small group of graph Vertex are " + number[0]);

                if(number[1] > number[0]) {
                    allForest =  false;
                    return allForest;
                }


                number[0] = 0;
                number[1] = 0;
            }

        }
        return allForest;
    }



    public boolean good() {
        boolean[] visited = new boolean[AjIndexNumber];
        boolean allGood = true;
        for (int i = 0; i <visited.length;i++) {
            if (visited[i] == false) {
                int[] number = {0,0};
                number = dfs(i, visited,number);
                number[1] = number[1]/2;
                //System.out.println("small group of graph Edge are " + number[1]);
                //System.out.println("small group of graph Vertex are " + number[0]);

                int TnumofV = number[0]*(number[0]-1)/2;
                if(TnumofV != number[1]) {
                    allGood =  false;
                    return allGood;
                }

                number[0] = 0;
                number[1] = 0;
            }

        }
        return allGood;

    }

    public int[]  dfs(int a, boolean[] visited,int[] number) {
        visited[a] = true;
        number[0]++;

        int n = 0;
        for(int i =0; i<AjIndexNumber;i++){
            if(adjLists[i].number == a){
                n = i;
            }
        }

        int[] neighbor = adjLists[n].neighbor.toArray();

        for (int i:neighbor) {
            number[1]++;
            if (visited[i]) continue;
            //System.out.println(a + " ---> " + i);
            dfs(i, visited,number);
        }
        //number[1] = number[1]/2;
        return number;
    }


    private int[] delete() {
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/tim/Desktop/testcases/forest.999";
        Graph g = new Graph(path);

        //System.out.println("Graph built:\n" + g);
        System.out.println("The graph is " + (g.isForest()?"":"not ") + "a forest.");
        System.out.println("The graph is " + (g.good()?"":"not ") + "good.");
        //int[] solution = g.delete();

       // System.out.println("We need to delete " + solution.length + " vertices: \n"
                //+ Arrays.toString(solution));
    }
}
