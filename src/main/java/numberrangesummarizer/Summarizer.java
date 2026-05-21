package numberrangesummarizer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Summarizer implements NumberRangeSummarizer
{

    /**
     * Splits a comma separated string of integers into a collection of Integer objects.
     *
     * @param input Comma-separated String of numbers
     * @return A Collection of Integers. Returns empty if input is null, invalid or empty.
     */
    @Override
    public Collection<Integer> collect(String input)
    {
        if (input == null || input.isEmpty())
            return Collections.emptyList();

        String[] inputList = input.split(",");
        List<Integer> numberList = new LinkedList<>();

        for (String num : inputList)
        {
            try
            {
                numberList.add(Integer.parseInt(num.strip()));
            } catch (NumberFormatException e)
            {
                System.out.println("Could not convert '" + num + "' to a valid integer. Proceeding without this value.");
            }
        }
        return numberList;
    }

    /**
     * Summarizes a collection of Integers, sorting and grouping any consecutive number as ranges, removes any duplicates.
     *
     * @param input A Collection of Integer objects
     * @return A summarized String of comma-separated numbers including any ranges (example: 7, 9-11, 15)
     */
    @Override
    public String summarizeCollection(Collection<Integer> input)
    {
        if(input == null || input.isEmpty())
            return "";

        List<Integer> inputList = new LinkedList<>(input);
        Collections.sort(inputList);
        StringBuilder result = new StringBuilder();
        int floor;

        for (int i = 0; i < inputList.size(); i++)
        {
            int curr = inputList.get(i);
            floor = curr;
            result.append(floor);

            while(i < inputList.size() - 1 && (curr + 1 == inputList.get(i+1) || curr == inputList.get(i+1)))
            {
                curr = inputList.get(i+1);
                i++;
            }

            if (floor != curr)
                result.append("-").append(curr);

            if (i < inputList.size() - 1)
                result.append(", ");
        }
        return result.toString();
    }
}
