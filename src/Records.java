/* This class created for keeping and getting main sentence,sub sentence and similarity percentage
informations for each main sentence depending on max similarity percentage */

public class Records {
    private Long percentage;
    private int s_sentence;
    private int m_sentence;

    public Long getPercentage() {
        return percentage;
    }

    public void setPercentage(Long percentage) {
        this.percentage = percentage;
    }

    public int getS_sentence() {
        return s_sentence;
    }

    public void setS_sentence(int s_sentence) {
        this.s_sentence = s_sentence;
    }

    public int getM_sentence() {
        return m_sentence;
    }

    public void setM_sentence(int m_sentence) {
        this.m_sentence = m_sentence;
    }
}
