/* This sorter is used to sort records and find the highest similarity ratio among the temporarily kept values for tempRecords class.*/
import java.util.Comparator;

public class TempSorter implements Comparator<TempRecords>
{
    @Override
    public int compare(TempRecords t1, TempRecords t2) {
        return t2.getPercentage().compareTo(t1.getPercentage());
    }
}