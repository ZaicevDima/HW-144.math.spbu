package com.group144.zaicev;

import java.util.ArrayList;

/**
 * Class for compressing or decompression
 */
class CompressionDecompression {
    /**
     * compress array
     *
     * @param array array, which you want to compress
     * @return compressing array
     */
    byte[] compression(byte[] array) {
        ArrayList<Byte> resultInList = new ArrayList<>();
        int amountRepetitions = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == (array[i - 1])) {
                amountRepetitions++;
            } else {
                resultInList.add((byte) amountRepetitions);
                resultInList.add(array[i - 1]);
                amountRepetitions = 1;
            }
        }

        resultInList.add((byte) amountRepetitions);
        resultInList.add(array[array.length - 1]);

        return toArray(resultInList);
    }

    /**
     * decompress array
     *
     * @param array array, which you want to decompress
     * @return decompressing array
     */
    byte[] decompression(byte[] array) {
        ArrayList<Byte> result = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array[i]; j++) {
                result.add(array[i + 1]);
            }
            i++;
        }
        return toArray(result);
    }

    /**
     * transformations array list to array for byte
     *
     * @param arrayList your array list, which you want to transformation
     * @return transformed into array list
     */
    private byte[] toArray(ArrayList<Byte> arrayList) {
        byte[] result = new byte[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
}
