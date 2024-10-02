import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import net.jqwik.api.*;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.NotEmpty;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.constraints.UniqueElements;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class PalindromeTest {

    @Property
    void stringFollowedByReverse(
            @ForAll @AlphaChars String word
    ) {
        String reversed = reverse(word);
        String concatenated = word + reversed;
        assertThat(Palindrome.isPalindrome(concatenated)).isTrue();
    }

    @Property
    void stringFollowedBySingleCharFollowedByReverse(
            @ForAll @AlphaChars String word,
            @ForAll @AlphaChars char c
    ) {
        String reversed = reverse(word);
        String concatenated = word + c + reversed;
        assertThat(Palindrome.isPalindrome(concatenated)).isTrue();
    }

    @Property
    void uniqueCharacters(
            @ForAll("uniqueWordNotPalindrom") String word
    ) {
        assertThat(Palindrome.isPalindrome(word)).isFalse();
    }

    @Provide
    Arbitrary<String> uniqueWordNotPalindrom() {
        return Arbitraries.strings()
                .withCharRange('a', 'z')
                .ofMinLength(2)
                .ofMaxLength(26)
                .map(str -> str.chars().distinct()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString()
                )
                .filter(str -> str.length() >= 2);
    }


    @Property
    void uppercasePalindrome(
            @ForAll @AlphaChars String word
    ) {
        String uppercaseWord = word.toUpperCase();
        String uppercaseReversed = reverse(uppercaseWord);
        String concatenated = uppercaseWord + uppercaseReversed;
        assertThat(Palindrome.isPalindrome(concatenated)).isTrue();
    }


    static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

}