package CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CSVReader
{
    private final String csvFile = "LeaderBoard.csv";
    static ArrayList<ArrayList<String>> parsedFile;
    int maxNumberOfScores = 5;

    public CSVReader()
    {
        parsedFile = new ArrayList<>();
        parseFile();
    }

    public ArrayList<ArrayList<String>> getParsedFile() { return parsedFile; }
    private void parseFile()
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            String line;

            while ((line = br.readLine()) != null)
            {
                parsedFile.add(new ArrayList<>(Arrays.asList(line.split(","))));
            }
        } catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }

    public void saveScore(int score, String nick)
    {
        boolean playerExists = false;
        boolean playerScoreUpdated = false;

        for  (int i = 0; i < parsedFile.size(); ++i)
        {
            if (parsedFile.get(i).get(0).equals(nick))
            {
                playerExists = true;
                if (Integer.parseInt(parsedFile.get(i).get(1)) < score)
                {
                    playerScoreUpdated = true;
                    ArrayList<String> tmp = parsedFile.get(i);
                    tmp.set(1, String.valueOf(score));
                    parsedFile.set(i, tmp);
                }
            }
        }

        if (playerExists && playerScoreUpdated)
        {
            parsedFile.sort(Collections.reverseOrder(Comparator.comparingInt(a -> Integer.parseInt(a.get(1)))));
        }
        else if (!playerExists)
        {
            parsedFile.add(new ArrayList<>(Arrays.asList(nick, String.valueOf(score))));
            parsedFile.sort(Collections.reverseOrder(Comparator.comparingInt(a -> Integer.parseInt(a.get(1)))));

            if (parsedFile.size() > maxNumberOfScores)
            {
                parsedFile.remove(parsedFile.size() - 1);
            }
        }
        saveNewFile();
    }

    private void saveNewFile()
    {
        try
        {
            FileWriter csvWriter = new FileWriter(csvFile);

            for (ArrayList<String> strings : parsedFile)
            {
                csvWriter.append(strings.get(0));
                csvWriter.append(",");
                csvWriter.append(strings.get(1));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
