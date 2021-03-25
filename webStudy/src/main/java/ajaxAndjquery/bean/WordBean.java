package ajaxAndjquery.bean;

public class WordBean {
    private int id;
    private String words;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "WordBean{" +
                "id=" + id +
                ", word='" + words + '\'' +
                '}';
    }
}
