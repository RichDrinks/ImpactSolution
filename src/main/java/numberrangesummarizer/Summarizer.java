package numberrangesummarizer;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Summarizer implements NumberRangeSummarizer
{

    /**
     * Splits a comma separated string of integers into a collection of Integer objects.
     *
     * @param input Comma-separated String of numbers
     * @return A Collection of Integers. Returns empty if input is null or empty.
     * @throws IllegalArgumentException when presented with an invalid integer.
     */
    @Override
    public Collection<Integer> collect(String input)
    {
        if (input == null || input.isBlank())
        {
            return Collections.emptyList();
        }

        String[] inputList = input.split(",");
        List<Integer> numberList = new ArrayList<>();

        for (String num : inputList)
        {
            try
            {
                String strippedNum = num.strip();
                if (!strippedNum.isEmpty())
                {
                    numberList.add(Integer.parseInt(strippedNum));
                }
            } catch (NumberFormatException e)
            {
//                System.err.println("Invalid integer: '" + num + "'. Proceeding without number.");
                throw new IllegalArgumentException("Invalid integer: '" + num + "'",e);
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
        {
            return "";
        }

        List<Integer> inputList = new ArrayList<>(input.stream().distinct().sorted().toList());
        StringBuilder result = new StringBuilder();
        int i = 0;
//        for (int i = 0; i < inputList.size(); i++)
        while (i < inputList.size())
        {
            int curr = inputList.get(i);
            int floor = curr;
            result.append(floor);

            while(i < inputList.size() - 1 && curr + 1 == inputList.get(i+1))
            {
                curr = inputList.get(++i);
            }

            if (floor != curr)
            {
                result.append("-").append(curr);
            }

            if (i < inputList.size() - 1)
            {
                result.append(", ");
            }
            i++;
        }
        return result.toString();
    }
}
