/*
You work on a team whose job is to understand the most sought after toys for the holiday season. A teammate of yours has built a webcrawler that extracts a list of quotes about toys from different articles. You need to take these quotes and identify which toys are mentioned most frequently. Write an algorithm that identifies the top N toys out of a list of quotes and list of toys.

Your algorithm should output the top N toys mentioned most frequently in the quotes.

Input:
The input to the function/method consists of five arguments:

numToys, an integer representing the number of toys
topToys, an integer representing the number of top toys your algorithm needs to return;
toys, a list of strings representing the toys,
numQuotes, an integer representing the number of quotes about toys;
quotes, a list of strings that consists of space-sperated words representing articles about toys

Output:
Return a list of strings of the most popular N toys in order of most to least frequently mentioned

Note:
The comparison of strings is case-insensitive. If the value of topToys is more than the number of toys, return the names of only the toys mentioned in the quotes. If toys are mentioned an equal number of times in quotes, sort alphabetically.
 */
import java.util.*;

public class TopNBuzzWord {

    private HashMap<String, ToyStat> mBuzzWords;

    public static void main(String []args){
        System.out.println("Hello World");
        String[] toys = { "elsa","elmo", "legos", "drone", "tablet", "warcraft"};
        String[] quotes = {
                "Elsa and Elmo are the toys I'll be buying for my kids,  is good",
                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa tablet to be very popular this year, Elsa!",

                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season Elsa"
        };
        int numToys = 6;
        int topToys = 2;
        int numQuotes = 6;
        TopNBuzzWord topNBuzzWord = new TopNBuzzWord();
        topNBuzzWord.getTopNBuzzWord(numToys, topToys, toys,numQuotes, quotes);
    }

    private List<String> getTopNBuzzWord(int numToys, int topToys, String[] toys, int numQuotes, String[]quotes){

        if(numToys == 0 || topToys == 0 ||  numQuotes==0){
            return null;
        }

        if(toys==null || toys.length==0){
            return null;
        }

        if(quotes==null || quotes.length==0){
            return null;
        }
        createABuzzWordMap(toys);

        for(String quote:quotes){
            HashMap<String, Boolean> hasQuoted=null ;
            hasQuoted = defineHasQuoted(hasQuoted, toys);
            quote=quote.replaceAll("\\p{Punct}", "");
            System.out.println(quote);
            quote=quote.toLowerCase();
            String[] words = quote.split(" ");

            for(String word:words){

                if(mBuzzWords.containsKey(word)){
                    if(word.equals("elsa")){
                        //System.out.println(Arrays.toString(words));
                    }
                    ToyStat stat = mBuzzWords.get(word);
                    stat.mNCounts = stat.getmNCounts()+1;
                    if(!hasQuoted.get(word)){
                        stat.mNQuotes = stat.getmNQuotes()+1;
                        hasQuoted.put(word, true);
                    }
                    mBuzzWords.put(word, stat);
                }
            }

        }

        for(String buzzword:mBuzzWords.keySet()){
            ToyStat toyStat = mBuzzWords.get(buzzword);
            System.out.println("Toy: "+buzzword+"    freq: "+toyStat.getmNCounts()+"    quotes: "+toyStat.getmNQuotes()+"   Score:"+toyStat.getmScore());
        }

        String[] result = getTopToys(topToys);

        System.out.println("*********************result*********************");
        for (String s:result){
            System.out.println(s);
        }

        return null;
    }

    private String[] getTopToys(int topToys) {
        List<String> result = new ArrayList<>();
        for(int i=0; i< topToys;i++){
            ToyStat maxScorer = new ToyStat("", 0, 0);
            for(String buzzword:mBuzzWords.keySet()){
                ToyStat toyStat = mBuzzWords.get(buzzword);
                if(toyStat.getmScore()>maxScorer.getmScore()){
                    maxScorer=toyStat;
                }

            }
            result.add(maxScorer.mToyName);
            mBuzzWords.remove(maxScorer.mToyName, maxScorer);

        }
        return result.stream().toArray(String[]::new);
    }

    private HashMap<String, Boolean> defineHasQuoted(HashMap<String, Boolean> hasQuoted, String[] toys) {
        if(hasQuoted==null){
            hasQuoted = new HashMap<>();
        }
        for(String toy:toys){
            toy=toy.toLowerCase();
            hasQuoted.put(toy, false);
        }
        return hasQuoted;
    }

    private void createABuzzWordMap(String[] toys) {
        if(mBuzzWords== null){
            mBuzzWords = new HashMap();
        }
        for(String toy:toys){
            toy=toy.toLowerCase();
            mBuzzWords.put(toy, new ToyStat(toy, 0,0));
        }
        return;
    }

    class ToyStat{

        String mToyName;
        int mNCounts;
        int mNQuotes;

        public int getmScore() {
            mScore=mNCounts+mNQuotes;
            return mScore;
        }

        int mScore;

        public ToyStat(String mToyName, int mNCounts, int mNQuotes) {
            this.mToyName = mToyName;
            this.mNCounts = mNCounts;
            this.mNQuotes = mNQuotes;
        }

        public String getmToyName() {
            return mToyName;
        }

        public int getmNCounts() {
            return mNCounts;
        }

        public int getmNQuotes() {
            return mNQuotes;
        }

    }
}
