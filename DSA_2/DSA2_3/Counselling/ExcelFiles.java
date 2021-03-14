package Counselling;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class ExcelFiles {
    public Queue<Student> readFileStudent() {
        Queue<Student> q = new LinkedList<Student>();
        try {
            // obtaining input bytes from a file
            FileInputStream fis = new FileInputStream(new File(
                    "./Data/students.xls"));
            // creating workbook instance that refers to .xls file
			HSSFWorkbook wb = new HSSFWorkbook(fis);
            // creating a Sheet object to retrieve the object
            HSSFSheet sheet = wb.getSheetAt(0);
            // get row no
            int rowNo = sheet.getLastRowNum();
            // Get cell no
            int cellNo = sheet.getRow(0).getLastCellNum();
            // This is used to extract data and add it to queue
            for (int row = 1; row <= rowNo; row++) {
                Student stu = new Student(sheet.getRow(row).getCell(0)
                        .toString());
                List<String> br = new ArrayList<String>();
                for (int cell = 1; cell < cellNo; cell++) {
                    br.add(sheet.getRow(row).getCell(cell).toString());
                }
                stu.setBranch(br);
                q.add(stu);
            }
            wb.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return q;

    }

    public HashMap<String, Integer> readPrograms() {

        HashMap<String, Integer> map = new HashMap<>();
        try {
            // obtaining input bytes from a file
            FileInputStream fis = new FileInputStream(new File(
                    "./Data/programs.xls"));

            // creating workbook instance that refers to .xls file
            HSSFWorkbook wb = new HSSFWorkbook(fis);

            // creating a Sheet object to retrieve the object
            HSSFSheet sheet = wb.getSheetAt(0);

            // get row no
            int rowNo = sheet.getLastRowNum();
            // This is used to extract data and store it into hashmap
            for (int row = 1; row <= rowNo; row++) {
                String cap = (sheet.getRow(row).getCell(1)).toString();
                int capacity = (int) Float.parseFloat(cap);
                map.put(sheet.getRow(row).getCell(0).toString(), capacity);
            }
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return map;

    }

    /**
     * This method is used to allocate branch to each student and store it into
     * hashmap
     */
    public HashMap<String, String> compare(HashMap<String, Integer> map,
            Queue<Student> stu) {
        HashMap<String, String> allocate = new HashMap<>();

        for (Student s : stu) {

            // get student name
            String selectedStudent = s.getName();
            String preferredBranch;
            int branchCapasity;

            for (int index = 0; index < s.getBranch().size(); index++) {
                // get branch
                preferredBranch = s.getBranch().get(index);

                if (map.containsKey(preferredBranch)) {
                    // get capacity of branch
                    branchCapasity = map.get(preferredBranch);

                    if (branchCapasity != 0) {
                        // allocate branch
                        allocate.put(selectedStudent, preferredBranch);
                        map.put(preferredBranch, --branchCapasity);
                        index--;
                        break;
                    }
                }
            }
        }
        // System.out.print(allocate);
        return allocate;
    }

    /**
     * This method is used to write data to excel sheet
     * 
     * @param args
     */
    public void writeToExcel(HashMap<String, String> map) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();

        int rowCount = 0;

        Row row = sheet.createRow(rowCount);

        Cell cell = row.createCell(0);
        cell.setCellValue("Student Name");
        cell = row.createCell(1);
        cell.setCellValue("Allocated Program");

        for (String studentName : map.keySet()) {
            row = sheet.createRow(++rowCount);

            cell = row.createCell(0);
            cell.setCellValue(studentName);
            cell = row.createCell(1);
            cell.setCellValue(map.get(studentName));
        }
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(
                    "./Data/map.xls");
            workbook.write(outputStream);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ExcelFiles e = new ExcelFiles();
        Queue<Student> stv = e.readFileStudent();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, String> allocate = new HashMap<String, String>();
        map = e.readPrograms();
        allocate = e.compare(map, stv);
        e.writeToExcel(allocate);
        Scanner scan = new Scanner(System.in);
        System.out.println("Program allocated successfully..");
        scan.close();
    }
}