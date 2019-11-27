package Basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 7/18/19.
 */
public class SynonymousQueries {

    /*
     * Given:
     * 1) a list of Synonyms that represents two strings that we assume to be synonymous
     * 2) a list of Queries that contains two strings which each represent a search query to be compared
     *
     * Return a list of booleans where the entry is:
     * true if the pair of queries in the related index are synonymous, false otherwise.
     *
     * Example Input:
     *  Synonyms = {("cool", "rad"), ("veeva", "vault")}
     *  Queries = {
     *   ("is veeva cool", "is vault rad"),
     *   ("what is veeva", "what is veeva"),
     *   ("work life balance", "work life instability")
     *  }

     q1="is veeva cool",q2= "is vault rad"
     q1[0] = "is" vs. q2[0] = "is"
     q1[1] = "veeva" vs. q2[1] = "vault"
     cool vs rad

     result.add(true);

     "what is veeva" vs "what is veeva"
     *
     * Example Output:
     *  [true, true, false]
     *
     * Assume all strings are lowercased and stripped of non-alphabetic characters.
     */

        public static List<Boolean> areQueriesSynonymous(List<Synonyms> synonyms, List<Queries> queries) {
            // return true if the queries are the same
            List<Boolean> result = new ArrayList<>();

            for (Queries query : queries) {
                String q1 = query.query1;
                String q2 = query.query2;
                String[] q1Words = q1.split(" "); // array containing individual words
                String[] q2Words = q2.split(" ");

                //because order matters
                if (q1Words.length != q2Words.length) {
                    result.add(false);
                } else {
                    boolean wasSame = true;
                    for (int i = 0; i < q1Words.length; i++) {
                        String word1 = q1Words[i];
                        String word2 = q2Words[i];
                        if(!(word1).equals(word2)){
                            // check if synonymous?
                            wasSame = synCheck(synonyms, word1, word2);
                            break;
                        }
                    }
                    result.add(wasSame);
                }
            }

            return result;
        }

        public static boolean synCheck(List<Synonyms> synonyms,String str1,String str2) {
            System.out.println("Doing synCheck for str1:" + str1 +" and str2:"+str2);
            for(Synonyms s : synonyms) {
                String s1 = s.word1;
                String s2 = s.word2;
                System.out.println("Synonym checking s1:" +s1 + "s2:" +s2);
                if ((s1.equals(str1) && s2.equals(str2)) || (s1.equals(str2) && s2.equals(str1))) {
                    System.out.println("found a synonym pair!");
                    return true;
                }
            }

            System.out.println("Did not find a synonym pair.");

            return false;
        }



        public static void main(String[] args) {
            List<Synonyms> synonyms = new ArrayList<>();
            synonyms.add(new Synonyms("cool", "rad"));
            synonyms.add(new Synonyms("veeva", "vault"));

            List<Queries> queries = new ArrayList<>();
            queries.add(new Queries("is vault cool", "is veeva rad"));
            queries.add(new Queries("what is veeva", "what is veeva"));
            queries.add(new Queries("work life balance", "work life instability"));

            System.out.println(areQueriesSynonymous(synonyms, queries));
        }
    }

    /**
     * Contains two Strings which are thought to be synonyms of each other.
     * e.g. fast, quick
     */
    class Synonyms {
        String word1;
        String word2;

        public Synonyms(String word1, String word2) {
            this.word1 = word1;
            this.word2 = word2;
        }

        public String getWord1() {
            return this.word1;
        }

        public String getWord2() {
            return this.word2;
        }
    }

    /**
     * Contains two Strings which each represent queries
     * e.g. "what does veeva do", "where is veeva located"
     */
    class Queries {
        String query1;
        String query2;

        public Queries(String query1, String query2) {
            this.query1 = query1;
            this.query2 = query2;
        }

        public String getQuery1() {
            return this.query1;
        }

        public String getQuery2() {
            return this.query2;
        }
    }


