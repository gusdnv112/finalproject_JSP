package dalpeng;

/**
 * Created by Park on 2017-06-06.
 */
public class word {
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public word(int no, String word, String mean) {
        this.no = no;
        this.word = word;
        this.mean = mean;
    }

    private int no;
    private String word;
    private String mean;
}
