package main.com.epam.entity;


public class WordPair {

   private final String englishWord;
   private final String russianWord;


    public WordPair(String englishWord, String russianWord) {
        this.englishWord = englishWord;
        this.russianWord = russianWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getRussianWord() {
        return russianWord;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordPair pair = (WordPair) o;

        if (englishWord != null ? !englishWord.equals(pair.englishWord) : pair.englishWord != null) return false;
        return russianWord != null ? russianWord.equals(pair.russianWord) : pair.russianWord == null;
    }

    @Override
    public int hashCode() {
        int result = englishWord != null ? englishWord.hashCode() : 0;
        result = 31 * result + (russianWord != null ? russianWord.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParameterSet{" +
                "englishWord='" + englishWord + '\'' +
                ", russianWord='" + russianWord + '\'' +
                '}';
    }
}
