package ru.rrozhkov.easykin.core.crypt;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by rrozhkov on 05.07.2018.
 */
public class EncrypterTest {

    @Test
    public void testEncrypt() throws Exception {
        String template = "QL0AFWMIX8NRZTKeof9cXsvbvu8=";
        String encrypted = new Encrypter().encrypt("123");
        Assert.assertTrue(template.equals(encrypted));
    }
}
