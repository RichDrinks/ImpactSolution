package numberrangesummarizer;

public class SumImplement
{
    public static void main(String[] args) {
        Summarizer sum = new Summarizer();
        String s = "1,2,3,5,6,7,9";
        System.out.println(sum.summarizeCollection(sum.collect(s)));
    }
}
