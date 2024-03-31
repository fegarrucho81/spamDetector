import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SpamDetector {

    public static List<String> getSpamEmails(List<String> subjects, List<String> spamWords) {
        
        subjects = subjects.stream().map(String::toLowerCase).collect(Collectors.toList());
        spamWords = spamWords.stream().map(String::toLowerCase).collect(Collectors.toList());
      
        
        Set<String> spamWordsSet = new HashSet<>(spamWords);
      
        
        List<String> results = new ArrayList<>();
      
        
        for (String subject : subjects) {
          
            int spamWordCount = 0;
      
          
            for (String word : subject.split(" ")) {
            
                if (spamWordsSet.contains(word)) {
                    spamWordCount++;
                }
          }
      
          
            if (spamWordCount >= 2) {
                results.add("spam");
            } else {
                results.add("not spam");
            }
        }
      
        return results;
    }
      
    public static void main(String[] args) {
        
        List<String> subjects = Arrays.asList(
            "Urgente ! Oferta imperdível: ganhe um iPhone 14!",
            "Dicas para uma vida mais saudável. Imperdível imperdível",
            "Sua conta bancária está em risco urgente !",
            "Clique aqui para ganhar R$1000 de renda extra grátis",
            "Aprenda a investir em Bitcoin em apenas 10 minutos"
        );

        List<String> spamWords = Arrays.asList(
            "grátis",
            "imperdível",
            "ganhe",
            "clique",
            "dinheiro",
            "investimento",
            "renda extra",
            "risco",
            "urgente"
        );

        List<String> results = getSpamEmails(subjects, spamWords);

        for (String result : results) {
            
            System.out.println(result);

        }


    }

}