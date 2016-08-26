package transliterator;

import com.ibm.icu.text.Transliterator;


/*
The ICU4J library makes it possible to perform a wide variety of text conversions from one format to another.
Transliterator objects are used to perform the various conversions.

Transliterator is an abstract class that transliterates text from one format to another.
The most common kind of transliterator is a script, or alphabet, transliterator.

For example, a Russian to Latin transliterator
changes Russian text written in Cyrillic characters to phonetically equivalent Latin characters

For more info on transliterator refer: http://icu-project.org/apiref/icu4j/com/ibm/icu/text/Transliterator.html
 */

/*
Maven dependency for using icu4j lib:

<dependency>
    <groupId>com.ibm.icu</groupId>
    <artifactId>icu4j</artifactId>
    <version>4.8</version>
</dependency>

 */

public class RemoveDiacritics {

    public static void main(String args[]){
        RemoveDiacritics rd = new RemoveDiacritics();
        System.out.println(rd.deAcentUsingICU("Mayagüez"));
        System.out.println(rd.deAcentUsingICU("Reykjavík"));
        System.out.println(rd.deAcentUsingICU("Nóatún 17"));
        System.out.println(rd.deAcentUsingICU("prashastr"));
        System.out.println(rd.deAcentUsingICU("Новосибирск"));
        System.out.println(rd.deAcentUsingICU("Ribeirão Preto")) ;
        System.out.println(rd.deAcentUsingICU("Bayamón")) ;
        System.out.println(rd.deAcentUsingICU("APARTADO 1945")) ;
        System.out.println(rd.deAcentUsingICU("就难保不会就滚女鬼")) ;
        System.out.println(rd.deAcentUsingICU("成都")) ;
        System.out.println(rd.deAcentUsingICU("淼禾")) ;
        System.out.println(rd.deAcentUsingICU("王")) ;

        /*
        Output of program is as:

        Mayaguez
        Reykjavik
        Noatun 17
        prashastr
        Novosibirsk
        Ribeirao Preto
        Bayamon
        APARTADO 1945
        jiu nan bao bu hui jiu gun nu gui
        cheng dou
        miao he
        wang

        */
    }


    public String deAcentUsingICU(String str){
        Transliterator accentsConverter = Transliterator.getInstance("Any-Latin; NFD; [:M:] Remove; NFC; [^\\p{ASCII}] Remove");
        return accentsConverter.transliterate(str);
    }
}