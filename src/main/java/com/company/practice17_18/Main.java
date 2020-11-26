package com.company.practice17_18;

import java.io.*;

public class Main {
    private static final String basePath = "src/com/company";
    private static final String mdFilePath = basePath + "/practice17_18/result.md";

    public static void creatorMD(String path) {
        File file = new File(path);
        String line;
        String[] files = null;

        if (file.isDirectory())
            files = file.list();

        try (FileWriter writer = new FileWriter(mdFilePath, true)) {
            writer.write("## " + path.substring(path.lastIndexOf("\\") + 1) + "\n");

            if (files != null)
                for (String str : files)
                    if (str.endsWith(".java")) {
                        writer.write("**" + str + "**" + "\n");
                        writer.write("```java" + "\n");

                        try (BufferedReader reader = new BufferedReader(new FileReader(path + "/" + str))) {
                            line = reader.readLine();

                            while (line != null) {
                                writer.write(line + "\n");
                                line = reader.readLine();
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }

                        writer.write("```" + "\n");
                    }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File(basePath);
        File mdFile = new File(mdFilePath);

        try {
            mdFile.createNewFile();
        } catch (IOException exception) {
            exception.getStackTrace();
        }

        if (file.isDirectory()) {
            File[] fileList = file.listFiles();

            if (fileList != null)
                for (File fi: fileList)
                    creatorMD(fi.getPath());
        }
    }
}
