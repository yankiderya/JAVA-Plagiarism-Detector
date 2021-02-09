import java.util.Comparator;
/* In this class, the sorting process takes place considering the similarity percentage. */
public class Sorter implements Comparator<Records>
{
    @Override
    public int compare(Records r1, Records r2) {
        return r2.getPercentage().compareTo(r1.getPercentage());
    }
}