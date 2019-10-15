package codewars.Tests;

import codewars.SimpleEncryption;
import org.junit.Assert;
import org.junit.Test;

public class SimpleEncryptionTest
{
    @Test
    public void encryptTest() 
    {
        Assert.assertEquals("This is a test!", SimpleEncryption.encrypt("This is a test!", 0));
        Assert.assertEquals("hsi  etTi sats!", SimpleEncryption.encrypt("This is a test!", 1));
        Assert.assertEquals("s eT ashi tist!", SimpleEncryption.encrypt("This is a test!", 2));
        Assert.assertEquals(" Tah itse sits!", SimpleEncryption.encrypt("This is a test!", 3));
        Assert.assertEquals("This is a test!", SimpleEncryption.encrypt("This is a test!", 4));
        Assert.assertEquals("This is a test!", SimpleEncryption.encrypt("This is a test!", -1));
        Assert.assertEquals("hskt svr neetn!Ti aai eyitrsig", SimpleEncryption.encrypt("This kata is very interesting!", 1));
    }
    
    @Test
    public void encryptNullEmptyTest()
    {
        Assert.assertEquals("", SimpleEncryption.encrypt("", 0));
        Assert.assertNull(SimpleEncryption.encrypt(null, 0));
    }

    @Test
    public void decryptTest() 
    {
        Assert.assertEquals("This is a test!", SimpleEncryption.decrypt("This is a test!", 0));
        Assert.assertEquals("This is a test!", SimpleEncryption.decrypt("hsi  etTi sats!", 1));
        Assert.assertEquals("This is a test!", SimpleEncryption.decrypt("s eT ashi tist!", 2));
        Assert.assertEquals("This is a test!", SimpleEncryption.decrypt(" Tah itse sits!", 3));
        Assert.assertEquals("This is a test!", SimpleEncryption.decrypt("This is a test!", 4));
        Assert.assertEquals("This is a test!", SimpleEncryption.decrypt("This is a test!", -1));
        Assert.assertEquals("This kata is very interesting!", SimpleEncryption.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }

    @Test
    public void decryptNullEmptyTest() 
    {
        Assert.assertEquals("", SimpleEncryption.decrypt("", 0));
        Assert.assertNull(SimpleEncryption.decrypt(null, 0));
    }
}
