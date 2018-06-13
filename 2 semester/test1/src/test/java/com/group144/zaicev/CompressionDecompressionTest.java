package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import static com.group144.zaicev.CompressionDecompression.compression;
import static com.group144.zaicev.CompressionDecompression.decompression;


public class CompressionDecompressionTest {

    @Test
    public void compressionTest() {
        byte[] array = new byte[]{2, 3, 3, 3, 6, 7};
        byte[] EXPECTED = new byte[]{1, 2, 3, 3, 1, 6, 1, 7};

        Assert.assertArrayEquals(EXPECTED, compression(array));
    }

    @Test
    public void compressionWithRepetitionAtEndTest() {
        byte[] array = new byte[]{2, 3, 3, 3, 6, 7, 7, 7};
        byte[] EXPECTED = new byte[]{1, 2, 3, 3, 1, 6, 3, 7};

        Assert.assertArrayEquals(EXPECTED, compression(array));
    }

    @Test
    public void decompressionTest() {
        byte[] array = new byte[]{1, 2, 3, 3, 1, 6, 1, 7};
        byte[] EXPECTED = new byte[]{2, 3, 3, 3, 6, 7};

        Assert.assertArrayEquals(EXPECTED, decompression(array));
    }

    @Test
    public void decompressionOneElementTest() {
        byte[] array = new byte[]{1, 2};
        byte[] EXPECTED = new byte[]{2};

        Assert.assertArrayEquals(EXPECTED, decompression(array));
    }
}