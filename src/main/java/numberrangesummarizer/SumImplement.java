package numberrangesummarizer;

public class SumImplement
{
    public static void main(String[] args) {
        Summarizer sum = new Summarizer();
        String s = "1,2,3,5,6,7,9,9.5";
        String s2 = "-19,-17,-15,-14,-13,-5,-1,0,1,3,5,7,8,9";
        System.out.println(sum.summarizeCollection(sum.collect(s2)));
    }
}
