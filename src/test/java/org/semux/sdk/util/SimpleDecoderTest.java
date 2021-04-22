package org.semux.sdk.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.semux.sdk.crypto.Hex;

public class SimpleDecoderTest {

    @Test
    public void testCodec() {
        byte byte1 = Byte.MAX_VALUE;
        byte byte2 = Byte.MIN_VALUE;
        short short1 = Short.MAX_VALUE;
        short short2 = Short.MIN_VALUE;
        int int1 = Integer.MAX_VALUE;
        int int2 = Integer.MIN_VALUE;
        long long1 = Long.MAX_VALUE;
        long long2 = Long.MIN_VALUE;
        byte[] bytes1 = Bytes.random(20);
        byte[] bytes2 = Bytes.EMPTY_BYTES;
        String string1 = "test";
        String string2 = "";

        SimpleEncoder enc = new SimpleEncoder();
        enc.writeBoolean(true);
        enc.writeByte(byte1);
        enc.writeShort(short1);
        enc.writeInt(int1);
        enc.writeLong(long1);
        enc.writeBytes(bytes1);
        enc.writeString(string1);
        enc.writeBoolean(false);
        enc.writeByte(byte2);
        enc.writeShort(short2);
        enc.writeInt(int2);
        enc.writeLong(long2);
        enc.writeBytes(bytes2);
        enc.writeString(string2);
        byte[] encoded = enc.toBytes();

        SimpleDecoder dec = new SimpleDecoder(encoded);
        assertTrue(dec.readBoolean());
        assertEquals(byte1, dec.readByte());
        assertEquals(short1, dec.readShort());
        assertEquals(int1, dec.readInt());
        assertEquals(long1, dec.readLong());
        assertArrayEquals(bytes1, dec.readBytes());
        assertEquals(string1, dec.readString());
        assertFalse(dec.readBoolean());
        assertEquals(byte2, dec.readByte());
        assertEquals(short2, dec.readShort());
        assertEquals(int2, dec.readInt());
        assertEquals(long2, dec.readLong());
        assertArrayEquals(bytes2, dec.readBytes());
        assertEquals(string2, dec.readString());
    }

    @Test
    public void testSizeEncoding() {
        int[] sizes = { 0x00, 0x7F, 0x80, 0x2000, 0x3FFF, 0x4000, 0x1FFFFF, 0x200000, 0x08000000, 0x0fffffff };
        SimpleEncoder enc = new SimpleEncoder();
        for (int size : sizes) {
            enc.writeSize(size);
        }
        byte[] bytes = enc.toBytes();
        assertEquals("007F8100C000FF7F818000FFFF7F81808000C0808000FFFFFF7F", Hex.encode(bytes).toUpperCase());

        SimpleDecoder dec = new SimpleDecoder(bytes);
        for (int size : sizes) {
            assertEquals(size, dec.readSize());
        }
        assertEquals(bytes.length, dec.getReadIndex());
    }
}
