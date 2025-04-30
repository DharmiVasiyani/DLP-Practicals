import java.io.*;
import java.util.*;

public class lexicalanalyser {
    static Set<String> keywords = new HashSet<>(Arrays.asList(
            "auto", "break", "case", "char", "const", "continue", "default", "do", "double",
            "else", "enum", "extern", "float", "for", "goto", "if", "int", "long", "register",
            "return", "short", "signed", "sizeof", "static", "struct", "switch", "typedef",
            "union", "unsigned", "void", "volatile", "while"));

    static Set<Character> punctuations = new HashSet<>(Arrays.asList('(', ')', '{', '}', ';', ',', ':'));
    static Set<String> operators = new HashSet<>(
            Arrays.asList("+", "-", "*", "/", "=", "%", "==", "<", ">", "<=", ">=", "!=", "++", "--"));

    static Set<String> symbolTable = new HashSet<>();
    static List<String> lexicalErrors = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input_file.txt"));
        StringBuilder code = new StringBuilder();
        String line;
        boolean multiLineComment = false;

        // Remove comments manually (not using regex)
        while ((line = br.readLine()) != null) {
            if (multiLineComment) {
                if (line.contains("*/")) {
                    multiLineComment = false;
                    line = line.substring(line.indexOf("*/") + 2);
                } else
                    continue;
            }

            if (line.contains("/*")) {
                multiLineComment = true;
                line = line.substring(0, line.indexOf("/*"));
            }

            if (line.contains("//"))
                line = line.substring(0, line.indexOf("//"));

            code.append(line).append("\n");
        }
        br.close();

        System.out.println("TOKENS");
        tokenize(code.toString());

        if (!lexicalErrors.isEmpty()) {
            System.out.println("\nLEXICAL ERRORS");
            for (String error : lexicalErrors)
                System.out.println(error + " invalid lexeme");
        }

        System.out.println("\nSYMBOL TABLE ENTRIES");
        int i = 1;
        for (String id : symbolTable)
            System.out.println(i++ + ") " + id);

        // Write cleaned code to file
        FileWriter fw = new FileWriter("modified_source.txt");
        fw.write(code.toString());
        fw.close();
    }

    static void tokenize(String code) {
        int i = 0;
        while (i < code.length()) {
            char ch = code.charAt(i);

            // Skip whitespace
            if (Character.isWhitespace(ch)) {
                i++;
                continue;
            }

            // Identifiers or keywords
            if (Character.isLetter(ch) || ch == '_') {
                StringBuilder word = new StringBuilder();
                while (i < code.length() && (Character.isLetterOrDigit(code.charAt(i)) || code.charAt(i) == '_')) {
                    word.append(code.charAt(i));
                    i++;
                }
                String w = word.toString();
                if (keywords.contains(w))
                    System.out.println("Keyword: " + w);
                else {
                    System.out.println("Identifier: " + w);
                    symbolTable.add(w);
                }
                continue;
            }

            // Numbers (constants)
            if (Character.isDigit(ch)) {
                StringBuilder number = new StringBuilder();
                while (i < code.length() && Character.isDigit(code.charAt(i))) {
                    number.append(code.charAt(i));
                    i++;
                }

                // Check if the number is followed by a letter (e.g., 7H — invalid)
                if (i < code.length() && Character.isLetter(code.charAt(i))) {
                    number.append(code.charAt(i));
                    i++;
                    lexicalErrors.add(number.toString());
                } else {
                    System.out.println("Constant: " + number.toString());
                }
                continue;
            }

            // String or character
            if (ch == '\'' || ch == '\"') {
                char quote = ch;
                i++;
                StringBuilder str = new StringBuilder();
                str.append(quote);
                while (i < code.length() && code.charAt(i) != quote) {
                    str.append(code.charAt(i));
                    i++;
                }
                if (i < code.length()) {
                    str.append(quote);
                    i++;
                    System.out.println("String: " + str.toString());
                } else {
                    lexicalErrors.add(str.toString()); // unmatched quote
                }
                continue;
            }

            // Punctuations
            if (punctuations.contains(ch)) {
                System.out.println("Punctuation: " + ch);
                i++;
                continue;
            }

            // Operators (check 2-char first)
            if (i + 1 < code.length()) {
                String op2 = "" + ch + code.charAt(i + 1);
                if (operators.contains(op2)) {
                    System.out.println("Operator: " + op2);
                    i += 2;
                    continue;
                }
            }

            // Single-char operator
            if (operators.contains("" + ch)) {
                System.out.println("Operator: " + ch);
                i++;
                continue;
            }

            // Anything else is a lexical error
            lexicalErrors.add("" + ch);
            i++;
        }
    }
}
