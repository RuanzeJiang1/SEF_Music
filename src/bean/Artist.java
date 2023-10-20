package bean;

import java.io.*;
import java.util.*;

public class Artist {
    private String ID;
    private String Name;
    private String Address;
    private String Birthdate;
    private String Bio;
    private ArrayList<String> Occupations;
    private ArrayList<String> Genres;
    private ArrayList<String> Awards;

    public Artist() {
    }

    public Artist(String id, String name, String address, String birthdate, String bio,
                  String occupations, String genres, String awards) {
        ID = id;
        Name = name;
        Address = address;
        Birthdate = birthdate;
        Bio = bio;
        Occupations = new ArrayList<>(Arrays.asList(occupations.split(",")));
        Genres = new ArrayList<>(Arrays.asList(genres.split(",")));
        Awards = new ArrayList<>(Arrays.asList(awards.split(",")));
    }

    public Artist(String id, String name, String address, String birthdate, String bio,
                  ArrayList<String> occupations, ArrayList<String> genres, ArrayList<String> awards) {
        ID = id;
        Name = name;
        Address = address;
        Birthdate = birthdate;
        Bio = bio;
        Occupations = occupations;
        Genres = genres;
        Awards = awards;
    }

    // Each attribute there are corresponding get and set methods.
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
    }

    public ArrayList<String> getOccupations() {
        return Occupations;
    }

    public void setOccupations(ArrayList<String> occupations) {
        Occupations = occupations;
    }

    public ArrayList<String> getGenres() {
        return Genres;
    }

    public void setGenres(ArrayList<String> genres) {
        Genres = genres;
    }

    public ArrayList<String> getAwards() {
        return Awards;
    }

    public void setAwards(ArrayList<String> awards) {
        Awards = awards;
    }

    //Convert an ArrayList of strings into a comma separated string.
    public String joinArrayList(ArrayList<String> arrayList) {
        StringBuilder result = new StringBuilder(arrayList.get(0));
        for(int idx=1; idx<arrayList.size(); ++idx) {
            result.append(',').append(arrayList.get(idx));
        }
        return result.toString();
    }

    // Use regular expressions or other logic to verify the correctness of the artist attributes.
    public boolean checkID(String id) {
        return id.matches("[5-9]{3}[A-Z]{5}[^0-9a-zA-Z]{2}");
    }

    public boolean checkDate(String date) {
        return date.matches("\\d\\d-\\d\\d-\\d\\d\\d\\d");
    }

    public boolean checkAddress(String address) {
        return address.matches("\\S.*?\\|\\S.*?\\|\\S.*?");
    }

    public boolean checkBio(String bio) {
        String[] words = bio.split(" ");
        return words.length >= 10 && words.length <= 30;
    }

    public boolean checkOccupation(ArrayList<String> occupations) {
        int len = occupations.size();
        return len >= 1 && len <= 5;
    }

    public boolean checkAwards(ArrayList<String> awards) {
        if(awards.size() % 2 == 1) {
            return false;
        }
        for(int idx=0; idx<awards.size(); ++idx) {
            String year = awards.get(idx);
            String title = awards.get(++idx);
            String[] words = title.split(" ");
            if(!year.matches("\\d{4}")) {
                return false;
            }
            if(words.length < 4 || words.length > 10) {
                return false;
            }
        }
        return true;
    }

    public boolean checkGenres(ArrayList<String> genres) {
        int len = genres.size();
        boolean hasPopORRock = false;
        if(len < 2 || len > 5) {
            return false;
        }
        for (String item : genres) {
            if ("pop".equals(item) || "rock".equals(item)) {
                if (hasPopORRock) {
                    return false;
                } else {
                    hasPopORRock = true;
                }
            }
        }
        return true;
    }

    public boolean checkAllProperty() {
        if (!checkID(ID)) {
            System.out.println("Incorrect ID");
            return false;
        } else if (!checkDate(Birthdate)) {
            System.out.println("Incorrect date of birth");
            return false;
        } else if (!checkAddress(Address)) {
            System.out.println("Incorrect address");
            return false;
        } else if (!checkBio(Bio)) {
            System.out.println("Incorrect Bio");
            return false;
        } else if (!checkOccupation(Occupations)) {
            System.out.println("Incorrect occupation");
            return false;
        } else if (!checkAwards(Awards)) {
            System.out.println("The awards are incorrect.");
            return false;
        } else if (!checkGenres(Genres)) {
            System.out.println("Incorrect genre");
            return false;
        }
        return true;
    }

    // Collect input and create a new artist object and then write it to the artists.txt
    public boolean addArtist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id:");
        String id = scanner.nextLine();
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter the address:");
        String address = scanner.nextLine();
        System.out.println("Please enter your birthday:");
        String birthDate = scanner.nextLine();
        System.out.println("Please enter the Bio:");
        String bio = scanner.nextLine();
        System.out.println("Please enter occupation:");
        String occupations = scanner.nextLine();
        System.out.println("Please enter the genre:");
        String genres = scanner.nextLine();
        System.out.println("Please enter the award:");
        String awards = scanner.nextLine();
        Artist artist = new Artist(id, name, address, birthDate, bio, occupations, genres, awards);
        if (!artist.checkAllProperty()) {
            return false;
        }
        try {
            FileWriter fileWriter = new FileWriter("artists.txt", true);
            // Create the BufferedWriter object, passing in the FileWriter object parameters.
            BufferedWriter writer = new BufferedWriter(fileWriter);
            String data = artist.toString();
            // Write data
            writer.write(data);
            writer.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Update exist artist and first reads all artist information from the artists.txt file and then replaces the line that matches the given ID, and then write to the file.
    public boolean updateArtist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id:");
        String id = scanner.nextLine();
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter the address:");
        String address = scanner.nextLine();
        System.out.println("Please enter your birthday:");
        String birthDate = scanner.nextLine();
        System.out.println("Please enter the Bio:");
        String bio = scanner.nextLine();
        System.out.println("Please enter occupation:");
        String occupations = scanner.nextLine();
        System.out.println("Please enter the genre:");
        String genres = scanner.nextLine();
        System.out.println("Please enter the award:");
        String awards = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("artists.txt"));
            String line = reader.readLine();
            StringBuilder content = new StringBuilder();
            while (line != null) {
                String[] cols = line.split("\t");
                if(cols.length == 0) {
                    continue;
                }
                if(cols[0].equals(id)) {
                    Artist artist = new Artist(id, name, address, birthDate, bio, occupations, genres, awards);
                    int year = Integer.parseInt(artist.getBirthdate().substring(5, 10));
                    if (!artist.checkAllProperty()) {
                        return false;
                    }
                    if(year < 2000
                    && !joinArrayList(artist.getGenres()).equals(genres)) {
                        return false;
                    }
                    line = artist.toString();
                }
                content.append(line).append('\n');
                // read next line
                line = reader.readLine();
            }
            reader.close();
            FileWriter fileWriter = new FileWriter("artists.txt");
            // Create the BufferedWriter object, passing in the FileWriter object parameters.
            BufferedWriter writer = new BufferedWriter(fileWriter);
            // Write data
            writer.write(content.toString());
            writer.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
                ID, Name, Address, Birthdate, Bio,
                joinArrayList(Occupations), joinArrayList(Genres), joinArrayList(Awards));
    }

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