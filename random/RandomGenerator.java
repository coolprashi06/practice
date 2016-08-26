package random;


import org.apache.commons.lang3.RandomStringUtils;


public class RandomGenerator {

    public static void main(String args[]) {
        String random = RandomStringUtils.randomAlphanumeric(16);
        System.out.println(random);
    }
}

