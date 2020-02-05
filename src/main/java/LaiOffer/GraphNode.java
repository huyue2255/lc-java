package LaiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 7/2/19.
 */
public class GraphNode {
    int label;
    List<GraphNode> neighbors;

    public GraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }




}
