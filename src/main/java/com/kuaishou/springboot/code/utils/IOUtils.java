package com.kuaishou.springboot.code.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-06-06
 */
public class IOUtils {

    public static final int EOF = -1;
    public static final int DEFAULT_BUFFER_SIZE = 1 << 12;

    private IOUtils() {

    }

    public static void close(Closeable... closeables) {
        if (ArrayUtils.isEmpty(closeables)) {
            return;
        }
        Arrays.stream(closeables).forEach(closeable -> {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    // ignore ex
                }
            }
        });
    }

    public static int copy(final InputStream input, final OutputStream output) throws IOException {
        final long count = copyLarge(input, output);
        if (count > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) count;
    }


    public static long copyLarge(final InputStream input, final OutputStream output)
            throws IOException {
        return copyLarge(input, output, new byte[DEFAULT_BUFFER_SIZE]);
    }

    public static long copyLarge(final InputStream input, final OutputStream output, final byte[] buffer)
            throws IOException {
        long count = 0;
        int n;
        while (EOF != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }
}
