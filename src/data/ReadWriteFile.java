package data;

import neural.TrainingSet;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadWriteFile {

    public static ArrayList<TrainingSet> readTrainingSets() {
        ArrayList<TrainingSet> trainingSets = new ArrayList<>();
        ArrayList<String> filenames = new ArrayList<>(Arrays.asList("car","smiley","heart", "tv"));

        for(int x=0;x<filenames.size();x++){
            String filename = filenames.get(x);
            for (ArrayList<Integer> list : readFromFile("/" + filename + ".txt")) {

                trainingSets.add(new TrainingSet(list, GoodOutputs.getInstance().getGoodOutput(filename)));
            }
        }




        return trainingSets;
    }

    private static ArrayList<ArrayList<Integer>> readFromFile(String filename) {
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();

        try {
            InputStream in = ReadWriteFile.class.getClass().getResourceAsStream(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                ArrayList<Integer> input = new ArrayList<>();
                int len = line.length();
                for (int i = 0; i < line.length(); i++) {
                    int value = 0;
                    try {
                        value = Integer.parseInt(String.valueOf(line.charAt(i)));
                    } catch (Exception e) {
                    }
                    input.add(value);
                }
                inputs.add(input);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputs;
    }

    public static void saveToFile(ArrayList<Integer> input, String filename) {
        try {
            File file = new File("resources/" + filename + ".txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            for (Integer i : input) {
                pw.write(Integer.toString(i));
            }
            pw.write("\n");
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
