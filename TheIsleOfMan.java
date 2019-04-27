package MapsLambdaAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfMan {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "^(?:([\\#\\$\\%\\&\\*]))(?<name>[A-Za-z]+)(?:(\\1))\\=(?<length>[\\d]+)\\!\\!(?<geohash>(.?)+)$";
        Pattern pattern = Pattern.compile(regex);
        String decryptedMessage = "";

        while (true) {
            String input = reader.readLine();

            Matcher matcher = pattern.matcher(input);

            if (!matcher.find()) {
                System.out.println("Nothing found!");
            } else {


                String name = matcher.group("name");
                int length = Integer.parseInt(matcher.group("length"));
                String geohash = matcher.group("geohash");

                if (geohash.length() == length) {

                    for (int i = 0; i < geohash.length(); i++) {
                        char currentDecryptedChar = (char)(geohash.charAt(i) + length);
                        decryptedMessage += currentDecryptedChar;
                    }
                    System.out.println(String.format("Coordinates found! %s -> %s",
                            name, decryptedMessage));
                    return;

            } else {
                    System.out.println("Nothing found!");
                }

            }


        }


    }
}
