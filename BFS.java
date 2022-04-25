//package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args){
        int n,m;
        int a,b;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        n = sc.nextInt();
        System.out.println("Enter the number of edges");
        m = sc.nextInt();
        //making the graph using arraylists.
        ArrayList < ArrayList <Integer> > conn = new ArrayList< ArrayList<Integer> >();
        for(int i=0;i<n+1;i++){
            conn.add(new ArrayList<Integer>());
        }
        //load adajency list.
        for(int i=0;i<m;i++){
            a = sc.nextInt();
            b = sc.nextInt();
           // System.out.println(a+" "+b);
            conn.get(a).add(b);
            conn.get(b).add(a);
        }
        // setting default visited list to false.
        boolean [] visited = new boolean[n+1];
        for(int i=0;i<n+1;i++){
            visited[i] = false;
        }
        // initializing Queue
        // Queue because we want to add from one side and remove from another side
        Queue <Integer> level = new LinkedList<Integer>();
        // starting traverse from node 1.
        level.add(1);
        visited[1] = true;
        int si=0;
        int le=0;
        //BFS
        while(!level.isEmpty()){
            System.out.println("Level :" + le);
            si = level.size();
            while(si>0){
                si--;
                int x = level.poll();
                System.out.println(x);
                //Fetching the neighbors and visiting them all.
                for(int j=0;j<conn.get(x).size();j++){
                    if(!visited[conn.get(x).get(j)]){
                        visited[conn.get(x).get(j)] = true;
                        //if not visited then enqueue.
                        level.add(conn.get(x).get(j));
                    }
                }
            }
            le++;
        }
    }
}
