package group144.zaicev;

/**
 * Class for checking correct bracket sequence
 */
class BracketSequence {
    /**
     * Leaves from the expression only brackets
     *
     * @param expression your expression
     */
    String bracketSequence(String expression) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < expression.length(); i++) {
            if ((expression.charAt(i) == '(') || (expression.charAt(i) == ')')) {
                result.append(expression.charAt(i));
            }
        }
        return String.valueOf(result);
    }

    /**
     * Checks the bracket sequence is correct
     *
     * @param bracketSequence bracket sequence
     * @return true, if bracket sequence is correct, else false
     */
    boolean isCorrectBracketSequence(String bracketSequence) {
        int checkBracket = 0;
        for (int i = 0; i < bracketSequence.length(); i++) {
            String oneSymbol = bracketSequence.substring(i, i + 1);
            if (oneSymbol.equals("(")) {
                checkBracket++;
            } else {
                checkBracket--;
            }

            if (checkBracket < 0) {
                return false;
            }

        }
        return checkBracket == 0;
    }
}
