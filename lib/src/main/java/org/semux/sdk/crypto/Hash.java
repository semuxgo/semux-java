/**
 * Copyright (c) 2021 The Semux Developers
 * <p>
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.sdk.crypto;

import java.security.MessageDigest;
import java.security.Security;

import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.semux.sdk.exception.CryptoException;

/**
 * Hash generator
 */
public class Hash {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static final int HASH_LEN = 32;

    /**
     * Generate the 256-bit hash.
     *
     * @param input
     * @return
     */
    public static byte[] h256(byte[] input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("BLAKE2B-256");
            return digest.digest(input);
        } catch (Exception e) {
            throw new CryptoException(e);
        }
    }

    /**
     * Merge two byte arrays and compute the 256-bit hash.
     *
     * @param one
     * @param two
     * @return
     */
    public static byte[] h256(byte[] one, byte[] two) {
        byte[] all = new byte[one.length + two.length];
        System.arraycopy(one, 0, all, 0, one.length);
        System.arraycopy(two, 0, all, one.length, two.length);

        return Hash.h256(all);
    }

    /**
     * Generate the 160-bit hash, using h256 and RIPEMD.
     *
     * @param input
     * @return
     */
    public static byte[] h160(byte[] input) {
        try {
            byte[] h256 = h256(input);

            RIPEMD160Digest digest = new RIPEMD160Digest();
            digest.update(h256, 0, h256.length);
            byte[] out = new byte[20];
            digest.doFinal(out, 0);
            return out;
        } catch (Exception e) {
            throw new CryptoException(e);
        }
    }

    private Hash() {
    }

}
