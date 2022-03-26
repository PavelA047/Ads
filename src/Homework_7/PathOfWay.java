package Homework_7;

import java.util.ArrayList;

public class PathOfWay {
    ArrayList<Vertex> pathList;
    int pathLength;

    public PathOfWay(int length) {
        this.pathList = new ArrayList<>();
        this.pathLength = length;
    }

    public ArrayList<Vertex> getPathList() {
        return pathList;
    }

    public void setPathList(ArrayList<Vertex> pathList) {
        this.pathList = pathList;
    }

    public int getPathLength() {
        return pathLength;
    }

    public void setPathLength(int pathLength) {
        this.pathLength = pathLength;
    }

    @Override
    public String toString() {
        return "PathOfWay{" +
                "pathList=" + pathList +
                ", pathLength=" + pathLength +
                "}\n";
    }
}
