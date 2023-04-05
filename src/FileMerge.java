import java.io.*;

public class FileMerge {
    public static void makeMergedFile(File sourceFile, File outputFile) {
        BufferedReader inputStream = null;
        BufferedWriter outputStream = null;

        try {
            int totalFileCnt = 0;
            int totalLineCnt = 0;

            if (sourceFile.isDirectory()) {
                File[] fileList = sourceFile.listFiles();
                outputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));

                for (File file : fileList) {
                    inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    String line;
                    totalFileCnt++;
                    while ((line = inputStream.readLine()) != null) {
                        outputStream.write(line);
                        outputStream.newLine();
                        totalLineCnt++;
                    }
                }
            }

            printResultMsg(totalFileCnt, totalLineCnt);

        } catch (Exception e) {
            System.out.println("[Exception] " + e.getMessage());
        } finally {

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    private static void printResultMsg(int totalFileCnt, int totalLineCnt) {
        System.out.println();
        System.out.println("** File Merge Finished **");
        System.out.println("**** Total File Count : " + totalFileCnt);
        System.out.println("**** Total Line Count: " + totalLineCnt);
    }
}
