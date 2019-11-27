///**
// * Created by yuehu on 11/20/17.
// */
//// package whatever; // don't place package name!
//
//// Given a 2D array, given one starting point 1, one end point 2, accessible 0, none-accessible -1. You can left, right, up and down.
///*
// 0  0  0  1
// -1 0  0 -1
// 2  0  -1 0
//
// What's the length of the shortest path betwen the starting point and the end point
//
//  5
//*/
//
//import java.io.*;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Set;
//
//class myCode
//{
//    public static void main (String[] args) throws java.lang.Exception
//    {
//        System.out.println("Hello Java");
//    }
//
//
//    public int bfs (int x1, int y1, int x2, int y2, int[][] arr, int length){
//        Queue<int[]> q = new LinkedList<>();
//        Set<int[]> visited = new HashSet<>();
//
//
//        int[] start = {x1, y1};
//        int distance = 0;
//        int height = arr.length;
//        int width = arr[0].length;
//
//        q.add(start);
//
//
//        while(!q .isEmpty){
//            int[] cur = q.poll();
//            int x = cur[0];
//            int y = cur[1];
//
//
//            if(x == x2 && y == y2){
//                return distance;
//            }
//
//
//            if(visited.contains(new int[]{x,y})){
//                continue;
//            }
//
//            distance++;
////            [[-1, -1], [1, 0], [0, 1], [1, 1]].map(deltaX, deltaY) => {
////
////            })
////            [{x: x-1, y: y-1}, {x: x+1, y: y},{x: x,y: y+1},{x: x, y: y-1}].forEach((obj)=>{
////
////            if(checkBound(obj)){
////                move(obj);
////            }
////
////
////            }
//
//
//
//            if (x + 1 <= width && arr[y][x+1] == 0){
//                move(x+1, y, q, visited);
//
//            }
//
//
//            if (x - 1 >= 0 && arr[y][x-1] == 0){
//
//                move(x-1, y, q, visited);
//
//
//            }
//
//
//            if (y - 1 >= 0 && arr[y-1][x] == 0){
//                move(x, y-1, q, visited);
//
//
//
//            }
//
//            if (y + 1 <= height && arr[y+1][x] == 0){
//                move(x, y+1, q, visited);
//
//
//            }
//
//        }
//
//        return -1;
//
//    }
//
////
////    public void move(int x, int y, Queue<int[]> q, Set<int[]> set){
////        int[] point = new int[]{x,y};
////        q.add(point);
////        set.add(point);
////    }
//}
//
//
///*
//Your last C# code is saved below:
//using System;
//
//public class Test
//{
//    public static void Main()
//    {
//        Console.WriteLine("Hello");
//    }
//}
// */