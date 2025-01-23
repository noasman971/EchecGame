public class Color {

    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static String emoji(char element) {
        switch (element) {
            case '0':
                return ANSI_WHITE_BACKGROUND + " ⬜ " + ANSI_RESET; // color of empty case
            case '1':
                return ANSI_WHITE_BACKGROUND + " \uD83D\uDC68\uD83C\uDFFB\u200D\uD83E\uDDB3 " +  ANSI_RESET;
            case '2':
                return ANSI_WHITE_BACKGROUND + " \uD83D\uDC68\uD83C\uDFFF " +  ANSI_RESET; //color of player
            case '3':
                return ANSI_WHITE_BACKGROUND + " \uD83D\uDC69\uD83C\uDFFE " + ANSI_RESET; //color of player
            case '4':
                return ANSI_WHITE_BACKGROUND + " \uD83D\uDC69\uD83C\uDFFB " + ANSI_RESET; //color of player
            case '6':
                return ANSI_WHITE_BACKGROUND + " \uD83D\uDCA5 " + ANSI_RESET; //color of destruct
            case '7':
                return ANSI_WHITE_BACKGROUND + " ⬛ " + ANSI_RESET; //couleur du player
            case '8':
                return ANSI_WHITE_BACKGROUND + " \uD83D\uDD2B " + ANSI_RESET;
        }
        return ANSI_BLACK + ANSI_BLACK + element + ANSI_RESET;
    }
}