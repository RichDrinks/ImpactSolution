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
        if (input == null || input.isEmpty())
        {
            return Collections.emptyList();
        }

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
        if(input == null || input.isEmpty())
        {
            return "";
        }

        List<Integer> inputList = new LinkedList<>(input);
        StringBuilder result = new StringBuilder();
        int floor;

        for (int i = 0; i < inputList.size(); i++)
        {
            int curr = inputList.get(i);
            floor = curr;
            result.append(floor);

            while(i < inputList.size() - 1 && curr + 1 == inputList.get(i+1))
            {
                curr = inputList.get(i+1);
                i++;
            }

            if (floor != curr)
            {
                result.append("-").append(curr);
            }

            if (i < inputList.size() - 1)
            {
                result.append(", ");
            }
        }

        return result.toString();
    }
}
