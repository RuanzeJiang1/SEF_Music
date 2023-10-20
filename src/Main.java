import bean.Artist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a: add;b: update");
        String opt = scanner.next();
        if("a".equals(opt)) {
            new Artist().addArtist();
        } else {
            new Artist().updateArtist();
        }
    }
}
