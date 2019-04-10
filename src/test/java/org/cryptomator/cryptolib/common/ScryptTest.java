package org.cryptomator.cryptolib.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

/**
 * Tests from https://tools.ietf.org/html/rfc7914#section-12
 */
public class ScryptTest {

	private static final Charset ASCII = Charset.forName("ASCII");

	@Test
	public void testEmptyString() {
		byte[] key = Scrypt.scrypt("", "".getBytes(ASCII), 16, 1, 64);
		byte[] expected = new byte[] { //
				(byte) 0x77, (byte) 0xd6, (byte) 0x57, (byte) 0x62, (byte) 0x38, (byte) 0x65, (byte) 0x7b, (byte) 0x20, //
				(byte) 0x3b, (byte) 0x19, (byte) 0xca, (byte) 0x42, (byte) 0xc1, (byte) 0x8a, (byte) 0x04, (byte) 0x97, //
				(byte) 0xf1, (byte) 0x6b, (byte) 0x48, (byte) 0x44, (byte) 0xe3, (byte) 0x07, (byte) 0x4a, (byte) 0xe8, //
				(byte) 0xdf, (byte) 0xdf, (byte) 0xfa, (byte) 0x3f, (byte) 0xed, (byte) 0xe2, (byte) 0x14, (byte) 0x42, //
				(byte) 0xfc, (byte) 0xd0, (byte) 0x06, (byte) 0x9d, (byte) 0xed, (byte) 0x09, (byte) 0x48, (byte) 0xf8, //
				(byte) 0x32, (byte) 0x6a, (byte) 0x75, (byte) 0x3a, (byte) 0x0f, (byte) 0xc8, (byte) 0x1f, (byte) 0x17, //
				(byte) 0xe8, (byte) 0xd3, (byte) 0xe0, (byte) 0xfb, (byte) 0x2e, (byte) 0x0d, (byte) 0x36, (byte) 0x28, //
				(byte) 0xcf, (byte) 0x35, (byte) 0xe2, (byte) 0x0c, (byte) 0x38, (byte) 0xd1, (byte) 0x89, (byte) 0x06 //
		};
		Assertions.assertArrayEquals(expected, key);
	}

	@Test
	public void testPleaseLetMeInString() {
		byte[] key = Scrypt.scrypt("pleaseletmein", "SodiumChloride".getBytes(ASCII), 16384, 8, 64);
		byte[] expected = new byte[] { //
				(byte) 0x70, (byte) 0x23, (byte) 0xbd, (byte) 0xcb, (byte) 0x3a, (byte) 0xfd, (byte) 0x73, (byte) 0x48, //
				(byte) 0x46, (byte) 0x1c, (byte) 0x06, (byte) 0xcd, (byte) 0x81, (byte) 0xfd, (byte) 0x38, (byte) 0xeb, //
				(byte) 0xfd, (byte) 0xa8, (byte) 0xfb, (byte) 0xba, (byte) 0x90, (byte) 0x4f, (byte) 0x8e, (byte) 0x3e, //
				(byte) 0xa9, (byte) 0xb5, (byte) 0x43, (byte) 0xf6, (byte) 0x54, (byte) 0x5d, (byte) 0xa1, (byte) 0xf2, //
				(byte) 0xd5, (byte) 0x43, (byte) 0x29, (byte) 0x55, (byte) 0x61, (byte) 0x3f, (byte) 0x0f, (byte) 0xcf, //
				(byte) 0x62, (byte) 0xd4, (byte) 0x97, (byte) 0x05, (byte) 0x24, (byte) 0x2a, (byte) 0x9a, (byte) 0xf9, //
				(byte) 0xe6, (byte) 0x1e, (byte) 0x85, (byte) 0xdc, (byte) 0x0d, (byte) 0x65, (byte) 0x1e, (byte) 0x40, //
				(byte) 0xdf, (byte) 0xcf, (byte) 0x01, (byte) 0x7b, (byte) 0x45, (byte) 0x57, (byte) 0x58, (byte) 0x87 //
		};
		Assertions.assertArrayEquals(expected, key);
	}

}
