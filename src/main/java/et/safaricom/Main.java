package et.safaricom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Main {
    private static final String insertStmt = """
    INSERT INTO CUSTOMER_PROFILE (ICCID, MSISDN, IMSI, TIMESTAMP, PROFILETYPE, CUSTOMERFULLNAME, EMAIL, LANGUAGE,  NATIONALITY, CHANNEL, DOB, LOCALDOB, ACTIVATIONTYPE, CUSTOMERSTATUS,  CUSTOMERID, REG_DOCUMENT_TYPE, REG_DOCUMENT_NUMBER, CREATED_USER, DOCUMENT_ISSUE_DATE, ISMINOR, OCCUPATION, EMPLOYER, POSITION, AVERAGEMONTHLYINCOME, IDEXPIRYDATE, STATUSFLAG)
    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
""";

    private KafkaMessage message = null;

    private Properties appProps;

    private void loadProperties() {
        appProps = new Properties();

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        try {
            appProps.load(new FileInputStream(rootPath + "application.properties"));


            System.out.printf("Loaded appProps = %s\n", appProps);
        } catch (IOException exp) {
            System.out.printf("Failed to load application.properties file. reason: %s\n", exp.getMessage());
        }

    }

    public static void main(String[] args) {
        try {

            Main m = new Main();

            m.loadProperties();

            // create a new type that implement messagepoller.
            var poller= new MessagePoller(m.appProps, List.of("6d-customer-activations")) {
                @Override
                public void process(ConsumerRecord<String, String> record) {
                    System.out.printf("Processing record: %s\n", record);

                    var mapper = new ObjectMapper();

                    try {
                        var message = mapper.readValue(record.value(), KafkaMessage.class);

                        try (Connection conn = DBConnector.getConnection(m.appProps);
                             PreparedStatement stat = conn.prepareStatement(insertStmt)) {

                            stat.setString(1, message.getIccid());
                            stat.setString(2, message.getMsisdn());
                            stat.setString(3, message.getImsi());
                            stat.setString(4, message.getTimeStamp());
                            stat.setString(5, message.getProfileType());
                            stat.setString(6, message.getCustomerFullName());
                            stat.setString(7, message.getEmail());
                            stat.setString(8, message.getLanguage());
                            stat.setString(9, message.getNationality());
                            stat.setString(10, message.getChannel());
                            stat.setString(11, message.getDob());
                            stat.setString(12, message.getLocalDob());
                            stat.setString(13, message.getActivationType());
                            stat.setString(14, message.getCustomerStatus());
                            stat.setInt(15, Integer.parseInt(message.getCustomerId()));
                            stat.setString(16, message.getReg_document_type());
                            stat.setString(17, message.getReg_document_number());
                            stat.setString(18, message.getCreated_user());
                            stat.setString(19, message.getDocumentIssueDate());
                            stat.setString(20, message.getIsMinor());
                            stat.setString(21, message.getOccupation());
                            stat.setString(22, message.getEmployer());
                            stat.setString(23, message.getPosition());
                            stat.setString(24, message.getAverageMonthly_income());
                            stat.setString(25, message.getIdExpiryDate());
                            stat.setString(26, message.getStatusFlag());


                            stat.executeUpdate();

                        }

                    } catch (JsonProcessingException | SQLException exp) {
                        System.out.println(exp.getMessage());
                    }


                }
            };

            var pollerThread = new Thread(poller);

            pollerThread.start();

            pollerThread.join();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}