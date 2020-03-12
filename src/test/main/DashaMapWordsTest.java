import com.zipcodewilmington.DashaMapOne;
import com.zipcodewilmington.DashaMapThree;
import com.zipcodewilmington.DashaMapTwo;
import com.zipcodewilmington.FileIO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static com.zipcodewilmington.FileIO.HOME;
import static org.junit.Assert.assertEquals;

public class DashaMapWordsTest
{
    DashaMapOne mapOne = new DashaMapOne();
    DashaMapTwo mapTwo = new DashaMapTwo();
    DashaMapThree mapThree = new DashaMapThree();

    @Before
    public void setup()
    {
        mapOne = new DashaMapOne();
        mapTwo = new DashaMapTwo();
        mapThree = new DashaMapThree();
        ArrayList<String> wordList = null;
        try {
            wordList = FileIO.readFromFile(HOME + "/dev/DashaMaps/word-list.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String element : wordList)
        {
            String[] entry = element.split(" ");
            mapOne.set(entry[0], Integer.valueOf(entry[1]));
            mapTwo.set(entry[0], Integer.valueOf(entry[1]));
            mapThree.set(entry[0], Integer.valueOf(entry[1]));
        }
    }

    @Test
    public void sizes()
    {
        Long expectedOne = 124L;
        Long expectedTwo = 124L;
        Long expectedThree = 124L;

        Long actualOne = mapOne.size();
        Long actualTwo = mapTwo.size();
        Long actualThree = mapThree.size();

        assertEquals(expectedOne, actualOne);
        assertEquals(expectedTwo, actualTwo);
        assertEquals(expectedThree, actualThree);
    }

    @Test
    public void get()
    {
        String searched = "both";
        Integer expectedOne = 34;
        Integer expectedTwo = 34;
        Integer expectedThree = 34;

        Integer actualOne = mapOne.get(searched);
        Integer actualTwo = mapTwo.get(searched);
        Integer actualThree = mapThree.get(searched);

        assertEquals(expectedOne, actualOne);
        assertEquals(expectedTwo, actualTwo);
        assertEquals(expectedThree, actualThree);
    }

    @Test
    public void bucketSizes()
    {
        String searched = "yourself";
        Integer expectedOne = 5;
        Integer expectedTwo = 22;
        Integer expectedThree = 7;

        Integer actualOne = mapOne.bucketSize(searched);
        Integer actualTwo = mapTwo.bucketSize(searched);
        Integer actualThree = mapThree.bucketSize(searched);

        assertEquals(expectedOne, actualOne);
        assertEquals(expectedTwo, actualTwo);
        assertEquals(expectedThree, actualThree);
    }
}
