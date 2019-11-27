package GoldTile;


import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by yuehu on 7/14/19.
 */
public class TestGoldTile {
    public TestGoldTile() {}

    @Test
    public void test() {
        GoldTile gt = new GoldTile();
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        Tile t3 = new Tile();
        Tile t4 = new Tile();
//        t3.isGold = true;
        t1.e = t2;
        t1.s = t3;
        t2.s = t3;
        t2.w = t1;
        t2.s = t4;
        t3.n = t1;
        t3.e = t4;
        t4.n = t2;
        t4.w = t3;

        List<Character> list = gt.findShortestPath(t1);
        for (Character c : list) {
            System.out.print(c + ",");
        }

    }
}
