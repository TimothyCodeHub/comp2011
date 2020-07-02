package comp2011.project;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import comp2011.lec4.Queue;
import comp2011.lecA.List;


/*project of F2018*/
public class Snippet {

    List[] AjIndex;
    int AjIndexNumber = 0;
    List[] finnal;

    Snippet(String inputFile) throws FileNotFoundException {
        File d = new File(inputFile);
        Scanner input = new Scanner(d);

        input.next();

        AjIndex =  new List[input.nextInt()*2];

        while(input.hasNext()) {

            int start = input.nextInt();
            int dis = input.nextInt();

            addEdge(start,dis);

        }

       


        //for(List j:AjIndex)
        //System.out.println(j.toString());

    }

    public void addEdge(int start, int dis){
        List a = new List();
        List b = new List();

        for(int i=0; i < AjIndex.length; i++) {

            if(AjIndex[i] != null) {
                if(AjIndex[i].toArray()[0] == start)
                    a = AjIndex[i];

                if(AjIndex[i].toArray()[0] == dis)
                    b = AjIndex[i];
            }
        }

        if(a.isEmpty()) {
            a.insertAtFront(start);
            a.insertAfter(a.search(start),dis);

            AjIndex[AjIndexNumber++] = a;
        }
        else {
            a.insertAfter(a.search(start),dis);

        }

        if(b.isEmpty()) {
            b.insertAtFront(dis);
            b.insertAfter(b.search(dis),start);
            AjIndex[AjIndexNumber++] = b;
        }
        else {
            b.insertAfter(b.search(dis),start);
        }





    }

	
	   
    public String toString() {
        return "";
    }

    //
    public boolean isForest() {
        return false;
    }

    // 
    public boolean good() {
        return false;
    } 

    private int[] delete() {
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/tim/Desktop/testcases/goodgraph.29";
        Snippet g = new Snippet(path);
        //System.out.println("Graph built:\n" + g);
        System.out.println("The graph is " + (g.isForest()?"":"not ") + "a forest.");
        System.out.println("The graph is " + (g.good()?"":"not ") + "good.");
        //int[] solution = g.delete();
       // System.out.println("We need to delete " + solution.length + " vertices: \n"
                //+ Arrays.toString(solution));
    }
	
	
	
	
	
}

