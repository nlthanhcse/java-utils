package support;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

public class ValidationUtils {
    private static final Logger logger = Logger.getLogger(ValidationUtils.class.getName());

    /**
     * Check if all boolean values is true
     * Accept null value (null = false)
     *
     * @param booleans
     * @return
     */
    public static Boolean isAllTrue(Boolean... booleans) {
        return Arrays.asList(booleans).stream().allMatch(Boolean.TRUE::equals);
    }

    /**
     * Check if any boolean values is true
     * Accept null value (null = false)
     *
     * @param booleans
     * @return
     */
    public static Boolean isAnyTrue(Boolean... booleans) {
        return Arrays.asList(booleans).stream().anyMatch(Boolean.TRUE::equals);
    }

    /**
     * Check if a number is an odd or not
     * Accept null value (null = 0)
     *
     * @param number
     * @return
     */
    public static Boolean isOdd(Integer number) {
        if (Objects.isNull(number)) number = 0;
        return number % 2 != 0;
    }


    public static <T> T[][] transposeTwoDimensionalMatrix(int numberOfRows, int numberOfColumns, T[][] matrix, Class<T> type) {
        T[][] tmp = (T[][]) Array.newInstance(type, numberOfColumns, numberOfRows);
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                tmp[j][i] = matrix[i][j];
            }
        }
        return tmp;
    }

    public static <T> Boolean isSymmetricMatrix(T[][] matrix, T[][] transposedMatrix) {
        return true;
    }

    /**
     * Check if a char is in a range (char in decimal number)
     *
     * @param startChar
     * @param startIncluded
     * @param endChar
     * @param endIncluded
     * @return true or false
     */
    public static Boolean isCharInRange(char aChar, char startChar, boolean startIncluded, char endChar, boolean endIncluded) {
        boolean check = false;
        int aDecimal = Character.getNumericValue(aChar);
        int startDecimal = Character.getNumericValue(startChar);
        int endDecimal = Character.getNumericValue(endChar);
        if (startIncluded && endIncluded) {
            check = (aDecimal >= startDecimal && aChar <= endDecimal) ? Boolean.TRUE : Boolean.FALSE;
        } else if (startIncluded) {
            check = (aDecimal >= startDecimal && aChar < endDecimal) ? Boolean.TRUE : Boolean.FALSE;
        } else if (endIncluded) {
            check = (aDecimal > startDecimal && aChar <= endDecimal) ? Boolean.TRUE : Boolean.FALSE;
        } else {
            check = (aDecimal > startDecimal && aChar < endDecimal) ? Boolean.TRUE : Boolean.FALSE;
        }
        return check;
    }

    public static void main(String[] args) {
        logger.info(isAllTrue(true, null).toString());
        logger.info(isAnyTrue(true, null).toString());
        logger.info(isOdd(null).toString());
    }
}
