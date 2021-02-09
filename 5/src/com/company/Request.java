package com.company;

import static com.company.Dijkstra.sssp;

public class Request {

    private final int time;
    private final int sourceKey;
    private final int destinationKey;
    private Response response;

    public Request(int time, int sourceKey, int destinationKey){
        this.time = time;
        this.sourceKey = sourceKey;
        this.destinationKey  = destinationKey;
    }

    public void catchResponse(Graph g){
        response = sssp(g, g.getVertex(sourceKey));
        response.calculate(g.getVertex(destinationKey));
        System.out.println(response.toString());
    }

    public void decreaseTraffic(){
        for (Edge e : response.getEdges()){
            e.setTraffic(e.getTraffic() - 1);
        }
    }

    public float getEnd() {
        return response.getTime();
    }

    public boolean isDone(int time){
        return this.time < time;
    }

    @Override
    public String toString() {
        return "Request{" +
                "time=" + time +
                ", sourceKey=" + sourceKey +
                ", destinationKey=" + destinationKey +
                '}';
    }
}
