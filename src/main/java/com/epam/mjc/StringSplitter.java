package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        StringBuilder regax = new StringBuilder("[");
        for (String delimiter : delimiters) {
            regax.append(delimiter);
        }
        regax.append("]");
        String[] tokens = source.split(regax.toString());
        List<String> result = new ArrayList<>();
        for (String token : tokens) {
            if (token.length() > 0) {
                result.add(token);
            }
        }
        return result;
    }
}
