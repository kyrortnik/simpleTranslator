package main.com.epam.entity;


import java.util.Objects;

public class ParameterSet {

   private String russianWord;
   private String englishWord;

   public ParameterSet(){

   }

    public ParameterSet(String russianWord, String englishWord) {
        this.russianWord = russianWord;
        this.englishWord = englishWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParameterSet that = (ParameterSet) o;

        if (!Objects.equals(russianWord, that.russianWord)) return false;
        return Objects.equals(englishWord, that.englishWord);
    }

    @Override
    public int hashCode() {
        int result = russianWord != null ? russianWord.hashCode() : 0;
        result = 31 * result + (englishWord != null ? englishWord.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParameterSet{" +
                "russianWord='" + russianWord + '\'' +
                ", englishWord='" + englishWord + '\'' +
                '}';
    }
}
