# Base64

Base64 是一种基于64个字符表示二进制数据的方法。

```java
final class Base64 {
    private Base64() {
    }

    public static byte[] decode(String in) {
        // Ignore trailing '=' padding and whitespace from the input.
        int limit = in.length();
        for (; limit > 0; limit--) {
            char c = in.charAt(limit - 1);
            if (c != '=' && c != '\n' && c != '\r' && c != ' ' && c != '\t') {
                break;
            }
        }

        // If the input includes whitespace, this output array will be longer than necessary.
        byte[] out = new byte[(int) (limit * 6L / 8L)];
        int outCount = 0;
        int inCount = 0;

        int word = 0;
        for (int pos = 0; pos < limit; pos++) {
            char c = in.charAt(pos);

            int bits;
            if (c >= 'A' && c <= 'Z') {
                // char ASCII value
                //  A    65    0
                //  Z    90    25 (ASCII - 65)
                bits = c - 65;
            } else if (c >= 'a' && c <= 'z') {
                // char ASCII value
                //  a    97    26
                //  z    122   51 (ASCII - 71)
                bits = c - 71;
            } else if (c >= '0' && c <= '9') {
                // char ASCII value
                //  0    48    52
                //  9    57    61 (ASCII + 4)
                bits = c + 4;
            } else if (c == '+' || c == '-') {
                bits = 62;
            } else if (c == '/' || c == '_') {
                bits = 63;
            } else if (c == '\n' || c == '\r' || c == ' ' || c == '\t') {
                continue;
            } else {
                return null;
            }

            // Append this char's 6 bits to the word.
            word = (word << 6) | (byte) bits;

            // For every 4 chars of input, we accumulate 24 bits of output. Emit 3 bytes.
            inCount++;
            if (inCount % 4 == 0) {
                out[outCount++] = (byte) (word >> 16);
                out[outCount++] = (byte) (word >> 8);
                out[outCount++] = (byte) word;
            }
        }

        int lastWordChars = inCount % 4;
        if (lastWordChars == 1) {
            // We read 1 char followed by "===". But 6 bits is a truncated byte! Fail.
            return null;
        } else if (lastWordChars == 2) {
            // We read 2 chars followed by "==". Emit 1 byte with 8 of those 12 bits.
            word = word << 12;
            out[outCount++] = (byte) (word >> 16);
        } else if (lastWordChars == 3) {
            // We read 3 chars, followed by "=". Emit 2 bytes for 16 of those 18 bits.
            word = word << 6;
            out[outCount++] = (byte) (word >> 16);
            out[outCount++] = (byte) (word >> 8);
        }

        // If we sized our out array perfectly, we're done.
        if (outCount == out.length) return out;

        // Copy the decoded bytes to a new, right-sized array.
        byte[] prefix = new byte[outCount];
        System.arraycopy(out, 0, prefix, 0, outCount);
        return prefix;
    }

    private static final byte[] MAP = new byte[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '+', '/'
    };

    private static final byte[] URL_MAP = new byte[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '-', '_'
    };

    public static String encode(byte[] in) {
        return encode(in, MAP);
    }

    public static String encodeUrl(byte[] in) {
        return encode(in, URL_MAP);
    }

    private static String encode(byte[] in, byte[] map) {
        // 三个字节用四个字符来表示，如果字节数无法整除3，则相应的补2个或者1个字节，
        // 这个length表示的是补完字节之后的字符数。
        int length = (in.length + 2) / 3 * 4;
        byte[] out = new byte[length];
        int index = 0, end = in.length - in.length % 3;
        for (int i = 0; i < end; i += 3) {
            out[index++] = map[(in[i] & 0xff) >> 2];
            out[index++] = map[((in[i] & 0x03) << 4) | ((in[i + 1] & 0xff) >> 4)];
            out[index++] = map[((in[i + 1] & 0x0f) << 2) | ((in[i + 2] & 0xff) >> 6)];
            out[index++] = map[(in[i + 2] & 0x3f)];
        }
        switch (in.length % 3) {
            case 1:
                out[index++] = map[(in[end] & 0xff) >> 2];
                out[index++] = map[(in[end] & 0x03) << 4];
                out[index++] = '=';
                out[index++] = '=';
                break;
            case 2:
                out[index++] = map[(in[end] & 0xff) >> 2];
                out[index++] = map[((in[end] & 0x03) << 4) | ((in[end + 1] & 0xff) >> 4)];
                out[index++] = map[((in[end + 1] & 0x0f) << 2)];
                out[index++] = '=';
                break;
        }
        try {
            return new String(out, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}

```

## 参考文档

-[Base64](https://zh.wikipedia.org/wiki/Base64)