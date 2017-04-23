package flowershop.Report;

import flowershop.bucket.Bucket;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

public class TxtFileReporter {

    private static final String MESSAGE_PATTERN = "Bucket price is {0}; and its size is {1}";
    private static final String REPORT_FILE_NAME = "Report.txt";

    public static void createReport(Bucket bucket){
        String messageString = MessageFormat.format(MESSAGE_PATTERN, bucket.calcPrice(),bucket.getBucketSize());

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(REPORT_FILE_NAME), StandardCharsets.UTF_8))) {
            writer.write(messageString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
