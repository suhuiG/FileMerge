import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("** Input Source Folder Path (ex: c://test) : ");
        String inputPath = sc.nextLine();

        System.out.print("** Input Merged File Path (ex: c://output/merge.csv) : ");
        String outputPath = sc.nextLine();

        File sourceFile = new File(inputPath);
        File outputFile = new File(outputPath);

        FileMerge.makeMergedFile(sourceFile, outputFile);
    }

}