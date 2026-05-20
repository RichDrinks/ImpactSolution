package numberrangesummarizer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Summarizer implements NumberRangeSummarizer
{
    @Override
    public Collection<Integer> collect(String input)
    {
        String[] inputList = input.split(",");
        List<Integer> numberList = new LinkedList<>();

        for (String num : inputList)
        {
            try
            {
                numberList.add(Integer.parseInt(num));
            } catch (NumberFormatException e)
            {
                System.out.println("Could not convert '" + num + "' to a valid integer. Proceeding without this value.");
            }
        }
        return numberList;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input)
    {
        List<Integer> inputList = new LinkedList<>(input);
        StringBuilder result = new StringBuilder();
        int floor = inputList.get(0);
        boolean inRange = false;

        for (int i = 0; i < inputList.size(); i++)
        {
            int curr = inputList.get(i);

            if(i < inputList.size()-1 && curr+1 == inputList.get(i+1))
            {
                if (!inRange) {
                    inRange = true;
                    floor = curr;
                }
            }
            else if (inRange)
            {
                inRange = false;
                result.append(floor).append("-").append(curr);
            }
            else
            {
                result.append(curr);
            }

            if(i < inputList.size()-1 && !inRange)
                result.append(", ");
        }

        return result.toString();
    }
}
