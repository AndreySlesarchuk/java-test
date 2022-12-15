package by.atmm.java.__early.__topics.reactives.literx.exporter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {
        // List of contacts to export to Excel file.
        List<String[]> dataList = new ArrayList<>();
        dataList.add(new String[]{"Name First", "2022-09-09 09:00", "2022-09-09 09:00", "2022-09-09 10:00", "Test service1", "20", "Client First", "client1@mail.com"});
        dataList.add(new String[]{"Name Second", "2022-09-10 10:00", "2022-09-10 10:00", "2022-09-10 11:30", "Test service2", "20", "Client Second", "client2@mail.com"});

        // Header text
        String[] headers = {"STAFF", "DATE", "START TIME", "END TIME", "SERVICE", "PRICE", "CLIENT", "CLIENT PHONE"};

        // File name
        String fileName = "clients-appointments.xlsx";

        // Export Excel file
        ExcelFileExporter excelFileExporter = new ExcelFileExporter();
        excelFileExporter.exportExcelFile(dataList, headers, fileName);

    }
}