import java.util.*;

class DictionaryWord implements Comparable<DictionaryWord> {
    private String word;
    private String meanings;

    // Constructor
    public DictionaryWord(String word, String meanings) {
        this.word = word;
        this.meanings = meanings;
    }

    // Getter for word
    public String getWord() {
        return word;
    }

    // Setter for word
    public void setWord(String word) {
        this.word = word;
    }

    // Getter for meanings
    public String getMeanings() {
        return meanings;
    }

    // Setter for meanings
    public void setMeanings(String meanings) {
        this.meanings = meanings;
    }

    // Override compareTo method for sorting
    @Override
    public int compareTo(DictionaryWord other) {
        return this.word.compareTo(other.word);
    }

    // Override equals method for comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DictionaryWord that = (DictionaryWord) obj;
        return Objects.equals(word, that.word);
    }

    // Override hashCode method for comparison
    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    // Override toString method for display
    @Override
    public String toString() {
        return word + "\t" + meanings;
    }
}

public class B7 {

    public static void main(String[] args) {
        // Create a set to store DictionaryWord objects
        Set<DictionaryWord> dictionary = new HashSet<>();

        // Add DictionaryWord objects to the set
        dictionary.add(new DictionaryWord("bank robber", "Steals money from a bank"));
        dictionary.add(new DictionaryWord("burglar", "Breaks into a home to steal things"));
        dictionary.add(new DictionaryWord("forger", "Makes an illegal copy of something"));
        dictionary.add(new DictionaryWord("hacker", "Breaks into a computer system"));
        dictionary.add(new DictionaryWord("hijacker", "Takes control of an airplane"));
        dictionary.add(new DictionaryWord("kidnapper", "Holds someone for ransom money"));
        dictionary.add(new DictionaryWord("mugger", "Attacks and steals money from someone"));
        dictionary.add(new DictionaryWord("murderer", "Kills another person"));

        // Convert the set to a list and sort it
        List<DictionaryWord> sortedDictionary = new ArrayList<>(dictionary);
        Collections.sort(sortedDictionary);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to search for a word, or 2 to display all words:");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.print("Enter the word to search: ");
            String searchWord = sc.nextLine().trim().toLowerCase();
            boolean found = false;
            for (DictionaryWord word : sortedDictionary) {
                if (word.getWord().toLowerCase().equals(searchWord)) {
                    System.out.println("WORD\t\t\tMEANING");
                    System.out.println(word.getWord() + "\t" + word.getMeanings());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Word not found in the dictionary.");
            }
        } else if (choice == 3) {
            // Display the sorted dictionary
            System.out.println("-------------------------------------------------");
            System.out.println("WORD\t\t\tMEANING");
            System.out.println("-------------------------------------------------");
            int no = 1;
            for (DictionaryWord word : sortedDictionary) {
                System.out.println(word.getWord() + "\t");
                System.out.println(word.getMeanings());
                no++;
            }
            System.out.println("-------------------------------------------------");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}