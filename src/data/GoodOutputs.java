package data;

import java.util.ArrayList;
import java.util.Arrays;

public class GoodOutputs {

    private static GoodOutputs instance;

    private ArrayList<ArrayList<Double>> goodValues;

    public static GoodOutputs getInstance() {
        if (instance == null)
            instance = new GoodOutputs();

        return instance;
    }

    public GoodOutputs() {
        this.goodValues = new ArrayList<>();

    }

    public ArrayList<Double> getGoodOutput(String letter) {

        int index = 0;
        if(letter == "car"){
            return new ArrayList<>(Arrays.asList(1.0,0.0,0.0,0.0));
        }else if(letter == "smiley"){
            return new ArrayList<>(Arrays.asList(0.0,1.0,0.0,0.0));
        }else if(letter == "heart"){
            return new ArrayList<>(Arrays.asList(0.0,0.0,1.0,0.0));
        }else if(letter == "tv"){
            return new ArrayList<>(Arrays.asList(0.0,0.0,0.0,1.0));
        }
        return goodValues.get(index);
    }

}
