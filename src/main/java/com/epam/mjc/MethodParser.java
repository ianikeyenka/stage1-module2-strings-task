package com.epam.mjc;

import java.util.Arrays;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String[] tokens = signatureString.split("[()]");
        String[] signature = tokens[0].split(" ");
        MethodSignature methodSignature = new MethodSignature(signature[signature.length - 1]);
        if (signature.length == 3) {
            methodSignature.setAccessModifier(signature[0]);
            methodSignature.setReturnType(signature[1]);
        } else {
            methodSignature.setReturnType(signature[0]);
        }
        if (tokens.length == 2) {
            String[] arguments = tokens[1].split(", ");
            List<MethodSignature.Argument> args = methodSignature.getArguments();
            for (String arg : arguments) {
                String[] parameter = arg.split(" ");
                MethodSignature.Argument argument = new MethodSignature.Argument(parameter[0], parameter[1]);
                args.add(argument);
            }
        }
        return methodSignature;
    }
}
